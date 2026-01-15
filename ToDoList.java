/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

/**
 *
 * @author KKuhn2026
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//create the priority interface 
interface Priority {
    void setPriority(int priority);
    int getPriority();
}

//create the complexity interface 
interface Complexity {
    void setComplexity(int complexity);
    int getComplexity();
}

//create the task class to get and set priority and complexity numbers
class Task implements Priority, Complexity, Comparable<Task> {
    private final String description;
    private int priority;
    private int complexity;
    
    public Task(String description, int priority, int complexity) {
        this.description = description;
        this.priority = priority;
        this.complexity = complexity;
    }
    
    //set the priority methods
    @Override
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    //get the priority methods
    @Override
    public int getPriority() {
        return priority;
    }
    
    //set the complexity methods
    @Override
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
    
    //get the complexity methods
    @Override
    public int getComplexity() {
        return complexity;
    }
    
    //creat teh comparable method in order to sort complexity and priority numbers
    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        }
        return Integer.compare(other.complexity, this.complexity);
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return description + " (Priority:" + priority + ", Complexity:" + complexity + ")";
    }
}

public class ToDoList {
    public static void main(String[] args) {
        //create list of my daily tasks with their compleixties and priorities
        List<Task> myTasks = new ArrayList<>();
        myTasks.add(new Task("Pray", 10, 1));
        myTasks.add(new Task("Brush your teeth", 8, 2));
        myTasks.add(new Task("Take out the trash", 6, 3));
        myTasks.add(new Task("Change the lightbulb", 5, 4));
        myTasks.add(new Task("Baseball Workout", 9, 5));
        
        System.out.println("Original task list:");
        System.out.println(myTasks);
        
        //sort by priority
        Collections.sort(myTasks);
        System.out.println("\nSorted by priority:");
        System.out.println(myTasks);
        
        //sort by complexity
        for(int i = 0; i < myTasks.size()-1; i++) {
            for(int n = 0; n < myTasks.size()-1-i; n++) {
                if(myTasks.get(n).getComplexity() < myTasks.get(n+1).getComplexity()) {
                    Task temp = myTasks.get(n);
                    myTasks.set(n, myTasks.get(n+1));
                    myTasks.set(n+1, temp);
                }
            }
        }
        //print sorted complexity list
        System.out.println("\nSorted by complexity:");
        System.out.println(myTasks);
    }
}

