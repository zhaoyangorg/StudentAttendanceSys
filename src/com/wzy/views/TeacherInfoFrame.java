package com.wzy.views;

import com.wzy.bean.TeacherInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Y_Y DE YI on 2015/6/24.
 */
public class TeacherInfoFrame extends JFrame {
    //设置父窗口的属性
    private StuFuncPortalFrame sfpFrame = null;
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 380;
    private java.util.List<TeacherInfo> teacherInfo;
    JPanel jPanel01, jPanel02;
    JTable resultJTable;
    JButton returnJButton;

    public TeacherInfoFrame(StuFuncPortalFrame frame, java.util.List teachersInfo) {
        this.teacherInfo = teachersInfo;
        this.sfpFrame = frame;
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setTitle("查看教师信息");
        setLayout(new BorderLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidthpx = screenSize.width;
        int screenHeightpx = screenSize.height;
        setLocation(screenWidthpx / 3, screenHeightpx / 3);
        setLocationByPlatform(false);
        Image img = new ImageIcon(this.getClass().getResource("/images/001.jpg")).getImage();
        setIconImage(img);

        //jPanel01
        jPanel01 = new JPanel();
        jPanel01.setLayout(new BorderLayout());
        jPanel01.setBorder(BorderFactory.createEtchedBorder());
        jPanel01.setBounds(1, 1, 498, 300);
        String[] headers = {"姓名", "任课课程", "所属学院"};
        Object[][] cellData = null;
        DefaultTableModel model = new DefaultTableModel(cellData, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultJTable = new JTable(model);
        resultJTable.getTableHeader().setReorderingAllowed(false);   //设置列不可移动
        DefaultTableModel tableModel = (DefaultTableModel) resultJTable.getModel();
        tableModel.setRowCount(0);
        if (teacherInfo != null) {
            for (int i = 0; i < teacherInfo.size(); i++) {
                TeacherInfo teacherInfo1 = (TeacherInfo) teacherInfo.get(i);
                String[] arr = new String[3];
                arr[0] = teacherInfo1.getTeacher_name();
                arr[1] = teacherInfo1.getCourse_name();
                arr[2] = teacherInfo1.getCollege_name();
                tableModel.addRow(arr);
            }

        }


        resultJTable.invalidate();
        //设置列宽
        int columncount = this.resultJTable.getColumnCount();
        for (int i = 1; i < columncount; i++) {
            this.resultJTable.getColumnModel().getColumn(i).setPreferredWidth(150);
        }
        //设置滚动条
        JScrollPane jsp = new JScrollPane(resultJTable);
        jPanel01.add(jsp, "Center");
        add(jPanel01);

        //jPanel02
        jPanel02 = new JPanel();
        jPanel02.setLayout(new FlowLayout(FlowLayout.CENTER));
        returnJButton = new JButton("返回上级菜单");
        jPanel02.add(returnJButton);
        add(jPanel02, "South");
        //设置事件
        //绑定事件
        returnJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        TeacherInfoFrame.this.dispose();
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
