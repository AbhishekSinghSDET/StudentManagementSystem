package com.studentapp;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    String name;
    int age;
    String studentId;
    List<String> courses;


    public Student(String name, int age, String studentId) {
        super();
        if (validateName(name) && validateAge(age) && validateStudentId(studentId) ) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); //Initialization of courses
        }
    }


    public void enrollCourse(String course){
        if(validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to " + course + " successfully!!");
            } else {
                System.err.println("Student is already enrolled for the course " + course);
            }
        }
    }

    public void printStudentInfo(){
        System.out.println("============ Student Information ==============");
        System.out.println("Student Name: "+name);
        System.out.println("Student Age: "+age);
        System.out.println("Student Id: "+studentId);
        System.out.println("Enrolled courses: "+courses );
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                '}';
    }


    //Validation Methods
    public boolean validateAge(int age){
        if(age >=15 && age<=35){
            return true;
        }
        else {
            System.err.println("Invalid Age!! Student's age needs to be between 19 and 35");
            return false;
        }
    }


    public boolean validateName(String name){
        String nameRegex = "^[a-zA-Z\\s]+$";
        //It means name should start with alphabet \\s means whitespaces allowed

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);

        if(nameMatcher.matches()){
            return true;
        }
        else {
            System.err.println("Invalid Name");
            return false;
        }
    }

    public boolean validateStudentId(String StudentId){
        String studentIdRegex = "S-[0-9]+$";

        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = studentIdPattern.matcher(StudentId);

        if(studentIdMatcher.matches()){
            return true;
        }
        else {
            System.err.println("Invalid Student Id");
            return false;
        }
    }

    public boolean validateCourseName(String course){
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")){
            return true;
        }
        else {
            System.err.println("Invalid Course Name!!");
            return false;
        }
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

}
