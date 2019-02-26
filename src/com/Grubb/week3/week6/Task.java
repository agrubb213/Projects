package com.Grubb.week3.week6;

import java.util.ArrayList;

/**
 * Created by 014291 on 2/13/2019.
 * Creates an object "task" that gives it a ID of task, task name, task description, and priority number.
 */

public class Task {
    public String taskName;
    public String taskDes;
    public int taskPri;
    public int id;

    /**
     *
     * @param taskName the name of object
     * @param taskDes the description of the object
     * @param taskPri the priority of the
     */
    public Task(String taskName, String taskDes, int taskPri) {
        this.taskName = taskName;
        this.taskDes = taskDes;
        this.taskPri = taskPri;
    }

    /**
     *
     * @return the number associated with the task.
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @param id set the number associated with the task.
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     *
     * @return the name of the object (task name)
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     *
     * @return the description of object(task)
     */
    public String getTaskDes() {
        return taskDes;
    }

    /**
     *
     * @return the priority of the object(task)
     */
    public int getTaskPri() {
        return taskPri;
    }



}

