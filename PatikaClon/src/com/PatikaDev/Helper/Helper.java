package com.PatikaDev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static int screenCenter(String position, Dimension size){

        int point = 0;
        switch (position){
            case "x":
                point =(Toolkit.getDefaultToolkit().getScreenSize().width -size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }

    public static void setLayout(){
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
}
