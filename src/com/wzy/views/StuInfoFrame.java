package com.wzy.views;

import com.wzy.bean.StudentInfo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

/**
 * Created by Y_Y DE YI on 2015/6/24.
 */
public class StuInfoFrame extends JFrame {
    //设置父窗口的属性
    private StuFuncPortalFrame sfpFrame = null;
    private static final int DEFAULT_WIDTH = 350;
    private static final int DEFAULT_HEIGHT = 350;
    private  List<StudentInfo> studentinfo;
    private String name,college,major,email;
    private Integer id;
    JPanel JPane1001,JPanel002,JPanel02,JPanel1;
    JLabel nameJLabel,numberJLabel,collegeJLabel,majorJLabel,emailJLabel,infoJLabel,picJLabel;
    JButton updateJButton,upEmailJButton,returnJButton;
    JTextField nameJTextField,numberJTextField,collegeJTextField,majorJTextField,emailJTextField;
    public StuInfoFrame(StuFuncPortalFrame frame, List<StudentInfo> personInfo){
        this.sfpFrame = frame;
        this.studentinfo = personInfo;
        for(int i = 0;i<studentinfo.size();i++){
            name = studentinfo.get(i).getStudent_name();
            id = studentinfo.get(i).getStudent_id();
            college = studentinfo.get(i).getStudent_college();
            major = studentinfo.get(i).getStudent_major();
            email = studentinfo.get(i).getStudent_email();
        }
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("学生个人信息");
        setLayout(new BorderLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx/3,screenHeightpx/3);
        setLocationByPlatform(false);
        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();
        setIconImage(img);

        //JPanel001
        JPanel1 = new JPanel();
        JPanel1.setLayout(null);
        JPane1001 = new JPanel();
        JPane1001.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPane1001.setBounds(0, 0, 180, 340);
        nameJLabel = new JLabel("姓名");
        numberJLabel = new JLabel("学号");
        collegeJLabel = new JLabel("所属学院");
        majorJLabel = new JLabel("所属专业");
        emailJLabel = new JLabel("电子邮箱");
        nameJTextField = new JTextField(15);
        numberJTextField = new JTextField(15);
        collegeJTextField = new JTextField(15);
        majorJTextField = new JTextField(15);
        emailJTextField = new JTextField(15);
        //插入姓名
        nameJTextField.setText(name);
        nameJTextField.setEditable(false);
        //插入学号
        Integer it = new Integer(id);
        String str = it.toString();
        numberJTextField.setText(str);
        numberJTextField.setEditable(false);
        //插入所属学院
        collegeJTextField.setText(college);
        collegeJTextField.setEditable(false);
        //插入所属专业
        majorJTextField.setText(major);
        majorJTextField.setEditable(false);
        //插入电子邮箱
        emailJTextField.setText(email);
        emailJTextField.setEditable(false);




        JPane1001.add(nameJLabel);
        JPane1001.add(nameJTextField);
        JPane1001.add(numberJLabel);
        JPane1001.add(numberJTextField);
        JPane1001.add(collegeJLabel);
        JPane1001.add(collegeJTextField);
        JPane1001.add(majorJLabel);
        JPane1001.add(majorJTextField);
        JPane1001.add(emailJLabel);
        JPane1001.add(emailJTextField);
        JPanel1.add(JPane1001);
        //JPanel002
        JPanel002 = new JPanel();
        JPanel002.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel002.setBounds(200,0,140,180);
        infoJLabel = new JLabel("个人照片");
        picJLabel = new JLabel();
        picJLabel.setSize(140,125);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/005.jpg"));
        image.setImage(image.getImage().getScaledInstance(
                picJLabel.getWidth(),picJLabel.getHeight(),
                Image.SCALE_DEFAULT));
        picJLabel.setIcon(image);
        updateJButton = new JButton("修改个人照片");
        JPanel002.add(infoJLabel);
        JPanel002.add(picJLabel);
        JPanel002.add(updateJButton);
        JPanel1.add(JPanel002);

        add(JPanel1,"Center");

        //添加事件
        updateJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFileChooser chooser = new JFileChooser();
                        chooser.setFileFilter(new FileNameExtensionFilter("image files","jpg","jpeg","gif"));
                        chooser.setCurrentDirectory(new File("."));
                        int result = chooser.showOpenDialog(StuInfoFrame.this);
                        if(result == JFileChooser.APPROVE_OPTION){
                            String fileName = chooser.getSelectedFile().getPath();
                            ImageIcon image = new ImageIcon(fileName);
                            image.setImage(image.getImage().getScaledInstance(
                                    picJLabel.getWidth(),picJLabel.getHeight(),
                                    Image.SCALE_DEFAULT));
                            picJLabel.setIcon(image);
                            sfpFrame.getJLabel().setIcon(image);
                        }

                    }
                });

            }
        });


        //JPanel02
        JPanel02 = new JPanel();
        JPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
        upEmailJButton = new JButton("修改个人邮箱");
        returnJButton = new JButton("返回上级菜单");
        JPanel02.add(upEmailJButton);
        JPanel02.add(returnJButton);
        add(JPanel02,"South");

        //绑定事件
        upEmailJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        StuInfoFrame.this.setVisible(false);
                        new StuUpdateEmailFrame(StuInfoFrame.this, id);

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
                        StuInfoFrame.this.dispose();
                        sfpFrame.setVisible(true);
                    }
                });

            }
        });





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void setEmail(String email) {
        emailJTextField.setText(email);
        emailJTextField.setEditable(false);
    }
}
