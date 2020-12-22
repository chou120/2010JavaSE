import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomStudentsRefine {

  private static final String BASE_LOCATION = "/Users/liyi/works/repos/banyuan/javase-2061/Others/RandomStudents/result/";
  private static final String RESULT_LOCATION = BASE_LOCATION + "CourseAns.json";
  private static final String HOME_WORK_LOCATION = BASE_LOCATION + "HomeWork.json";
  private static String fileLocation = RESULT_LOCATION;
  public static final String[] studentNames = {
      "陈柄佐", "阮佳鑫", "石俊龙", "苏胜宏", "张旭东",
      "陈鹏", "杨金陵", "谢海飞", "陈鹏(南林)", "刘源",
      "朱璋赟", "韩晓杰", "张斌钦", "杨慎慧", "杨永刚", "胡超瑞",
  };

  public static void main(String[] args) throws IOException {
    if (args.length > 0) {
      fileLocation = HOME_WORK_LOCATION;
    }
    List<StudentResult> studentResults = loadFromFile();
    appendStudentNames(studentResults);
    List<StudentResult> readyForChoose = generateStudentsForChoose(studentResults);
    StudentResult one = chooseOne(readyForChoose);
    answerQuestion(one);
    studentResults
        .sort((o1, o2) -> o2.getQuestionResultList().size() - o1.getQuestionResultList().size());
    saveToFile(studentResults);
  }

  private static void saveToFile(List<StudentResult> studentResults) throws IOException {
    File file = new File(fileLocation);
    JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
    String s = JSONObject.toJSONString(studentResults, SerializerFeature.PrettyFormat,
        SerializerFeature.WriteDateUseDateFormat);
    FileWriter fileWriter = new FileWriter(file);
    fileWriter.write(s);
    fileWriter.close();
  }

  private static void answerQuestion(StudentResult one) {
    System.out.println(one.getName());
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      if (s.trim().length() > 0) {
        one.getQuestionResultList().add(new QuestionResult(s.trim().toUpperCase()));
        break;
      }
    }
  }

  private static StudentResult chooseOne(List<StudentResult> readyForChoose) {
    int index = (int) (Math.random() * readyForChoose.size());
    return readyForChoose.get(index);
  }

  private static List<StudentResult> generateStudentsForChoose(List<StudentResult> studentResults) {
    Optional<StudentResult> min = studentResults.stream()
        .min(Comparator.comparing(studentResult -> studentResult
            .getQuestionResultList().size()));
    if (min.isEmpty()) {
      throw new RuntimeException("没有可选用户！");
    }

    return studentResults.stream()
        .filter(t -> t.getQuestionResultList().size() <= min.get().getQuestionResultList().size())
        .collect(
            Collectors.toList());
  }

  private static void appendStudentNames(List<StudentResult> studentResults) {
    for (String studentName : studentNames) {
      StudentResult one = new StudentResult(studentName);
      if (!studentResults.contains(one)) {
        studentResults.add(one);
      }
    }
  }

  private static List<StudentResult> loadFromFile() throws IOException {
    File file = new File(fileLocation);
    if (!file.exists()) {
      file.createNewFile();
    }

    List<StudentResult> studentResults;

    if (file.length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

      String line = reader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        line = reader.readLine();
      }

      studentResults = JSONObject
          .parseArray(stringBuilder.toString(), StudentResult.class);
      reader.close();
    } else {
      studentResults = new ArrayList<>();
    }

    return studentResults;
  }


}