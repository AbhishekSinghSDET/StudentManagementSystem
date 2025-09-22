package com.studentapp;

public class Main {

    public static void main(String[] args) {
        System.out.println("*********** Student Management System ***********");
        System.out.println("*********** Welcome ***********");

        Student s1 = new Student("Abhishek",20,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        s1.enrollCourse("DevOps");
       // s1.enrollCourse("C#");
       // System.out.println(s1);

        s1.printStudentInfo();

        Student s2 = new Student("Rohan",23,"S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");
        s2.enrollCourse("DevOps");
        s2.printStudentInfo();

        Student s3 = new Student("Rohan",23,"S-3");
        s3.enrollCourse("DevOps");
        s3.printStudentInfo();
    }
}