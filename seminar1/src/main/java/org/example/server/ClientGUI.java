package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int POS_X = 50;
    private static final int POS_Y = 200;
    private ServerWindow server;
    private boolean connected;
    private String name;
    private JTextField tfMessage, ipAdress, fieldPort, fieldLogin;
    private JTextArea log;
    private JPasswordField fieldPass;
    private Label Stub;
    private JButton btnLogin, btnSend;




    ClientGUI(ServerWindow server) {
        this.server = server;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(POS_X, POS_Y);
        setTitle("Chat client");
        setResizable(false);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);
    }



    private Component createHeaderPanel(){
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        Stub = new Label();
        ipAdress = new JTextField("127.0.0.1");
        fieldPort = new JTextField("8189");
        fieldLogin = new JTextField("Name User");
        fieldPass = new  JPasswordField();
        btnLogin = new JButton("Login");
        headerPanel.add(ipAdress, BorderLayout.NORTH);
        headerPanel.add(fieldPort, BorderLayout.NORTH);
        Stub.setBackground(getBackground());
        headerPanel.add(Stub);
        headerPanel.add(fieldLogin, BorderLayout.SOUTH);
        headerPanel.add(fieldPass, BorderLayout.SOUTH);
        headerPanel.add(btnLogin, BorderLayout.SOUTH);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });
        return headerPanel;
    }

    private Component createLog(){
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createFooter(){
        JPanel footerPanel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        btnSend = new JButton("send");
        footerPanel.add(tfMessage, BorderLayout.CENTER);
        footerPanel.add(btnSend, BorderLayout.EAST);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        return footerPanel;
    }

    private void connectToServer() {
        if (ServerWindow.STATUS == 1){
            log.append("Вы успешно подключились!\n");
            name = fieldLogin.getText();
            String serverLog = server.getLog();
            if (serverLog != null){
                log.append(serverLog);
            }
        } else {
            log.append("Подключение не удалось\n");
        }
    }

    public void sendMessage(){
        if (ServerWindow.STATUS == 1){
            connected = true;
            String text = tfMessage.getText();
            if (!text.equals("")){
                server.message(name + ": " + text);
                tfMessage.setText("");
            }
        } else {
            log.append("Нет подключения к серверу!\n");
        }

    }


    public void answer(String text) {
        log.append(text);
    }
}

