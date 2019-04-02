package com.zoltowsky.Algorithms;

import com.zoltowsky.Tasks.CreateTasks;
import com.zoltowsky.Tasks.Task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class FDSCAN  implements Algorithm{
    private CreateTasks copy;
    private ArrayList<Task> queue;
    private int movement=0;
    private int currentPosition=0;
    private ArrayList<Integer> realTime;

    @Override
    public void simulate(CreateTasks tasks) {

        realTime=new ArrayList<Integer>();
        copy = tasks;
        int count=0;

        queue= sortByAdress(tasks);

        while(count<copy.getSize()) {

            realTime.clear();
            for(int i=0;i<queue.size();i++) {
                if(queue.get(i).isRealTime()) {
                    movement+=Math.abs(currentPosition-queue.get(i).getAdress());
                    currentPosition=queue.get(i).getAdress();
                    realTime.add(i);
                    count++;
                }
            }

            for(int i=0;i<realTime.size();i++) {
                queue.remove(realTime.get(i));
                
            }
            for(int i=0;i<100;i++) {
                if(count<queue.size()) {
                    movement+=Math.abs(currentPosition-queue.get(count).getAdress());
                    currentPosition=queue.get(count).getAdress();
                    count++;
                }
            }
        }
    }

    @Override
    public void showResults() {

        System.out.println("FDSCAN calkowita droga przejscia: " + this.movement);
    }
    private static ArrayList<Task> sortByAdress(CreateTasks tasks){

        ArrayList<Task> queue = new ArrayList<>();

        for(int i = 0; i < tasks.getSize()-1; i++){
            for(int j = i; j < tasks.getSize()- i - 1; j++){

                if (tasks.getTasks(j).getAdress() > tasks.getTasks(j+1).getAdress())
                {
                    // swap arr[j+1] and arr[i]
                    Task temp = tasks.getTasks(j);
                    tasks.setTasks(j,tasks.getTasks(j+1));
                    tasks.setTasks(j+1,temp);
                }

            }
        }

        for(int i = 0; i < tasks.getSize(); i++){
            queue.add(tasks.getTasks(i));
        }

        return queue;
    }
}
