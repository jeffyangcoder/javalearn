package com.ecc.javalanguage.introduce.oracleapi;
import javax.swing.*;
public class Swingtest {
    /**创建并显示GUI**/
    private static void createAndShowGUI(){
        //外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        //创建设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加"Hello World"标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //显示窗口
        frame.pack();
        frame.setVisible(true);
    }

public static void main(String[] args){
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            createAndShowGUI();
        }
    });
}
}
