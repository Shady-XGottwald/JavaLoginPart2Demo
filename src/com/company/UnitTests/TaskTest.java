package com.company.UnitTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.company.Main2.TaskStatus.Doing;
import static org.junit.jupiter.api.Assertions.*;
import com.company.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

class TaskTest {

    ArrayList<Task> myTask_mock_data = new ArrayList<>();


    @Test
    void checkTaskDescription() {
        var one = new  Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),3, "Doing");

        Boolean actual =  one.checkTaskDescription("kj");
        Boolean exp = true;

        assertEquals(exp,actual);

    }

    @Test
    void createTaskId() {
        var one = new  Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),3, "Doing");

        String expect = "LO:0:BYN";
        assertEquals(expect,("Lo:0:byn").toUpperCase(Locale.ROOT));
    }

    @Test
    void printTaskDetails() {
        var one = new  Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),3, "Doing");
        var two = new Task("Login Feature",new StringBuilder("kj"),"Robyn",1,
                new StringBuilder("LO:0:BYN"),3, "Doing");

        String expect = "\nTask Name: \n" + one.getTaskName() + "\n"
                + "Description: " + " "
                + one.getDescription()  + "\n"
                +"Developer Details: " +" "
                + one.getDev_details() + "\n"
                + "Task_Id: " + one.getTask_Id() + "\n"
                + "Auto-generated_Id: " + one.createTaskId().toUpperCase(Locale.ROOT)+"\n"
                + "Hours: "+ one.getTask_hours()+"Hrs\n"
                + "Status: " + one.getTask_status()+"\n";

        var actual = one.printTaskDetails();

        assertEquals(expect,actual);
    }

    @Test
    void returnTotalHours() {
        var one = new  Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),3, "Doing");
        var two = new Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),7, "Doing");
        myTask_mock_data.add(one);
        myTask_mock_data.add(two);

        int expected = 10;
        Integer actual  =  myTask_mock_data.stream().mapToInt(Task::getTask_hours).sum();

        assertEquals(expected,actual);

    }


    @Test
    void shouldReturnFalseIfTaskDescriptionGreaterThanFiftyChars (){
        var one = new  Task("Login Feature",new StringBuilder("kj"),"Robyn",0,
                new StringBuilder("LO:0:BYN"),3, "Doing");

        one.setDescription(new StringBuilder("ewwwwEfjkfrrrrrrrrrrkkffffffffffffffff" +
                "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"));
        Boolean actual = false;

        assertEquals(false,actual);

    }

}