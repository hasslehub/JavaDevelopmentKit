package org.example.server;

import org.example.client.Client;
import org.example.server.repositiry.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server{
    boolean work;
    List<Client> clientList;
    HashMap<String, String> users;
    private Repository repo;
    private ServerView view;

    public Server(ServerView view, Repository repo) {
        clientList = new ArrayList<>();
        this.repo = repo;
        this.view = view;
    }


    public void start() {
        if (status()){
            showOnWindow("Сервер уже был запущен");
        } else {
            work = true;
            showOnWindow("Сервер запущен!");
        }
    }


    public void stop() {
        if (!work){
            showOnWindow("Сервер уже был остановлен");
        }
        else {
            work = false;
            for (int i  = clientList.size() - 1; i >= 0; i--){ // for each что-то не катит
                disconnectUser(clientList.get(i));
            }
            showOnWindow("Сервер остановлен!");
        }
    }


    public void disconnectUser(Client client){
        client.disconnect();
        clientList.remove(client);
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        //repo.addUser(client.getName());
        return true;
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        answerAll(text);
        saveInHistory(text);
    }

    public String getHistory() {
        return repo.readHistory();
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    private void showOnWindow(String text) {view.showMessage(text + "\n");}

    public void clientAction(String text) {
        showOnWindow(text);
    }


    private void saveInHistory(String text){
        repo.save(text);
    }

    public boolean status() {
        return work;
    }
}
