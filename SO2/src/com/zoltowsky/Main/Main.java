package com.zoltowsky.Main;

import com.zoltowsky.Algorithms.*;
import com.zoltowsky.Tasks.CreateTasks;


public class Main {



    public static void main(String[] args) {

        CreateTasks tasks = new CreateTasks(30, 6);
        /*for(int i = 0; i < tasks.getSize();i++){
            System.out.println(tasks.getTasks(i));
        }*/

        Algorithm algorithm = new FCFS();
        algorithm.simulate(tasks);
        algorithm.showResults();

        algorithm = new SSTF();
        algorithm.simulate(tasks);
        algorithm.showResults();

        algorithm = new SCAN();
        algorithm.simulate(tasks);
        algorithm.showResults();

        algorithm = new CSCAN();
        algorithm.simulate(tasks);
        algorithm.showResults();

        algorithm = new FDSCAN();
        algorithm.simulate(tasks);
        algorithm.showResults();

    }






}
