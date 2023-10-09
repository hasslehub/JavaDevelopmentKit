package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {
    public static final String LOG_PATH = "src/main/java/org/example/server/log.txt";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int POS_X = 650;
    private static final int POS_Y = 200;
    public static int STATUS = 0;
    List<ClientGUI> clientGUIList;
    private JTextArea log;
    private JTextField tfMessage;
    private JButton btnStart, btnStop;



    ServerWindow() {
        clientGUIList = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(POS_X, POS_Y);
        setTitle("Chat server");
        setResizable(false);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createButtons(){
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    /*
    private Component createTextVew(){
        return ;
    }
    */
    private Component createFooter(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createButtons());
        clickButton();
        return panel;
    }

    private void clickButton() {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
    }

    private void stopServer() {
        switch (STATUS) {
            case 1 -> {
                STATUS = 0;
                log.append("Сервер остановлен.\n");
                System.out.println("Сервер остановлен.\n");
            }
            case 0 -> {
                log.append("Сервер уже остановлен!\n");
                System.out.println("Сервер остановлен.\n");
            }
        }
    }

    private void startServer() {
        switch (STATUS) {
            case 0 -> {
                log.append("Сервер запущен.\n");
                STATUS = 1;
            }
            case 1 ->
                    log.append("Сервер уже запущен!\n");
        }
    }

    public void message(String text){
        if (STATUS == 0){
            return;
        }
        text += "";
        saveLog(text);
        answerAll(text);
    }

    private void saveLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void answerAll(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getLog() {
        return readLog();
    }
}

