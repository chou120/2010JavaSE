package club.banyuan.mbm;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentTest {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    Socket socket = new Socket("127.0.0.1", 5000);

    Map<String, String> map = new HashMap<>();
    map.put("name", "a");
    map.put("pwd", "123456");

    String data = "";
    for (Entry<String, String> entry : map.entrySet()) {
      data += entry.getKey() + "=" + entry.getValue();
      data += "&";
    }

    System.out.println(data);
    data = data.substring(0, data.length() - 1);

    // 先写头数据
    OutputStream outputStream = socket.getOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    printStream.println("POST /server/user/login HTTP/1.1");
    printStream.println("Content-Length: " + data.toCharArray().length);
    printStream.println("Host: " + "127.0.0.1");
    printStream.println();
    printStream.println(data);

    InputStream inputStream = socket.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    String s = reader.readLine();

    String sessionId = null;
    while (s != null && s.length() > 0) {
      System.out.println(s);
      if (s.startsWith("Set-Cookie: ")) {
        sessionId = s.replaceAll("Set-Cookie: SESSIONID=", "");
      }
      s = reader.readLine();
    }

    ExecutorService executorService = Executors.newFixedThreadPool(100);
    String sessionIdReq = sessionId;
    List<Future<String>> futureList = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      int num = i;
      Future<String> submit = executorService.submit(new Callable<String>() {
        @Override
        public String call() {
          try {
            Socket socket = new Socket("127.0.0.1", 5000);

            Map<String, String> map = new HashMap<>();
            map.put("name", "contest" + num);
            map.put("pwd", "123456");
            map.put("pwdConfirm", "123456");
            map.put("userType", "0");
            // id=0&name=1&pwd=2&pwdConfirm=3&userType=0

            String data = "";
            for (Entry<String, String> entry : map.entrySet()) {
              data += entry.getKey() + "=" + entry.getValue();
              data += "&";
            }

            System.out.println(data);
            data = data.substring(0, data.length() - 1);

            // 先写头数据
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("POST /server/user/modify HTTP/1.1");
            printStream.println("Content-Length: " + data.toCharArray().length);
            printStream.println("Cookie: SESSIONID=" + sessionIdReq);
            printStream.println("Host: " + "127.0.0.1");
            printStream.println();
            printStream.println(data);

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String firstLine = "";
            String s = reader.readLine();
            firstLine = s;
            Thread.sleep(1000);
            socket.close();
            return firstLine;
          } catch (IOException e) {
            e.printStackTrace();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return "fail";
        }
      });
      futureList.add(submit);
    }

    executorService.shutdown();
    try {
      executorService.awaitTermination(1000, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    FileInputStream fileInputStream = new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/21.MarketBillManager/user.json");

    UserService userService = JSONObject
        .parseObject(fileInputStream, StandardCharsets.UTF_8, UserService.class);
    List<User> userList = userService.getUserList();
    userList.sort(new Comparator<User>() {
      @Override
      public int compare(User o1, User o2) {
        try {
          return Integer.parseInt(o1.getName().replaceAll("contest", "")) - Integer
              .parseInt(o2.getName().replaceAll("contest", ""));
        } catch (NumberFormatException e) {
          return 0;
        }
      }
    });

    System.out.println(userList.size());
    System.out.println(userList.get(0));
    System.out.println(userList.get(userList.size() - 1));

    List<String> rlt = new ArrayList<>();

    for (Future<String> future : futureList) {
      rlt.add(future.get());
    }

    rlt.sort(String::compareTo);
    System.out.println(rlt.size());
    System.out.println(rlt.get(0));
    System.out.println(rlt.stream().filter("fail"::equals).count());
    System.out.println(rlt.get(rlt.size() - 1));

  }

}
