package com.company;

import java.util.ArrayList;
import java.util.*;

/*@Function login ,responsible for name and password to Login.
 *@Function successfulLogin , checks if name and password are valid.
 * @Function menuItem ,
 * @Function addTask , adds a task obj to @myTask
 * @Function fetchAllTask , returns all tasks stored in the array @ArrayList<TaskImpl> myTask
 *@Function fetchAllTasks ,takes */
public class Main2 {
    public static String EXIT_VALUE = "Exit";
    public static String NAME = "Shady";
    public static String PASSWORD = "Sent@coal45";
    static Thread thread = new Thread();
    static ArrayList<Task> myTask = new ArrayList<Task>();
    static Scanner scanner = new Scanner(System.in);
    static String userName;
    static String password;
    static User user;
    static List<User> users;
    static Task task;

    public enum TaskStatus {
        Doing("Doing"),
        Done("Done"),
        ToDo("ToDo");
        TaskStatus(String value){}
    }

    public static void main(String[] args) throws InterruptedException {
        thread.start();
        login();
        if(successfulLogin(userName,password)){
            System.out.println("Login Successful!");
            user = new User(userName,password);
            menuItem();
        }
        else{
            System.out.println("Try again!");
        }
    }

    public static void login( ) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your userName: <"+NAME+">" );
        userName = sc.nextLine();

        System.out.println("Enter your password: <"+PASSWORD+">");
        password= sc.nextLine();
    }

    static boolean successfulLogin(String userName , String password){
        if(userName.equals(NAME) && password.equals(PASSWORD))
              return true;
        else{return false;}
    }

    static void menuItem () throws InterruptedException {
        String CHOICE ;
       final String addTask = "Add Task";
       final String show_report = "Show report";

        do{
            //MenuItems
            System.out.println("\n");
            System.out.println("====Welcome to easyKanban====");
            System.out.println("1.Add Task");
            System.out.println("2.Show report");
            System.out.println("3.Exit");

            CHOICE = scanner.nextLine();
            switch (CHOICE){
                case addTask -> addTask(user);
                case show_report -> fetchAllTasks(myTask);
                default -> {}
            }
        }
        while(!CHOICE.equals(EXIT_VALUE));
        System.out.println("Logging Out...");
        thread.sleep(3000L);
        System.out.println("Bye!");
    }
   public  static void addTask(User user) {

        //Task variables
        String taskName;
        StringBuilder desc;
        String dev_details;
        int task_Id ;
        StringBuilder auto_gen_Id = new StringBuilder("");
        int hours;
        String status = null;
        Integer status_choice;
        /*
        * @param task_Id ,set numeric task id by array.size + 1
        * @param taskName ,set tasks name.
        * @param desc ,set tasks description.
        * @param dev_details ,set who is responsible
        * @param task_Id , set int id ,by array.size + 1
        * @param auto_gen_Id ,sets tasksId
        * @param hours, set tasks hours.
        * @param status , set tasks status. -> Menu
        * */
       task_Id = myTask.size() ;
       System.out.println("Enter your tasks Name:");
       taskName = scanner.nextLine();
       System.out.println("Enter your tasks description:");
       desc = new StringBuilder(scanner.nextLine());
       System.out.println("Enter Developer Details :");
       dev_details = scanner.nextLine();
       auto_gen_Id.append (loopTasksName(taskName)+":"+task_Id+":"+loopThroughDevDetails(dev_details));
       System.out.println("Enter tasks hours:");
       hours = scanner.nextInt();

       System.out.println("Choose task Status by number: ");
       taskStatusMenu();
       status_choice = scanner.nextInt();
       switch (status_choice){
           case 1 -> status = String.valueOf(TaskStatus.Doing);
           case 2 -> status = String.valueOf(TaskStatus.Done);
           case 3 -> status = String.valueOf(TaskStatus.ToDo);
           default -> {}
       }

       task = new Task(taskName,desc,dev_details,task_Id,auto_gen_Id,hours,status);
       myTask.add(task);

       //fetchAllTasks(myTask);
   }

  public static void fetchAllTasks(ArrayList<Task> all ){
      System.out.println("Number of Tasks : " + myTask.size());
        for(Task task : all) {
            System.out.println(task.printTaskDetails());
        }
    }
  public static void  taskStatusMenu() {

      System.out.println("1.Doing");
      System.out.println("2.Done");
      System.out.println("3.ToDO");
  }

    public static StringBuilder loopTasksName(String name){
        StringBuilder n = new StringBuilder();
        for(int x = 0; x< name.length(); x++){
            n.append(name.charAt(x));
            if(x == 1){break;}
        }
        return n;
    }
    public static StringBuilder loopThroughDevDetails (String dev_details){
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

    public static Integer returnTotalHours(ArrayList<Task> tasks) {
        return tasks.stream()
                .map(Task::getTask_hours)
                .reduce(0, Integer::sum);
    }

}


/*ToDO  -> Make required object params String ,lastly Integer types.*/