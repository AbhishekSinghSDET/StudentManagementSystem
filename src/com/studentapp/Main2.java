package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    private static  List<Student> studentList =  new ArrayList<Student>();;

    public static void main(String[] args) {
        System.out.println("*********** Student Management System ***********");
        System.out.println("*********** Welcome ***********");

        Student s1 = new Student("Abhishek",20,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        s1.enrollCourse("DevOps");


        Student s2 = new Student("Rohan",23,"S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");
        s2.enrollCourse("DevOps");


        Student s3 = new Student("Rohan",23,"S-3");
        s3.enrollCourse("DevOps");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Student result = findStudentById("S-1");
        System.out.println("Result " +result);


    }


    //Created this function to find if specific student Id is present
    public static Student findStudentById(String studentId){
        Student result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No data found!!"));
        return result;
    }
}