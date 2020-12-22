package club.banyuan.serial.ext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerialDemo {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<Father> fathers = new ArrayList<>();

    OneSon oneSon = new OneSon();
    oneSon.setOneSonField("one");
    oneSon.setName("one son");

    TwoSon twoSon = new TwoSon();
    twoSon.setTwoSonField("two");
    twoSon.setName("two son");

    fathers.add(oneSon);
    fathers.add(twoSon);

    System.out.println(fathers);

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/Fathers"));

    objectOutputStream.writeObject(fathers);
    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(
        "/Users/liyi/works/repos/banyuan/javase-2061/19.IO/example/05.ObjectSerial/Fathers"));
    Object o = objectInputStream.readObject();
    List<Father> read = (List<Father>) o;

    System.out.println(read);



  }
}
