package club.service.view;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 5:32 下午
 */

import club.service.dao.ProductDao;
import club.service.dao.ProductDaoImpl;
import club.service.entity.Product;
import club.service.util.ArrayList;
import club.service.util.DataSource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private Object head[] = null;
  private Object[][] data = null;
  private ProductDao  productDao=new ProductDaoImpl();

  public static void start() {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main frame = new Main();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Main() {

    setTitle("商品详情");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 700, 300);
    Dimension us = this.getSize();
    Dimension them = Toolkit.getDefaultToolkit().getScreenSize();

    int x = (them.width - us.width) / 2;
    int y = (them.height - us.height) / 2;

    this.setLocation(x, y);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    JButton jButton = new JButton("添加产品");
    JTextField jTextFieldJButton2=new JTextField("删除的商品编号"); //输入编号
    JButton jButton2 = new JButton("删除产品");
    JTextField jTextFieldJButton3=new JTextField("修改的商品编号"); //输入编号
    JButton jButton3 = new JButton("修改产品");

    jButton.setBounds(30, 240, 80, 30);

    jTextFieldJButton2.setBounds(120, 240, 100, 30);
    jButton2.setBounds(220, 240, 80, 30);

    jTextFieldJButton3.setBounds(300, 240, 100, 30);
    jButton3.setBounds(400, 240, 80, 30);


    jTextFieldJButton2.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        jTextFieldJButton2.setText("");
        System.out.println("jTextFieldJButton2被聚焦了...");
      }

      @Override
      public void focusLost(FocusEvent e) {
        String str=jTextFieldJButton2.getText();
        if(str!=null&&!str.equals("")){
          jTextFieldJButton2.setText(str);
        }else {
          jTextFieldJButton2.setText("输入商品编号");
        }
        System.out.println("jTextFieldJButton2失焦了...");
      }
    });

    jTextFieldJButton3.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        jTextFieldJButton3.setText("");
        System.out.println("jTextFieldJButton3被聚焦了...");
      }

      @Override
      public void focusLost(FocusEvent e) {
        String str=jTextFieldJButton3.getText();
        if(str!=null && !str.equals("")){
          jTextFieldJButton3.setText(str);
        }else {
          jTextFieldJButton3.setText("输入商品编号");
        }
        System.out.println("jTextFieldJButton3失焦了...");

      }
    });


    jButton.addMouseListener(new MouseListener() {  //添加功能
      @Override
      public void mouseClicked(MouseEvent e) {
          //TODO
        System.out.println("添加按钮...");

        setVisible(false);//设置之前面板关闭
        new  AddProduct(); //打开添加面板


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
    jButton2.addMouseListener(new MouseListener() { //删除 根据产品编号删除
      @Override
      public void mouseClicked(MouseEvent e) {
        //TODO 做删除的时候首先要获取jTextFieldJButton2文本框里面的内容 根据编号删除

        System.out.println("删除按钮...");
        String text = jTextFieldJButton2.getText();//获取要删除的编号
        boolean   flag=productDao.deleteById(text);

        if(flag){
          setVisible(false);//设置之前面板关闭
          Main.start(); //重新显示详情面板
        }else{
            //没有删除成功就给一个提示
        }

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


    jButton3.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        //TODO 首先要将修改产品信息显示到面板中,然后再进行修改
         String proId = jTextFieldJButton3.getText();
         new   UpdateProduct(proId);  //打开一个更新面板
        System.out.println("更新按钮...");

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


    head = new Object[]{
        "产品编号", "产品名称", "生产地", "生产时间",
    };
    table = new JTable(queryData(),head);

    table.setBounds(50, 50, 700, 300);
    table.setRowHeight(40);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 50, 500, 300);

    scrollPane.setViewportView(table);
    table.setVisible(true);


    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
    );
    gl_contentPane.setVerticalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195,
                    GroupLayout.PREFERRED_SIZE)
                .addGap(66))
    );

    contentPane.setLayout(gl_contentPane);
    setContentPane(contentPane);
    add(jButton);
    add(jButton2);
    add(jButton3);
    add(jTextFieldJButton2);
    add(jTextFieldJButton3);


  }

  //生成表格数据

  /**
   * @return
   */
  public Object[][] queryData() {

    ArrayList productArrayList = DataSource.PRODUCT_ARRAY_LIST;
    data = new Object[productArrayList.size()][head.length];
    for (int i = 0; i < productArrayList.size(); i++) {
      for (int j = 0; j < head.length; j++) {
        Product product = (Product) productArrayList.get(i);
        data[i][0] = product.getNumber();
        data[i][1] = product.getProductName();
        data[i][2] = product.getAddress();
        data[i][3] = product.getDate();
      }
    }
    return data;
  }

}