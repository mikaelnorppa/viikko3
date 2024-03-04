package main;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Hello world!!
 *
 */
public class App 

{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        String universityName = sc.nextLine();
        Gifu gifu = new Gifu(universityName);


        boolean exit = false;
        while (!exit) {
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Anna kurssin nimi:");
                    sc.nextLine();
                    String courseName = sc.nextLine();
                    System.out.println("Anna kurssin ID:");
                    String courseId = sc.nextLine();
                    System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                    int maxStudents = sc.nextInt();
                    gifu.addCourse(courseName, courseId, maxStudents);
                    System.out.println("Kurssi lisätty: " + courseName);
                    break;
                case 2:
                    System.out.println("Anna opiskelijan nimi:");
                    sc.nextLine();
                    String studentName = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentNumber = sc.nextLine();
                    gifu.addStudent(studentName, studentNumber);
                    break;
                case 3:
                    ArrayList<Course> courses = gifu.listCourses();
                    if (courses.isEmpty()) {
                        System.out.println("Ei kursseja.");
                    } else {
                        for (Course course : courses) {
                            System.out.println(course.getId() + ": " + course.getName());
                        }
                    }
                    break;
                case 4:
                    ArrayList<Student> students = gifu.listStudents();
                    if (students.isEmpty()) {
                    System.out.println("Ei opiskelijoita.");
                     } else {
                        for (int i = 0; i < students.size(); i++) {
                            Student student = students.get(i);
                            System.out.println(i + ") " + student.getStudentNumber() + " " + student.getName());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Anna opiskelijanumero:");
                    sc.nextLine();
                    String studentNum = sc.nextLine();
                    System.out.println("Anna kurssi-ID:");
                    String courseID = sc.nextLine();
                    Student student = gifu.getStudent(studentNum);
                    Course course = gifu.getCourse(courseID);
                    if (student != null && course != null) {
                        gifu.enrollStudent(student, course);
                        System.out.println("Opiskelija " + student.getName() + " lisätty kurssille " + course.getName());
                    } else {
                        System.out.println("Opiskelijaa tai kurssia ei löydy.");
                    }
                    break;
                case 6:
                    System.out.println("Anna kurssi-ID, jonka opiskelijoille haluat antaa arvosanat:");
                    sc.nextLine();
                    String gradingCourseId = sc.nextLine();
                    ArrayList<Enrollment> enrollmentsForGrading = gifu.getEnrollments(gradingCourseId);
                    for (Enrollment enrollment : enrollmentsForGrading) {
                        System.out.println("Anna arvosana opiskelijalle " + enrollment.getStudent().getStudentNumber() + " (" + enrollment.getStudent().getName() + "):");
                        int grade = sc.nextInt();
                        sc.nextLine();
                        gifu.setGradeForStudentInCourse(enrollment.getStudent().getStudentNumber(), gradingCourseId, grade);
                    }
                    System.out.println("Arvosanat annettu kurssille " + gradingCourseId);
                    break;
                case 7:
                    System.out.println("Anna kurssi-ID, jonka opiskelijat haluat listata:");
                    sc.nextLine();
                    String courseForListing = sc.nextLine();
                    ArrayList<Enrollment> enrollmentsInCourse = gifu.getEnrollments(courseForListing);
                    if (enrollmentsInCourse.isEmpty()) {
                        System.out.println("Ei opiskelijoita kurssilla.");
                    } else {
                        for (Enrollment enrollment : enrollmentsInCourse) {
                            System.out.println(enrollment.getStudent().getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Anna opiskelijanumero, jonka arvosanat haluat listata:");
                    sc.nextLine();
                    String studentNumberForGrades = sc.nextLine();
                    ArrayList<Enrollment> studentGrades = gifu.getGrades(studentNumberForGrades);
                    if (studentGrades.isEmpty()) {
                        System.out.println("Ei arvosanoja opiskelijalle.");
                    } else {
                        for (Enrollment enrollment : studentGrades) {
                            System.out.println(enrollment.getCourse().getName() + ": " + enrollment.getGrade());
                        }
                    }
                    break;
                case 9:
                    ArrayList<Course> allCourses = gifu.getCourses();
                    for (Course courses1 : allCourses) {
                        System.out.println(courses1.getName() + ":");
                        ArrayList<Enrollment> enrollmentsForCourse = gifu.getEnrollments(courses1.getId());
                        for (Enrollment enrollment : enrollmentsForCourse) {
                            System.out.println("  " + enrollment.getStudent().getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;

                }
            }
        }

}

