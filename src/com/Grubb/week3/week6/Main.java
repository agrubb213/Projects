package com.Grubb.week3.week6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 014291 on 2/13/2019.
 */
/*
2/26/2019
Austin J. Grubb
Program give you a list of options to use to manipulate a task list.
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Task> taskList = new ArrayList<>();
    static TaskList list = new TaskList();

    static boolean whatTask(){
        //Ask the user what option they would like and then directs you to the right method to use.

        String whichTask;
        boolean exit = false;

        System.out.println("Please choose an option:\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(0) Exit.");
        whichTask = scan.nextLine();

        switch (whichTask){
            // using the input directs you to the right method/ class to use.

            case "1": addTask();
                break;

            case "2":
                // list the task then removes the right task
                list.listTask(taskList);
                removeTask();
                break;

            case "3":
                //list the task then remove the task
                list.listTask(taskList);
                if(list.updateTask(taskList)){addTask();}
                break;

            case "4":
                //list task
                list.listTask(taskList);
                break;

            case "0":
                // exit code
                exit = true;
                break;

            default:
                // checking for valid input
                System.out.println("Not a valid input!");
                break;
        }
        return exit;
    }

    static void addTask() {
        // makes and adds a task to a list
        int taskPri = 0;
        boolean validInput = false;

        System.out.println("What is the name of your new task?");
        String askTask = scan.nextLine();

        System.out.println("What is the description of the task " + askTask + ":");
        String taskDes = scan.nextLine();

        while(!validInput){
            //checking if user inputs a valid int for priority of task
            try{
                System.out.println("What is the priority of this task?(1-5)");
                taskPri = scan.nextInt();
                scan.nextLine();
                if(0<taskPri & taskPri<6){
                    // checks if the task priority is between 1-5 then
                    validInput = true;
                }
                else{
                    System.out.println("input a valid priority number(1-5)");
                }

            }catch (Exception e){
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }
        // adding the new task to a list
        Task newTask = new Task(askTask, taskDes, taskPri);
        taskList.add(newTask);
    }

    static void removeTask() {
        // removes a task from the list
        int checkTask = 0;
        int taskId = 0;
        boolean validInput = false;

        while (!validInput) {
            // checks if user inputs a valid int for id number
            try {
                System.out.println("What task would you like to remove?(By ID number)");
                taskId = scan.nextInt();
                scan.nextLine();
                validInput = true;

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }

        for (Task getTask : taskList) {
            // run all elements in task list
            if (taskId == getTask.getId()) {
                taskList.remove(getTask);
            }
            else if (checkTask > taskList.size()) {
                // if the for loop goes through more elements then the size of the list then tell the user it was not a valid input
                System.out.println("Input a valid task!");
                removeTask();
            }
            checkTask++;
        }
    }

    public static void main(String[] args) {
        //main
        boolean exit;
        do{
            // while whatTask has not exited then keep running it.
            exit = whatTask();
        }while(!exit);
    }
}
