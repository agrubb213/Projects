package com.Grubb.week3.week6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 014291 on 2/14/2019.
 * Creates an Object list of the tasks class
 */
public class TaskList {
    private Scanner scan = new Scanner(System.in);

    /**
     * Method that updates a task in the list
     * @param getList gets the list from the main
     * @return true or false and tell you if the task number is in the list.
     */
    public boolean updateTask(ArrayList<Task> getList) {
        boolean check = true;
        int checkTask = 0;

        //ask user if what id number they want to update
        System.out.println("What task would you like to update?(By ID number)");
        int taskId = scan.nextInt();
        scan.nextLine();

        for (Task getTask : getList) {
            // goes through each element in getList.
            if (taskId == getTask.getId()) {
                // if the number the user wants to check equals a task id then return true
                getList.remove(getTask);
                check = true;
            }
            if (checkTask > getList.size()) {
                // if the task your are asking for is larger then the task size then return false
                System.out.println("Input a valid task!");
                check = false;
            }
            checkTask++;
        }
        return check;
    }

    /**
     * list the task based on priority
     * @param getList gets list from main
     */
    public void listTask(ArrayList<Task> getList){
        int idNum = 1;
        for (int i = 5; i>0;i--) {
            // organizes base on priority.
            for (Task getTask : getList) {
                // run all elements in task
                if (getTask.getTaskPri() == i) {
                    // if the priority equals the variable in the first for loop then out put that task.
                    System.out.println(idNum+") " + getTask.getTaskName()+ "\nDescription: " + getTask.getTaskDes()
                            + "\nPriority: " + i);
                    getTask.setId(idNum);
                    idNum++;
                }
            }
        }
    }
}
