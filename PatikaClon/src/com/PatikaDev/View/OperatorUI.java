package com.PatikaDev.View;

import com.PatikaDev.Helper.Config;
import com.PatikaDev.Helper.Helper;
import com.PatikaDev.Model.Operator;
import com.PatikaDev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userlist;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private Operator operator;

    public OperatorUI(Operator operator){
        this.operator = operator;

        add(wrapper);
        setSize(1000,500);

        int x = Helper.screenCenter("x",getSize());
        int y = Helper.screenCenter("y",getSize());
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldiniz " + operator.getName());

        //ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Ad Soyad", "Kulanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);


        for(User user : User.getList()){
            Object[] row = new Object[col_user_list.length];
            row[0] =  user.getId();
            row[1] = user.getName();
            row[2] = user.getUserName();
            row[3] = user.getPassword();
            row[4] = user.getType();
            mdl_user_list.addRow(row);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

    }
}
