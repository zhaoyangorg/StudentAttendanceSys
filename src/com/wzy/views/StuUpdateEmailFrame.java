package com.wzy.views;

import com.wzy.model.StudentDao;
import com.wzy.model.StudentDaoImp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Y_Y DE YI on 2015/6/24.
 */
public class StuUpdateEmailFrame extends JFrame {
    //设置父窗口的属性
    private StuInfoFrame stuInfoFrame = null;
    private static final int DEFAULT_WIDTH = 340;
    private static final int DEFAULT_HEIGHT = 210;
    private Integer student_id;
    JLabel emailJLabel;
    JTextField emailJTextField;
    JPanel JPanel01, JPanel02, JPanel1;
    JButton comfirmJButton, returnJButton;

    public StuUpdateEmailFrame(StuInfoFrame frame, Integer stuId) {
        this.student_id = stuId;
        this.stuInfoFrame = frame;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("修改个人邮箱");
        setLayout(new BorderLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx / 3, screenHeightpx / 3);
        setLocationByPlatform(false);
        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();
        setIconImage(img);
        //JPanel01
        JPanel1 = new JPanel();
        JPanel1.setLayout(null);
        JPanel01 = new JPanel();
        TitledBorder tb = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "修改邮箱");
        JPanel01.setBorder(tb);
        JPanel01.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel01.setBounds(0, 0, 330, 140);
        emailJLabel = new JLabel("邮箱地址");
        emailJTextField = new JTextField(20);
        JPanel01.add(emailJLabel);
        JPanel01.add(emailJTextField);
        JPanel1.add(JPanel01);
        add(JPanel1, "Center");

        //JPanel02
        JPanel02 = new JPanel();
        JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
        comfirmJButton = new JButton("确认修改");
        returnJButton = new JButton("返回上级菜单");
        JPanel02.add(comfirmJButton);
        JPanel02.add(returnJButton);
        add(JPanel02, "South");

        //绑定事件
        comfirmJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String email = emailJTextField.getText();
                        if (!email.equals("")) {
                            StudentDao studentDao = new StudentDaoImp();
                            studentDao.updateEmail(student_id, email);
                            JOptionPane.showMessageDialog(null, "修改成功");
                            StuUpdateEmailFrame.this.dispose();
                            stuInfoFrame.setEmail(email);
                            stuInfoFrame.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "邮箱不能为空", "警告", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

            }
        });

        returnJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        StuUpdateEmailFrame.this.dispose();
                        stuInfoFrame.setVisible(true);
                    }
                });

            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }
}
