package com.zoltowsky.Algorithms;

import com.zoltowsky.Tasks.CreateTasks;
import com.zoltowsky.Tasks.Task;

import java.util.ArrayList;

public class SSTF implements Algorithm{


    private CreateTasks copy;
    private ArrayList<Task> queue;
    private int movement=0;
    private int currentPosition=0;
    private ArrayList<Task> order;

    @Override
    public void simulate(CreateTasks s) {
        this.copy=s;
        queue=new ArrayList<Task>();
        order=new ArrayList<Task>();
        for(int i=0;i<copy.getSize();i++) {
            queue.add(copy.getTasks(i));
        }
        //dodaje tablice do listy i ustawia movement na pierwszy element listy i obecna pozycje a nastepnie dopoki lista
        //nie jest pusta to szuka najblizszego elementu dodaje go do listy order i potem oblicza odleglosc miedzy obecnym
        //a najblizszym elementem i z queue usuwa element najbliszy
        movement+=queue.get(0).getAdress();
        currentPosition=queue.get(0).getAdress();
        int closest=0;
        order.add(queue.get(closest));
        queue.remove(closest);
        while(!queue.isEmpty()){
            closest=searchShortest(queue, currentPosition);
            order.add(queue.get(closest));
            movement+=Math.abs(queue.get(closest).getAdress()-currentPosition);
            currentPosition=queue.get(closest).getAdress();
            queue.remove(closest);
        }
    }

    private static int searchShortest(ArrayList<Task> list, int pos){
        int minDist = 100;
        int idx = 0;

        for(int i = 0; i < list.size(); i++){

            if(Math.abs(list.get(i).getAdress() - pos) < minDist){
                minDist = Math.abs(list.get(i).getAdress() - pos);
                idx = i;
            }

        }
        return idx;
    }

    @Override
    public void showResults() {
        System.out.println("SSTF total movement: " + this.movement);
    }

}
