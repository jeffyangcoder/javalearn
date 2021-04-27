package com.ecc.javalanguage.web.net;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebReader extends JFrame{
    JTextArea box = new JTextArea("Trying connecting..");

    public WebReader(){
        super("Get File Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,300);
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }

    void getData(String address)throws MalformedURLException {
        setTitle(address);
        URL page = new URL(address);
        StringBuilder text = new StringBuilder();

        try {
            HttpURLConnection conn =(HttpURLConnection)
                    page.openConnection();
            conn.connect();
            InputStreamReader in = new InputStreamReader(
                    (InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in);
            box.setText(text.toString());
            String line;
            do {
                line = buff.readLine();
                text.append(line);
                text.append("\n");
            }while (line != null);
            box.setText(text.toString());
        } catch (IOException e) {
            System.out.println("IO ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Usage: java WebReader url");
            System.exit(1);
        }
        try {
            WebReader app = new WebReader();
            app.getData(args[0]);
        } catch (MalformedURLException e) {
            System.out.println("Bad URL: " + args[0]);
        }
    }
}
