package org.example.server;

import org.example.client.Client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static int x, y;
    private Server server;

    List<Client> clientList;

    JButton btnStart, btnStop;
    JTextArea log;


    public ServerWindow(Server server){
        this.server = server;
        clientList = new ArrayList<>();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }



    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

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

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    public void appendLog(String text){
        log.append(text + "\n");
    }

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }



    @Override
    public void startServer() {
        if (server.status()){
            showMessage("Сервер уже был запущен");
        } else {
            server.work = true;
            showMessage("Сервер запущен!");
        }
    }

    @Override
    public void stopServer() {
        if (!server.status()){
            showMessage("Сервер уже был остановлен");
        } else {
            server.work = false;
            for (Client client: clientList){
                server.disconnectUser(client);
            }
            //TODO поправить удаление
            showMessage("Сервер остановлен!");
        }
    }
}
