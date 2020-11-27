package club.service.view;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 5:32 下午
 */

import club.service.entity.Product;
import club.service.util.ArrayList;
import club.service.util.DataSource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private Object head[] = null;
  private Object[][] data = null;


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


    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 0, 700, 600);

    head = new Object[]{
        "产品编号", "产品名称", "生产地", "生产时间","操作",
    };
    table = new JTable(queryData(),head);

    table.setBounds(0, 0, 700, 500);
    table.setRowHeight(40);

    scrollPane.setViewportView(table);

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        data[i][3] = simpleDateFormat.format(product.getDate());
      }
    }
    return data;
  }

}