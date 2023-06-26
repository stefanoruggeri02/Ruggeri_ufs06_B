package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WareHouse {
    private static WareHouse istance;
    private static List<Wine> wineList = new ArrayList();
    private static List<ClientHandler> clientList = new ArrayList<>();

    private WareHouse() {
        buildList();
    }

    public static WareHouse getInstance() {
        if (istance == null) {
            istance = new WareHouse();
        }
        return istance;
    }

    static void buildList() {
        wineList.add(new Wine(13, "Dom Perignon Vintage Moet & Chandon 2008", 225.94, "white"));
        wineList.add(new Wine(14, "Pignoli Radikon Radikon 2009", 133.0, "red"));
        wineList.add(new Wine(124, "Pinot Nero Elena Walch Elena Walch 2018", 43.0, "red"));
        System.out.println(wineList);
    }

    void add(ClientHandler clientHandler) {
        this.clientList.add(clientHandler);
    }

    void remove(ClientHandler clientHandler) {
        this.clientList.remove(clientHandler);
    }

    int nOfClients() {
        return this.clientList.size();
    }


    public String sorted_by_price() {
        ArrayList<Wine> sortedList = new ArrayList<>(wineList);

            Collections.sort(sortedList, (wine1, wine2) -> Double.compare(wine2.getPrezzo(), wine1.getPrezzo()));

            Gson gson = new Gson();
            String s = gson.toJson(sortedList);

            return s;
    }

    public String sorted_by_name() {

        List<Wine> wineList_sorted = new ArrayList(wineList);

        wineList_sorted.sort((o1, o2) -> {
            return o1.getNome().compareTo(o2.getNome());
        });

        Gson gson = new Gson();
        String s = gson.toJson(wineList_sorted);

        return s;
    }

    public String red() {
        ArrayList<Wine> viniRossi = new ArrayList<>();
        for (Wine wine : wineList) {
            if (wine.getType().equalsIgnoreCase("red")) {
                viniRossi.add(wine);
            }
        }
        System.out.println("Vini Rossi:");
        for (Wine wine : viniRossi) {
            System.out.println(wine);
        }
        Gson gson = new Gson();
        String s = gson.toJson(viniRossi);

        return s;
    }

    public String white() {
        ArrayList<Wine> viniBianchi = new ArrayList<>();
        for (Wine wine : wineList) {
            if (wine.getType().equalsIgnoreCase("white")) {
                viniBianchi.add(wine);
            }
        }
        System.out.println("Vini Bianchi:");
        for (Wine wine : viniBianchi) {
            System.out.println(wine);
        }
        Gson gson = new Gson();
        String s = gson.toJson(viniBianchi);

        return s;
    }
}