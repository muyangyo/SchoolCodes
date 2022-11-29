import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-11-29
 * Time: 15:54
 */

public class MyComputer extends JFrame implements ActionListener {
    JTextField JText1, JText2, JText3; // 3个文本框对象
    JLabel Jlal; // 文本对象
    JButton Jbu; // “=”按钮对象
    JComboBox Jcb;
    JMenuBar B;
    JMenu B_1, B_2;
    JMenuItem I_1, I_2, I_3, I2_1, I2_2;

    // 构造方法，进行初始化
    MyComputer() {
        setTitle("四则计算器");
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout());

        JText1 = new JTextField(5);// 5列，1个汉字占1列，2个数字相当于占1列
        cp.add(JText1);

        Jcb = new JComboBox();
        Jcb.addItem("+");//0
        Jcb.addItem("-");//1
        Jcb.addItem("*");//2
        Jcb.addItem("/");//3
        cp.add(Jcb);


        B = new JMenuBar();
        B_1 = new JMenu("编辑");
        B_2 = new JMenu("帮助");
        B.add(B_1);
        B.add(B_2);

        I_1 = new JMenuItem("复制");
        I_2 = new JMenuItem("粘贴");
        I_3 = new JMenuItem("退出");
        I2_1 = new JMenuItem("帮助");
        I2_2 = new JMenuItem("关于计算机");

        B_1.add(I_1);
        B_1.add(I_2);
        B_1.add(I_3);
        B_2.add(I2_1);
        B_2.add(I2_2);

        setJMenuBar(B);

        JText2 = new JTextField(5);
        cp.add(JText2);

        Jbu = new JButton("=");
        cp.add(Jbu);

        JText3 = new JTextField(20);
        cp.add(JText3);

        JText3.setEditable(false);
        Jbu.addActionListener(this);
        I_3.addActionListener(this);
        I2_1.addActionListener(this);
        I2_2.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {// 实现接口的抽象方法
        String str1 = JText1.getText();
        String str2 = JText2.getText();
        double n1 = 0;// 数1
        double n2 = 0;// 数2
        double result = 0;// 计算结果
        // 首先做非空验证（数1、数2文本框不能为空）

        if (e.getActionCommand().equals("退出")) System.exit(0);//0是正常退出,-1是有问题报错退出
        else if (e.getActionCommand().equals("帮助"))

            JOptionPane.showMessageDialog(MyComputer.this, "执行简单四则运算", "消息", JOptionPane.WARNING_MESSAGE);

        else if (e.getActionCommand().equals("关于计算机"))

            JOptionPane.showMessageDialog(MyComputer.this, "计算机v1.0 ，开发者：匿名", "消息", JOptionPane.WARNING_MESSAGE);


        else if (str1.equals("") || str2.equals("")) {

            if (str1.equals("")) {
                JOptionPane.showMessageDialog(MyComputer.this, "第一个数为空，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (str2.equals("")) {
                JOptionPane.showMessageDialog(MyComputer.this, "第二个数为空，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // 利用异常处理，设置数1、数2文本框只能输入数字
        try {
            n1 = Double.parseDouble(str1);
            n2 = Double.parseDouble(str2);

            int index = Jcb.getSelectedIndex();
            if (index == 0) {
                result = n1 + n2;
            } else if (index == 1) {
                result = n1 - n2;
            } else if (index == 2) {
                result = n1 * n2;
            } else if (index == 3) {
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(MyComputer.this, "除法运算时，分母不为零", "警告", JOptionPane.WARNING_MESSAGE);
                    JText2.setText("");
                } else {
                    result = n1 / n2;
                }
            }
            //限制两位输出
            String s=String.format("%.2f", result);
            JText3.setText(s+"      //限制两位输出,自动进位");


        } catch (NumberFormatException e1) {
            JText1.setText("");
            JText2.setText("");
            JText3.setText("");
            JOptionPane.showMessageDialog(MyComputer.this, "错误,请重新输入!", "err", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void main(String[] args) {
        MyComputer t = new MyComputer();
        t.pack();// 自动调整窗口大小
        t.setVisible(true);// 设置窗体可见
        t.setSize(800, 200);// 设置窗体大小
        t.setLocation(300, 300);// 设置窗体位置，原点在屏幕左上角
    }
}