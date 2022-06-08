package com.company;

import java.util.ArrayList;

public interface Itask {
    boolean checkTaskDescription(String S);
    String createTaskId();
    String printTaskDetails();
    int returnTotalHours(ArrayList<Task> tasks);
}
