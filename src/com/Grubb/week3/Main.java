package com.Grubb.week3;

import java.util.Scanner;

public class Main {
    /*
    2/5/2019
    Austin Grubb
    Takes tasks and does a bunch of fun things like remove task, update task, list task, and add task
    using methods, arrays, for loops, switch, and do while's.
     */
    public static Scanner scan = new Scanner(System.in);
    public static int maxTasks = 100;
    public static String[] task = new String[maxTasks];
    public static int currentTask = 0;
    public static String[] taskDes = new String[maxTasks];

    public static void main(String[] args) {
        int askTask;
        do {
            System.out.println("Please choose an option:\n" +
                    "(1) Add a task.\n" +
                    "(2) Remove a task.\n" +
                    "(3) Update a task.\n" +
                    "(4) List all tasks.\n" +
                    "(0) Exit.");
            askTask = scan.nextInt();
            scan.nextLine();
            switch (askTask) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    listTask();
                    break;
                case 0:
                    askTask = 0;
                    break;
            }
        } while (askTask != 0);
    }
    static void addTask() {
        String newTask;
        System.out.println("What task would you like to add?");
        newTask = scan.nextLine();
        System.out.println("description of task?");
        String newTaskDes = scan.nextLine();
        task[currentTask]=newTask;
        taskDes[currentTask]=newTaskDes;
        currentTask+=1;
    }
    static void removeTask() {
        System.out.println("What task would you like to remove!");
        int remNum = scan.nextInt();
        scan.nextLine();
        for(int i = remNum; i<currentTask;i++){
            task[i] = task[i+1];
            taskDes[i]= taskDes[i+1];
        }
        currentTask-=1;
    }
    static void updateTask() {
        System.out.println("What task do you want to update!");
        int upNum = scan.nextInt();
        scan.nextLine();
        System.out.println("What do you want to update it to");
        String newTask = scan.nextLine();
        System.out.println("what would you like the new description to be?");
        String newTaskDes = scan.nextLine();
        taskDes[upNum]=newTaskDes;
        task[upNum]=newTask;
    }
    static void listTask() {
        for (int i = 0; i < currentTask; i++) {
            if(task[i]!= null){
                System.out.println(i+") "+task[i]+" "+taskDes[i]);
            }
        }
    }
}