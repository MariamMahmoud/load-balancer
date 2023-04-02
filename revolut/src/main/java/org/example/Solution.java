package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    List<String> serversPool = new ArrayList<>(10);
    Random rand = new Random();
    public synchronized int addServer(String name) {
        for(int i = 0 ; i < serversPool.size(); i++) {
            if(serversPool.get(i).equals(name)) {
                throw new IllegalArgumentException("name must be unique");
            }
        }

        if(serversPool.size() > 10) {
            throw new IllegalArgumentException("pool is full, cannot add more servers");
        }
        serversPool.add(name);
        return serversPool.size() -1;
    }

    public String getServer() {
        if(serversPool.isEmpty()) {
            throw new IllegalArgumentException("add servers to the pool");
        }
        int serverIndex = rand.nextInt(0,serversPool.size() -1);
        return serversPool.get(serverIndex);
    }
}