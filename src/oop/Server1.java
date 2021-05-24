package oop;

import ball.BallDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 extends Thread {
    public static final int port = 4444;
    private ServerSocket ss = null;
    private ObjectInputStream is = null;
    private ObjectOutputStream os = null;
    private Socket socket;
    private BallDTO ball;
    public boolean isNewBallReceived = false;


    public void runServer() throws IOException, ClassNotFoundException {

        ss = new ServerSocket(port);
        socket = ss.accept();

        is = new ObjectInputStream(socket.getInputStream());
        os = new ObjectOutputStream(socket.getOutputStream());

    }

    public void run() {
        try {
            runServer();
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }

        int tryNumber = 0;

        while (true) {
            try {
                ball = (BallDTO) is.readObject();
                isNewBallReceived = true;
            } catch (ClassNotFoundException e) {
            } catch (IOException e) {
            }

            try {
                tryNumber++;
                sleep(1000);
                if (tryNumber == 5) {
                    exit();
                    System.exit(-1);
                }
            } catch (InterruptedException e1) {
            }
        }
    }

    public void exit() {
        try {
            socket.close();
        } catch (IOException e) {
        }
    }
    public BallDTO getBallDTO() {
        return ball;
    }
}



