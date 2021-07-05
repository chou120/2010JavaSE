package club.banyuan.mythread;

/**
 * @author sanye
 * @version 1.0
 * @date 2021/7/5 23:14
 */
public class Test {

    public static void main(String[] args) {
        AddThread add = new AddThread();

        DelThread del = new DelThread();

        Thread A = new Thread(add,"A");
        Thread B = new Thread(add,"B");
        Thread C = new Thread(del,"C");
        Thread D = new Thread(del,"D");


        A.start();
        B.start();
        C.start();
        D.start();

    }

}
