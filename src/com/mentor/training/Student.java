package com.mentor.training;

public class Student {
    private int Id,Name,Age;
    private static int StudentCount=0;
    Student()
    {
        StudentCount++;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getName() {
        return Name;
    }

    public void setName(int name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
    public static int getStudentCount()
    {
        return StudentCount;
    }
}
