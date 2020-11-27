package club.service.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/25 5:07 下午
 */
public class Register  extends JFrame {

  public  Register(){
    setSize(300,250);//设计窗体的大小
    JLabel a=new JLabel("用户名"); //实例化JLabel对象
    JLabel b=new JLabel("密    码");
    JLabel h=new JLabel("再次确认密码");
    JTextField c=new JTextField(15);//实例化用户名文本框
    JPasswordField d=new JPasswordField(15);//实例化密码文本框
    JPasswordField hd=new JPasswordField(15);//实例化密码文本框
    d.setEchoChar('*');//设置密码隐藏制度
    JButton e=new JButton("确定");
    JButton f=new JButton("重置");
    JButton g=new JButton("返回");
    setVisible(true);
    //获取一个容器
    Container m=getContentPane();
//        将用户名、密码的Jlabel和用户名JTextField文本框、密码JPasswordField密码框以及确定JButton、快速注册JButton添加到container容器里面
    m.add(a);
    m.add(b);
    m.add(h);
    m.add(hd);
    m.add(c);
    m.add(d);
    m.add(e);
    m.add(f);
    m.add(g);
    //设置窗体的长宽各为300、250  让其显示在左上方的300、250处
    setBounds(300,250,300,250);
    m.setLayout(null);
//        a、b、c、d、e、f显示在container容器中的位置坐标
    a.setBounds(10,40,50,18);
    b.setBounds(10,80,50,18);
    h.setBounds(5,120,80,18);
    c.setBounds(60,40,200,18);
    d.setBounds(60,80,200,18);
    hd.setBounds(90,120,180,18);
    e.setBounds(110,160,60,30);
    f.setBounds(30,160,60,30);
    g.setBounds(190,160,60,30);
    g.addActionListener(new ActionListener() {//对返回按钮添加监听事件
      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent arg0) {

        new Login();

      }
    });
    f.addActionListener(new ActionListener() {//对重置按钮添加监听事件
      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);//隐藏之前打开的页面
        new Login();
      }
    });
    e.addActionListener(new ActionListener() {//对确认按钮添加监听事件
      @SuppressWarnings("deprecation")
      @Override
      public void actionPerformed(ActionEvent arg0) {

        //TODO  


        JOptionPane.showMessageDialog(null, "用户信息为空成功");
        setVisible(false);//隐藏之前打开的隐藏
        new Login();  //注册成功之后 打开登录窗体
      }
    });

  }

}
