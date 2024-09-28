package com.api;

public class Employee {
    private long id;
    private String name;
    private long sal;

    public Employee(long id, String name,long sal){
        this.id=id;
        this.name=name;
        this.sal=sal;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSal() {
        return sal;
    }
}
