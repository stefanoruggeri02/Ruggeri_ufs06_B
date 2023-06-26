package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable{

    private Socket clientSocket = null;
    private InetAddress address;
    private int port;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;

        address = clientSocket.getInetAddress();
        port = clientSocket.getPort();

        System.out.println("Connected: " + address + "with port: " + port);
    }

    Boolean readLoop(BufferedReader in,  PrintWriter out ){

        String s = "";

        try {
            while ((s = in.readLine()) != null) {
                System.out.println(s);


                switch(s)
                {
                    case "white":
                        out.println(WareHouse.getInstance().white());
                        break;
                    case "red":
                        out.println(WareHouse.getInstance().red());
                        break;
                    case "sorted_by_price":
                        out.println(WareHouse.getInstance().sorted_by_price());
                        break;
                    case "sorted_by_name":
                        out.println(WareHouse.getInstance().sorted_by_name());
                        break;
                    default:
                        out.println("Comando inesistente");
                }
            }

            System.out.println("Disconnected: " + address + "with port: " + port);
            WareHouse.getInstance().remove(this);
            System.out.println("Now we have " + WareHouse.getInstance().nOfClients() + " connected client");

            return true;

        } catch (IOException e) {
            System.out.println("Forcing disconnection for: " + address + "with port: " + port);
        }

        return false;
    }

    void handle()
    {
        out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            readLoop(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        handle();
    }
}