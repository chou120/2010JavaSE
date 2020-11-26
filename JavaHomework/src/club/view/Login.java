package club.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 5:05 下午
 */
public class Login  extends JFrame {
  static int s=0;

  @Override
  public Graphics getGraphics() {
    return super.getGraphics();
  }

  public Login()  {
    Yanzhencode vcode = new  Yanzhencode();
    setSize(300,290);//设计窗体的大小
//    ImageIcon image = new ImageIcon(Login.class.getClassLoader()
//        .getResource("/Users/sanye/2010/2010JavaSE/img/3674d4af97ed9dd7c21fc603b8d4f1b2.jpg"));
//
//    final Graphics graphics = getGraphics();
//    graphics.drawImage(image.getImage(), 300, 300, null);

    setTitle("请登录");
    setBackground(Color.RED);//设置背景颜色

    JLabel a=new JLabel("登录名"); //实例化JLabel对象
    JLabel b=new JLabel("密    码");
    JLabel g=new JLabel("忘记用户名/密码？");
    JLabel h=new JLabel("验证码");
    g.setForeground(Color.BLUE);
    JTextField c=new JTextField(15);//用户名文本框
    JPasswordField d=new JPasswordField(15);//密码框
    JTextField k=new JTextField(4);//验证码框
    d.setEchoChar('*');//将输入密码框中的密码以*显示出来
    JButton e=new JButton("登录");
    JButton f=new JButton("快速注册");
    e.setBackground(Color.YELLOW);//设置登录按钮字体颜色
    f.setForeground(Color.GRAY);//设置快速登录按钮填充色
    setVisible(true);//使窗体可视化
    Container m=getContentPane();//获取一个容器
    getContentPane().setBackground(Color.WHITE);//设置窗体填充色
//        将用户名、密码的Jlabel和用户名JTextField文本框、密码JPasswordField密码框以及确定JButton、快速注册JButton添加到container容器里面                         //
    m.add(a);
    m.add(b);
    m.add(c);
    m.add(d);
    m.add(e);
    m.add(f);
    m.add(g);
    m.add(h);
    m.add(k);
    m.add(vcode);

    setBounds(300,300,300,300);//设置窗体的长宽各为300、300  让其显示在左上方的300、300处
    m.setLayout(null);
//        a、b、c、d、e、f显示在container容器中的位置坐标
    a.setBounds(10,40,50,18);
    b.setBounds(10,80,50,18);
    c.setBounds(60,40,130,18);
    d.setBounds(60,80,130,18);
    h.setBounds(10,120,50,18);
    k.setBounds(60,120,80,18);
    e.setBounds(90,180,100,30);
    f.setBounds(90,220,100,30);
    g.setBounds(190,75,100,30);
    vcode.setBounds(140,110,80,30);
    e.addActionListener(new ActionListener() {//对登录按钮添加监听事件

      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent arg0) {

        System.out.println(vcode.getCode()+"-----"+k.getText());

        if(c.getText().trim().equals("xiaoyang")&&new String(d.getPassword()).equals("123456")&&s==1) {//equals函数进行用户名和密码的匹配
          JOptionPane.showMessageDialog(null,"登录成功");

          System.out.println("登录成功");

        }else if(c.getText().trim().equals("xiaoyang")&&new String(d.getPassword()).equals("123456")&&s==0) {
          JOptionPane.showMessageDialog(null,"验证码输入错误");
        }else {
          JOptionPane.showMessageDialog(null, "登录失败,用户名、密码或验证码输入错误");
        }
      }
    });
    f.addActionListener(new ActionListener(){//对快速注册按钮添加监听事件
      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        new Register();//进入都到注册窗体中
        setVisible(false);//进入注册窗体之后关闭登录窗体
      }
    });
    //判断输入验证码是否正确
    if(k.getText()== null) {
      s=0;
    }else if(vcode.getCode() == null) {
      s=1;
    }else if(vcode.getCode().equals(k.getText())) {
      s=1;
    }else {
      s=0;
    }
  }

  public static void main(String[] args) {
      new  Login();
  }
}
