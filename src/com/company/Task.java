package com.company;
import com.company.Main2;
import java.util.ArrayList;
import java.util.Locale;

/*
 * @param taskName ,set tasks name.
 * @param desc ,set tasks description.
 * @param dev_details ,set who is responsible.
 * @param hours, set tasks hours.
 * @param task_Id, set tasksId
 * @param auto_gen_Id, sets id by {TasksName(2):task_Id:dev_details(lastThreeChars)   }
 * @param status , set tasks status. -> Menu
 * @param */

public class Task implements Itask{

    private String taskName;
    private StringBuilder description;
    private String dev_details;
    private int task_Id;
    private StringBuilder auto_gen_Id;
    private int task_hours;
    private String task_status;

    public String getTask_status() {
        return task_status;
    }

    public Task(String taskName, StringBuilder description, String dev_details, int task_Id, StringBuilder auto_gen_Id,
                int task_hours, String task_status) {
        this.taskName = taskName;
        this.description = description;
        this.dev_details = dev_details;
        this.task_Id = task_Id;
        this.auto_gen_Id = auto_gen_Id;
        this.task_hours = task_hours;
        this.task_status = task_status;
    }

    public Task(String taskName, StringBuilder description, String dev_details, int task_Id, StringBuilder auto_gen_Id, int task_hours) {
        this.taskName = taskName;
        this.description = description;
        this.dev_details = dev_details;
        this.task_Id = task_Id;
        this.auto_gen_Id = auto_gen_Id;
        this.task_hours = task_hours;

    }

    public int getTask_hours() {
        return task_hours;
    }

    public StringBuilder getAuto_gen_Id() {
        return auto_gen_Id;
    }

    public Task(String taskName, StringBuilder description, String dev_details, int task_Id, StringBuilder auto_gen_Id) {
        this.taskName = taskName;
        this.description = description;
        this.dev_details = dev_details;
        this.task_Id = task_Id;
        this.auto_gen_Id = auto_gen_Id;
    }

    public int getTask_Id() {
        return task_Id;
    }

    public Task(String taskName, StringBuilder description, String dev_details, int task_Id) {
        this.taskName = taskName;
        this.description = description;
        this.dev_details = dev_details;
        this.task_Id = task_Id;
    }


    public String getDev_details() {
        return dev_details;
    }

    public Task(String taskName, StringBuilder description, String dev_details) {
        this.taskName = taskName;
        this.description = description;
        this.dev_details = dev_details;
    }

    @Override
    public boolean checkTaskDescription(String description) {
        var MAX_CHAR = 50;
        if(checkDescriptionCount(description) == 0){
            return true;}
        else if(checkDescriptionCount(description) <= MAX_CHAR){return true;}
        else{return false;}
    }

    private int checkDescriptionCount(String s){
        if(s.isEmpty()){return 0;}
        return s.length();
    }

    public void setDescription(StringBuilder description) {
        this.description = description;
    }

    @Override
    public String createTaskId() {
        var generated_Id = loopTasksName(getTaskName())+":"+getTask_Id()+":"+loopThroughDevDetails(getDev_details());
        return String.valueOf(new StringBuilder(generated_Id));
    }

    @Override
    public String printTaskDetails() {
        var details =
                "\nTask Name: \n" + getTaskName() + "\n"
                + "Description: " + " "
                + getDescription()  + "\n"
                +"Developer Details: " +" "
                + getDev_details() + "\n"
                + "Task_Id: " + task_Id + "\n"
                + "Auto-generated_Id: " + createTaskId().toUpperCase(Locale.ROOT)+"\n"
                + "Hours: "+ getTask_hours()+"Hrs\n"
                + "Status: " + task_status+"\n";

        return details;
    }

    @Override
    public  int returnTotalHours(ArrayList<Task> tasks) {
        return tasks.stream()
                .map(Task::getTask_hours)
                .reduce(0, Integer::sum);
    }


    public String getTaskName() {
        return taskName;
    }
    public StringBuilder getDescription() {
        return description;
    }


 private  StringBuilder loopTasksName(String name){
        StringBuilder n = new StringBuilder();
        for(int x = 0; x< name.length(); x++){
            n.append(name.charAt(x));
            if(x == 1){break;}
        }
        return n;
    }
    private StringBuilder loopThroughDevDetails (String dev_details){
        StringBuilder reversed = new StringBuilder(dev_details).reverse();
        StringBuilder value = new StringBuilder();
        for(int j = 0; j< reversed.length(); j++) {
            value.append(reversed.charAt(j));
            if(j == 2) {
                break;
            }
        }
        return value.reverse();
    }

}
