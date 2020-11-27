package club.service.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/11/26 8:08 下午
 */
public class MyButtonRender implements TableCellRenderer {

  private JPanel jPanel;
  private JButton jButton;

  public MyButtonRender() {
    initJPanel();
    initButton();
    jPanel.add(jButton);
  }

  private void initButton() {
    jButton = new JButton();
    jButton.setBounds(0, 0, 80, 30);
    jButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

        System.out.println(">>>>>>>>"+e.getButton());

      }

      @Override
      public void mousePressed(MouseEvent e) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        System.out.println(">>>>>>>>>>------>>>>>>>>>>>>");

      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println(">>>>>>>exited>>>>>>>>>>>>>>>");

      }
    });

  }

  private void initJPanel() {
    jPanel = new JPanel();
    jPanel.setLayout(null);
  }

  @Override
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    jButton.setText("删除");
    return jPanel;
  }
}
