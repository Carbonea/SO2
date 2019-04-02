package com.zoltowsky.Algorithms;

import com.zoltowsky.Tasks.CreateTasks;

public class FCFS implements Algorithm {

    private int movement=0;
    private int currentPosition=0;
    private CreateTasks copy;



    @Override
    public void simulate(CreateTasks tasks) {
        copy = tasks;

        for(int i = 0; i< copy.getSize(); i++){
        //dodaje adres konkretnego taska a wlasciwie jego roznice odleglosci miedzy obecna pozycja a nastepnym taksiem
        movement += Math.abs(copy.getTasks(i).getAdress() - currentPosition);
        this.currentPosition = copy.getTasks(i).getAdress();

        }


    }

    @Override
    public void showResults() {

        System.out.println("FCS calkowita droga przejscia: " + this.movement);
    }
}
