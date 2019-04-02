package com.zoltowsky.Tasks;

import java.util.Random;

public class CreateTasks {


    private Task[] tasks;
    private int size;

    public CreateTasks(int size, int realTimeTasksAmmount){

        tasks = new Task[size];
        int count = 0;
        Random r = new Random();
        for(int i = 0; i < tasks.length; i++){
            //przejdzie przez realtimetaskammount elementow i da losowym z nim realtime status
            if(count < realTimeTasksAmmount && r.nextBoolean()){
                tasks[i] = new Task(true);
                count++;
            }
            else{
                tasks[i] = new Task(false);
            }

        }
        this.size = size;


    }

    public Task getTasks(int i) {
        return tasks[i];
    }

    public int getSize() {
        return size;
    }

    public void setTasks(int idx, Task task){
        tasks[idx] = task;
    }
}
