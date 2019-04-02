package com.zoltowsky.Algorithms;

import com.zoltowsky.Tasks.CreateTasks;
import com.zoltowsky.Tasks.Task;

import java.util.ArrayList;
import java.util.Random;

public class CSCAN implements Algorithm {

    private int movement = 0;
    private CreateTasks copy;
    private ArrayList<Task> queue;
    private int currentAdress = 0;
    private Random r = new Random();

    @Override
    public void simulate(CreateTasks tasks) {
        queue = sortByAdress(tasks);
        int count = 0;
        int pos = r.nextInt(queue.size());
        currentAdress = pos;
        int posHelp = pos; // ta pozycja bedzie do drugiej petli zeby dysk wiedzial gdzie sie przesunac
        //dopoki count bedzie mniejszy niz size wszstkic taskow
        while(count < tasks.getSize()) {
            for (int i = pos; i < queue.size(); i++) {

                movement += Math.abs(queue.get(i).getAdress() - currentAdress);
                currentAdress = queue.get(i).getAdress();
                count++;

            }
            movement += queue.size();

            for(int i = 0; i <pos; i++){



                movement += Math.abs(queue.get(i).getAdress() - currentAdress);
                currentAdress = queue.get(i).getAdress();
                count++;

            }


        }}



    @Override
    public void showResults() {
        System.out.println("CSCAN total movement: " + this.movement);
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
