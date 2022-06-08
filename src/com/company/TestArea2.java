package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class TestArea2 {
    /*Test Data only   **DO NOT LOOK AT!**
    * Mock Data*/
    static ArrayList<Task> mockTasks = new ArrayList<Task>();
    public static void main(String[] args) {

      var n = mockData();
        n.forEach(s -> System.out.println(s.printTaskDetails()));

       var stream = n.stream()
               .filter(x -> x.getTaskName()
                       .equals("Login F")).toList();
       stream.forEach(str -> System.out.println(str.printTaskDetails()));


    }
    static ArrayList<Task> mockData(){
        var one = new Task("Login F",new StringBuilder("Implement"),"SLim", mockTasks.size() +1 );
        var two = new Task("Task do",new StringBuilder("Implement Now"),"Shady", mockTasks.size() +1 );
        mockTasks.add(one);
        mockTasks.add(two);

        return mockTasks;
    }
}
