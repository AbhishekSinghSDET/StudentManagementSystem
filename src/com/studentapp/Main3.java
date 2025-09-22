package com.studentapp;

import java.util.*;

public class Main3 {

    private static  List<Student> studentList =  new ArrayList<Student>();;

    public static void main(String[] args) {
        System.out.println("*********** Student Management System ***********");
        System.out.println("*********** Welcome ***********");

        //Reading input from terminal
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name.......");
        sc.next();

        System.out.println("Enter Student Age.......");
        sc.nextInt();

        Student s1 = new Student("Abhishek",20,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        s1.enrollCourse("DevOps");


        Student s2 = new Student("Rohan",23,"S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");
        s2.enrollCourse("DevOps");


        Student s3 = new Student("Kartik",23,"S-3");
        s3.enrollCourse("DevOps");

        Student s4 = new Student("Bharat",23,"S-4");
        s3.enrollCourse("DSA");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);

        Student result = findStudentById("S-1");
        System.out.println("Result " +result);

        Student result1 = findStudentById("S-10");
        System.out.println("Result " +result1);

        sortByName();
    }



    //Function created to sort object i.e student name in ascending order
    private static void sortByName() {
//        Comparator<Student> studentNameComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());  // comparison happen lexographically
//            }
//        };

        //Optimized one using Lamda Expression
        Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());

        Collections.sort(studentList,studentNameComparator);
        System.out.println(studentList);
    }


    //Created this function to find if specific student Id is present
    public static Student findStudentById(String studentId){
        Student result = null;
        try {
            result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found!!"));
        }
        catch (RuntimeException e){
            System.err.println("Student with ID "+studentId+" not found");
        }
        return result;
    }
}