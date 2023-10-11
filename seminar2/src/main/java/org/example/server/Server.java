package org.example.server;

import org.example.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server{
    boolean work;
    List<Client> clientList;
    private Repository repo;
    private ServerWindow view;

    public Server() {
        clientList = new ArrayList<>();
        this.repo = new Repository();
        this.view = new ServerWindow(this);
    }


    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public String getHistory() {
        return repo.readLog();
    }


    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
//        text += "";
        view.appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void saveInLog(String text){
        repo.addMessageInLog(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    public boolean status() {
        return work;
    }



//public int getX() {

    //    return x;
    //}
}
