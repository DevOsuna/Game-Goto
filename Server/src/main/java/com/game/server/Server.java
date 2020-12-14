package com.game.server;

import com.game.model.Player;
import com.game.server.model.ClientHandler;
import com.game.server.util.ConnectionSocketUtil;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    public static ArrayList<Socket> socketsClients;

    public Server() {
        socketsClients = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();
    }

    @Override
    public void run() {

        Socket socketClient = null;
        ServerSocket serverSocket;
        ObjectOutputStream output;
        ObjectInputStream input;

        try {
            serverSocket = new ServerSocket(ConnectionSocketUtil.PORT);

            while (!serverSocket.isClosed()) {

                socketClient = null;

                // Waiting for client...
                socketClient = serverSocket.accept();

                // Add new client
                socketsClients.add(socketClient);

                // Notify how much clients (Players) exist
                Player player = new Player();
                player.setNumRivals(socketsClients.size());
                notifyClients(player);

                // Leave the client listening...
                ClientHandler thread = new ClientHandler(socketClient);
                thread.start();

            }

        } catch(EOFException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyClients(Player player) throws IOException {

        ObjectOutputStream output;

        for (Socket s: socketsClients) {

            if (s.isConnected()) {
                output = new ObjectOutputStream(s.getOutputStream());
                output.writeObject(player);
            }
        }
    }
}
