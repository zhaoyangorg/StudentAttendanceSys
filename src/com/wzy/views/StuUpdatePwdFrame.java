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
public class StuUpdatePwdFrame extends JFrame {
    //设置父窗口的属性
    private StuFuncPortalFrame sfpFrame = null;
    private static final int DEFAULT_WIDTH = 340;
    private static final int DEFAULT_HEIGHT = 210;
    private Integer student_id;
    private String student_login_pwd;
    JLabel currentPwdJLabel,newPwdJLabel,confirmPwdJLabel;
    JPasswordField currentPwdJPasswordField,newPwdJPasswordField,confirmPwdJPasswordField;
    JPanel JPanel01,JPanel02,JPanel1;
    JButton comfirmJButton,returnJButton;
    public StuUpdatePwdFrame(StuFuncPortalFrame frame,Integer stuId,String stuPwd){
        this.student_id = stuId;
        this.student_login_pwd = stuPwd;
        this.sfpFrame = frame;
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("修改个人密码");
        setLayout(new BorderLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx/3,screenHeightpx/3);
        setLocationByPlatform(false);
        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();
        setIconImage(img);
        //JPanel01
        JPanel1 = new JPanel();
        JPanel1.setLayout(null);
        JPanel01 = new JPanel();
        TitledBorder tb = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black,1),"修改密码");
        JPanel01.setBorder(tb);
        JPanel01.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel01.setBounds(0, 0, 330, 140);
        currentPwdJLabel = new JLabel("当前密码");
        currentPwdJPasswordField = new JPasswordField(20);
        newPwdJLabel = new JLabel("    新密码");
        newPwdJPasswordField = new JPasswordField(20);
        confirmPwdJLabel = new JLabel("确认密码");
        confirmPwdJPasswordField = new JPasswordField(20);
        JPanel01.add(currentPwdJLabel);
        JPanel01.add(currentPwdJPasswordField);
        JPanel01.add(newPwdJLabel);
        JPanel01.add(newPwdJPasswordField);
        JPanel01.add(confirmPwdJLabel);
        JPanel01.add(confirmPwdJPasswordField);
        JPanel1.add(JPanel01);
        add(JPanel1,"Center");

        //JPanel02
        JPanel02 = new JPanel();
        JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
        comfirmJButton = new JButton("确认修改");
        returnJButton = new JButton("返回上级菜单");
        JPanel02.add(comfirmJButton);
        JPanel02.add(returnJButton);
        add(JPanel02,"South");

        //绑定事件
        comfirmJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        String currentPwd = new String(currentPwdJPasswordField.getPassword());
                        String newPwd = new String(newPwdJPasswordField.getPassword());
                        String confirmPwd = new String(confirmPwdJPasswordField.getPassword());
                        if(currentPwd.equals(student_login_pwd)){
                            if(newPwd.equals(confirmPwd)){
                                StudentDao studentDao = new StudentDaoImp();
                                studentDao.updatePwd(student_id,newPwd);
                                JOptionPane.showMessageDialog(null,"修改成功");
                                StuUpdatePwdFrame.this.dispose();
                                new StuLoginFrame();

                            }else{
                                JOptionPane.showMessageDialog(null,"两次输入的密码不一样","消息",JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null,"当前密码不正确","消息",JOptionPane.ERROR_MESSAGE);
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
                        StuUpdatePwdFrame.this.dispose();
                        sfpFrame.setVisible(true);
                    }
                });

            }
        });





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

    }

}
