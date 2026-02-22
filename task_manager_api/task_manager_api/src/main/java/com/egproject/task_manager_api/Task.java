package com.egproject.task_manager_api;

public class Task{
    private int id;
    private String title;
    private boolean completed;

    public Task(){   
    }
    
    public Task(int id, String Title, boolean completed){
        this.id=id;
        this.title=Title;
        this.completed=completed;
        }
    
    public int getId(){return id;}
    public String getTitle(){return title;}
    public boolean isCompleted(){return completed;}

    public void setId(int id){this.id=id;}
    public void setTitle(String title){this.title=title;}
    public void setCompleted(boolean completed){this.completed=completed;}

}
