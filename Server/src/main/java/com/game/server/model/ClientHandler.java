package com.game.server.model;

import com.game.model.Player;
import com.game.server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

    private final Socket socket;
    private ObjectInputStream inputStream;

    public ClientHandler(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        super.run();

        Player received;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!socket.isClosed()) {

            try {

                // Waiting for message...
                received = (Player) inputStream.readObject();

                if (received.isWinner())
                    Server.socketsClients.clear();
                else
                    notifyClients(received);

            } catch (IOException e) {

                try {
                    socket.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
    }

    private void notifyClients(Player player) throws IOException {

        ObjectOutputStream output;

        for (Socket s: Server.socketsClients) {

            if (!s.equals(this.socket) && s.isConnected()) {
                output = new ObjectOutputStream(s.getOutputStream());
                output.writeObject(player);
            }
        }
    }
}
