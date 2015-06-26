package com.wzy.views;

import com.wzy.bean.SelectInfo;
import com.wzy.bean.StudentInfo;
import com.wzy.model.StudentDao;
import com.wzy.model.StudentDaoImp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.List;

public class StuFuncPortalFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 450;
    private StudentDao studentDao = new StudentDaoImp();
    private Integer stuId;
    private String stuPwd;
    private List resultAll, teachersInfo, coursesinfo;
    JPanel JPane101, JPane102, JPanel03, JPanel04, p1, p2;
    JLabel StudentID, StuPicture, courseId;
    JButton Button1, Button2, Button3, Button4, Button5, Button6;
    JTextField courseIdTextField;
    JTable resultJTable;

    public StuFuncPortalFrame(Integer student_id, String student_login_pwd) {
        this.stuId = student_id;
        this.stuPwd = student_login_pwd;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("考勤客户端-学生端");
        setLayout(null);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx / 3, screenHeightpx / 3);
        setLocationByPlatform(false);
        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();
        setIconImage(img);
        //JPane101
        JPane101 = new JPanel();
        Integer it = new Integer(stuId);
        String str = it.toString();
        StudentID = new JLabel(str);
        p1 = new JPanel();
        JPane101.setLayout(new FlowLayout(FlowLayout.CENTER));
        StuPicture = new JLabel();
        StuPicture.setSize(150, 135);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/005.jpg"));
        image.setImage(image.getImage().getScaledInstance(
                StuPicture.getWidth(), StuPicture.getHeight(),
                Image.SCALE_DEFAULT));
        StuPicture.setIcon(image);
        JPane101.add(StuPicture);
        JPane101.add(StudentID);
        p1.setBorder(BorderFactory.createEtchedBorder());
        p1.setBounds(0, 0, 155, 180);
        p1.setLayout(null);
        JPane101.setBounds(2, 2, 150, 175);
        p1.add(JPane101);
        add(p1);
        //JPane102
        JPane102 = new JPanel();
        p2 = new JPanel();
        JPane102.setLayout(new BoxLayout(JPane102, BoxLayout.Y_AXIS));
        Button1 = new JButton("查看个人信息");
        Button2 = new JButton("修改个人信息");
        Button3 = new JButton("修改个人密码");
        Button4 = new JButton("查看教师信息");
        Button5 = new JButton("查看课程信息");
        JPane102.add(Button1);
        JPane102.add(Button2);
        JPane102.add(Button3);
        JPane102.add(Button4);
        JPane102.add(Button5);

        p2.setBounds(0, 180, 155, 230);
        p2.setBorder(BorderFactory.createEtchedBorder());
        p2.add(JPane102);
        add(p2);
        //设置事件
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        StuFuncPortalFrame.this.setVisible(false);
                        List<StudentInfo> personInfo = studentDao.personInfo(stuId);
                        new StuInfoFrame(StuFuncPortalFrame.this, personInfo);
                    }
                });

            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, "没有访问权限", "警告", JOptionPane.ERROR_MESSAGE);
                    }
                });

            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        StuFuncPortalFrame.this.setVisible(false);
                        new StuUpdatePwdFrame(StuFuncPortalFrame.this, stuId, stuPwd);
                    }
                });

            }
        });
        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        teachersInfo = studentDao.teacherInfo(stuId);
                        StuFuncPortalFrame.this.setVisible(false);
                        new TeacherInfoFrame(StuFuncPortalFrame.this,teachersInfo);
                    }
                });

            }
        });
        Button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        coursesinfo = studentDao.courseInfo(stuId);
                        StuFuncPortalFrame.this.setVisible(false);
                        new CourseInfoFrame(StuFuncPortalFrame.this, coursesinfo);
                    }
                });

            }
        });


        //JPane104
        JPanel04 = new JPanel();
        JPanel04.setLayout(new BorderLayout());
        JPanel04.setBorder(BorderFactory.createEtchedBorder());
        JPanel04.setBounds(160, 70, 330, 345);


        String[] headers = {"考勤时间", "考勤课程", "考勤结果"};
        Object[][] cellData = null;

        DefaultTableModel model = new DefaultTableModel(cellData, headers) {

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultJTable = new JTable(model);
        resultJTable.getTableHeader().setReorderingAllowed(false);   //设置列不可移动
        //table .getTableHeader().setResizingAllowed(false);	     //设置列宽不可变

        //设置列宽
        int columncount = this.resultJTable.getColumnCount();
        for (int i = 1; i < columncount; i++) {
            this.resultJTable.getColumnModel().getColumn(i).setPreferredWidth(110);
        }
        //FitTableColumns(resultJTable);
        JScrollPane jsp = new JScrollPane(resultJTable);
        JPanel04.add(jsp, "Center");
        add(JPanel04);


        //JPane103
        JPanel03 = new JPanel();
        JPanel03.setBorder(BorderFactory.createEtchedBorder());
        JPanel03.setBounds(160, 0, 340, 70);
        JPanel03.setLayout(new FlowLayout(FlowLayout.LEFT));
        courseId = new JLabel("请输入要查询考勤记录的课程编号");
        courseIdTextField = new JTextField(20);
        courseIdTextField.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        Button6 = new JButton("查询");
        JPanel03.add(courseId);
        JPanel03.add(courseIdTextField);
        JPanel03.add(Button6);
        add(JPanel03);
        //添加查询事件
        Button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(courseIdTextField.getText().equals("")){
                            JOptionPane.showMessageDialog(null, "课程编号不能为空！", "警告", JOptionPane.ERROR_MESSAGE);
                            courseIdTextField.setText("");

                        }else{
                            Integer courseId = Integer.parseInt(courseIdTextField.getText());
                            resultAll = studentDao.couseIdSelect(stuId, courseId);
                            DefaultTableModel tableModel = (DefaultTableModel) resultJTable.getModel();
                            tableModel.setRowCount(0);
                            if (resultAll != null) {
                                for (int i = 0; i < resultAll.size(); i++) {
                                    SelectInfo selectInfo = (SelectInfo) resultAll.get(i);
                                    String[] arr = new String[3];
                                    arr[0] = selectInfo.getRecord_time();
                                    arr[1] = selectInfo.getCourse_name();
                                    arr[2] = selectInfo.getAttendance_status();
                                    tableModel.addRow(arr);
                                }
                        }
                        }


                        resultJTable.invalidate();

                    }
                });

            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);


    }


    public void FitTableColumns(JTable myTable) {               //设置列宽随内容变化而变化
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        Enumeration columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(
                    column.getIdentifier());
            int width = (int) myTable.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(myTable,
                            column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 1; row < rowCount; row++) {
                int preferedWidth = (int) myTable.getCellRenderer(row, col)
                        .getTableCellRendererComponent(myTable,
                                myTable.getValueAt(row, col), false, false,
                                row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column);
            column.setWidth(width + myTable.getIntercellSpacing().width);
        }
    }

}
