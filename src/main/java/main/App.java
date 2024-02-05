package main;
import java.util.Scanner;
import java.util.List;
/**
 * Hello world!!
 *
 */
public class App 

{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        University university = new University();


        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    sc.nextLine();
                    System.out.println("Anna opiskelijan nimi?");
                    String name = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelija numero:");
                    String studentNumber = sc.nextLine();
                    university.addStudent(new Student(name, studentNumber));
                    break;
                case 2:
                    List<Student> students = university.getStudents();
                    System.out.println("Opiskelijat:");

                    for (int i = 0; i < students.size(); i++) {
                        Student student = students.get(i);
                        System.out.println(student.getStudentNumber() + ": " + student.getName());
                    }
                    break;
                case 3:
                    List<Student> studentsAddGrade = university.getStudents();
                    for (int i = 0; i < studentsAddGrade.size(); i++) {
                        Student student = studentsAddGrade.get(i);
                        System.out.println(i + ": " + student.getName());
                    }
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    int studentIndex = sc.nextInt();
                    sc.nextLine();
                    Student selStudent = university.getStudents().get(studentIndex);
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    int grade = sc.nextInt();
                    selStudent.addGrade(course, grade);
                    break;
                case 4:
                    List<Student> studentsListGrades = university.getStudents();
                    for (int i = 0; i < studentsListGrades.size(); i++) {
                        Student student = studentsListGrades.get(i);
                        System.out.println(i + ": " + student.getName());
                    }

                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    int studentIndexListGrades = sc.nextInt();
                    sc.nextLine();

                    if (studentIndexListGrades < 0 || studentIndexListGrades >= studentsListGrades.size()) {
                        System.out.println("Virheellinen opiskelijanumero.");
                        break;
                    }

                    Student selectedStudent = studentsListGrades.get(studentIndexListGrades);
                    List<Grade> grades = selectedStudent.getGrades();

                    for (Grade gradeItem : grades) {
                        System.out.println(gradeItem.getCourse() + ": " + gradeItem.getGrade());
                    }
                    break;
                case 5:
                    List<Student> studentsAverage = university.getStudents();
                    for (int i = 0; i< studentsAverage.size(); i++) {
                        Student student = studentsAverage.get(i);
                        System.out.println(i + ": " + student.getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    int studentIndexAvg = sc.nextInt();
                    sc.nextLine();

                    if (studentIndexAvg < 0 || studentIndexAvg >= studentsAverage.size()) {
                        System.out.println("Virheellinen opiskelijanumero.");
                        break;
                    }
                    Student studentAvg = studentsAverage.get(studentIndexAvg);
                    double average = Calculator.getAvgGrade(studentAvg);
                    System.out.println("Keskiarvo on " + average);
                    break;
                case 6:
                    List<Student> studentsMedian = university.getStudents();
                    for (int i = 0; i< studentsMedian.size(); i++) {
                        Student student = studentsMedian.get(i);
                        System.out.println(i + ": " + student.getName());
                    }
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    int studentIndexMed = sc.nextInt();
                    sc.nextLine();
                    if (studentIndexMed < 0 || studentIndexMed >= studentsMedian.size()) {
                        System.out.println("Virheellinen opiskelijanumero.");
                        break;
                    }
                    Student studentMed = studentsMedian.get(studentIndexMed);
                    double median = Calculator.getMedGrade(studentMed);
                    System.out.println("Mediaani on " + median);
                    break;
                case 7:
                university.saveStudents();
                break;
                case 8:
                university.loadStudents();
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

