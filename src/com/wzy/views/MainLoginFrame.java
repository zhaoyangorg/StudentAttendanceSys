package com.wzy.views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Y_Y DE YI on 2015/6/23.
 */
public class MainLoginFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    JLabel picLable;
    JButton stuLoginButton, tchLoginclearButton;
    JPanel  jPanel;
    public MainLoginFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("学生考勤管理系统");
        Toolkit kit = Toolkit.getDefaultToolkit(); //获取默认工具包
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx/3,screenHeightpx/3);
        setLocationByPlatform(false);

        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();

        setIconImage(img);

       //内容


        picLable = new JLabel();
        stuLoginButton = new JButton("点击跳转到学生登陆界面");
        tchLoginclearButton = new JButton("点击跳转到教工登录界面");

        jPanel = new JPanel();
        setLayout(new BorderLayout());
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        picLable.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT/2);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/top2.jpg"));
        image.setImage(image.getImage().getScaledInstance(picLable.getWidth(),picLable.getHeight(),Image.SCALE_DEFAULT));
        picLable.setIcon(image);

        jPanel.add(picLable);
        jPanel.add(stuLoginButton);
        jPanel.add(tchLoginclearButton);
        add(jPanel, BorderLayout.CENTER);
        //绑定事件
        stuLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //MainLoginFrame.this.setVisible(false);
                        MainLoginFrame.this.dispose();
                        new StuLoginFrame();
                    }
                });

            }
        });

        tchLoginclearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //MainLoginFrame.this.setVisible(false);
                        MainLoginFrame.this.dispose();
                        new StuLoginFrame();
                    }
                });

            }
        });
        //

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args){
        MainLoginFrame frame = new MainLoginFrame();
    }

}
