package com.wzy.views;

import com.wzy.model.StudentDao;
import com.wzy.model.StudentDaoImp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Y_Y DE YI on 2015/6/23.
 */
public class StuLoginFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    JLabel picLable;
    JLabel idLabel, pwdLabel;
    JTextField stuIdTextField;
    JPasswordField pwdField;
    JButton okButton, clearButton;
    JPanel buttonPanel, infoPanel;
    public StuLoginFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("学生登陆窗口");
        Toolkit kit = Toolkit.getDefaultToolkit(); //获取默认工具包
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx/3,screenHeightpx/3);
        setLocationByPlatform(false);

        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();

        setIconImage(img);

        picLable = new JLabel();
        idLabel = new JLabel("学生ID：");
        pwdLabel = new JLabel("密  码：");
        stuIdTextField  = new JTextField(20);
        stuIdTextField.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        pwdField = new JPasswordField(20);
        okButton = new JButton("登录");
        clearButton = new JButton("重置");

        buttonPanel = new JPanel();
        infoPanel = new JPanel();

        setLayout(new BorderLayout());

        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        picLable.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT/2);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg"));
        image.setImage(image.getImage().getScaledInstance(picLable.getWidth(),picLable.getHeight(),Image.SCALE_DEFAULT));
        picLable.setIcon(image);
        infoPanel.add(picLable);
        infoPanel.add(idLabel);
        infoPanel.add(stuIdTextField);
        infoPanel.add(pwdLabel);
        infoPanel.add(pwdField);
        add(infoPanel,BorderLayout.CENTER);

        buttonPanel.add(okButton);
        buttonPanel.add(clearButton);
        add(buttonPanel,BorderLayout.SOUTH);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(stuIdTextField.getText().trim().equals("")){
                            JOptionPane.showMessageDialog(null, "学生ID信息不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
                            stuIdTextField.setText("");
                        }else if(new String(pwdField.getPassword()).equals("")){
                            JOptionPane.showMessageDialog(null, "密码信息不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
                            pwdField.setText("");
                        }else{
                            Integer student_id = Integer.parseInt(stuIdTextField.getText());
                            String student_login_pwd = new String(pwdField.getPassword());
                            StudentDao studentDao = new StudentDaoImp();
                            boolean flag = studentDao.studentLogin(student_id,student_login_pwd);
                            if(flag){
                                //StuLoginFrame.this.setVisible(false);
                                StuLoginFrame.this.dispose();
                                new StuFuncPortalFrame(student_id,student_login_pwd);
                            }else{
                                JOptionPane.showMessageDialog(null,"请重新输入密码","警告",JOptionPane.ERROR_MESSAGE);
                                pwdField.setText("");
                            }

                        }
                    }
                });

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        stuIdTextField.setText("");
                        pwdField.setText("");
                    }
                });

            }
        });



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }


}
