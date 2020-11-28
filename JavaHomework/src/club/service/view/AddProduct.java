package club.service.view;

import java.awt.Container;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/27 5:05 下午
 */
public class AddProduct extends JFrame {

  public AddProduct(){

    JLabel a=new JLabel("产品名称"); //实例化JLabel对象
    JLabel b=new JLabel("生产时间");
    JLabel h=new JLabel("产    地");

    JTextField c=new JTextField(15);//产品名称文本框
    JPasswordField d=new JPasswordField(15);//时间文本框
    JTextArea jTextArea=new JTextArea("");//产地

    JButton e=new JButton("添加");
    JButton f=new JButton("重置");
    setVisible(true);
    //获取一个容器
    Container m=getContentPane();
//        将用户名、密码的Jlabel和用户名JTextField文本框、密码JPasswordField密码框以及确定JButton、快速注册JButton添加到container容器里面
    m.add(a);
    m.add(b);
    m.add(h);
    m.add(jTextArea);
    m.add(c);
    m.add(d);
    m.add(e);
    m.add(f);

    setBounds(300,250,300,400);
    m.setLayout(null);
//        a、b、c、d、e、f显示在container容器中的位置坐标
    a.setBounds(10,40,100,18);
    b.setBounds(10,80,100,18);
    h.setBounds(10,120,100,18);
    c.setBounds(60,40,200,18);
    d.setBounds(60,80,200,18);
    jTextArea.setBounds(70,105,180,50);
    e.setBounds(100,160,60,30);
    f.setBounds(30,160,60,30);


    e.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
          //TODO  添加功能
        //    添加的时候如果日期输入框中的数据格式不正确,给出提示
        //        JOptionPane.showMessageDialog(null, "请输入正确的日期格式,如:2020年01月01日");


        //如果添加成功,那么就直接打开详情窗体
        setVisible(false);
        Main.start();
        System.out.println("添加信息确定功能...");
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });
    f.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        //TODO  重置功能,清空文本框中的内容
        System.out.println("重置信息功能...");
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });


  }

}
