package com.game.socket;

import com.game.model.Player;
import com.game.util.ConnectionSocketUtil;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;

public class Client extends Observable implements Runnable {

    public static ObjectOutputStream output;
    private Socket socket;

    @Override
    public void run() {

        ObjectInputStream inputStream;

        try {
            socket = new Socket(ConnectionSocketUtil.HOST, ConnectionSocketUtil.PORT);
            output = new ObjectOutputStream(socket.getOutputStream());

            while (!socket.isClosed()) {

                inputStream = new ObjectInputStream(socket.getInputStream());
                Player player = (Player) inputStream.readObject();
                setChanged();
                notifyObservers(player);
            }

        } catch(EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void notifyMovementCharacter(Player player) {

        try {
            output.writeObject(player); // Send notification

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
