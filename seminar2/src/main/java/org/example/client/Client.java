package org.example.client;

import org.example.server.Server;


public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;


    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name, String pass){
        this.name = name;
        if (server.connectUser(this)){
            printText(name + " Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                printText(log);
            }
            server.clientAction(name + "  подключен к серверу");
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    //мы посылаем
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }


    //нам посылают
    public void serverAnswer(String answer){
        printText(answer);
    }

    public void disconnect(){
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.clientAction(name + "  отключен от сервера");
            //server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }


    private void printText(String text){
        clientView.showMessage(text);
    }
}
