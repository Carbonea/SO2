package com.zoltowsky.Tasks;

import java.util.Random;

public class Task {

    private final int MAX=100;
    private static int momentOfArrival ;
    private boolean realTime;
    private int nr = 1;
    private int adress;

    public Task(boolean realTime) {
        this.realTime=realTime;
        this.momentOfArrival=nr;
        nr++;
        Random r=new Random();
        this.adress=r.nextInt(MAX);
    }

    public int getAdress() {
        return adress;
    }

    public boolean isRealTime() {
        return realTime;
    }

    public int getMomentOfArrival() {
        return momentOfArrival;
    }


    @Override
    public String toString(){

        return "Address: " + this.getAdress();

    }
}
