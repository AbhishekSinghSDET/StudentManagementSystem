package com.studentapp;

import java.util.*;

public class Main4 {

    private static  List<Student> studentList;
    private static Scanner sc;

    public static void main(String[] args) {
        System.out.println("*********** Student Management System ***********");
        System.out.println("*********** Welcome ***********");
        studentList = new ArrayList<Student>();
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:........");
            System.out.println("1. Register a Student");
            System.out.println("2. Find student with student id");
            System.out.println("3. List all student information");
            System.out.println("4. List all student information in sorted order");
            System.out.println("5. Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(sc);
                    break;
                case 2:
                    findStudentById(sc);
                    break;
                case 3:
                    printAllStudentData(sc);
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Invalid Option Selected.....Enter between 1 to 5");
            }


//            Student result = findStudentById("S-1");
//            System.out.println("Result " + result);

//        Student result1 = findStudentById("S-10");
//        System.out.println("Result " +result1);

            sortByName();
        }
    }

    private static void exit() {
        System.out.println("Good Bye...!!!");
        System.exit(0);
    }

    private static void listAllInfoInSortedWay(Scanner sc) {
    }

    private static void printAllStudentData(Scanner sc) {

        if(studentList.size()>0) {
            System.out.println("------Print All Student Data----------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("-----------------");
        }
        else {
            System.err.println("No Student Record Found");
        }
    }

    private static void findStudById(Scanner sc) {
    }

    private static void enrollStudent(Scanner sc) {
        System.out.println("Enter Student Name.......");
        String studentName = sc.next();

        System.out.println("Enter Student Age.......");
        int studentAge = sc.nextInt();

        System.out.println("Enter Student Id.......");
        String studentId= sc.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);

        while(true) {
            System.out.println("Enter course to be enrolled.....!Type Done to Exit");
            String courseName = sc.next();
            if(courseName.equalsIgnoreCase("Done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
        }

        newStudent.printStudentInfo();
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
    public static void findStudentById(Scanner sc){
        Student studentFound = null;
        System.out.println("Enter Student ID.......");
        String studentId = sc.next();
        try {
            studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No data found!!"));
        }
        catch (RuntimeException e){
            System.err.println("Student with ID "+studentId+" not found");
        }
        studentFound.printStudentInfo();
    }
}