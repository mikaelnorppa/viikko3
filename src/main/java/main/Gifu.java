package main;
import java.util.ArrayList;

public class Gifu {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Enrollment> enrollments = new ArrayList<>(); 
    private String universityName;

    public Gifu(String universityName) {
        this.universityName = universityName;
    }

    public void addCourse(String name, String id, int maxStudents) {
        Course course = new Course(name, id, maxStudents);
        courses.add(course);
    }

    public void addStudent(String name, String studentNumber) {
        Student student = new Student(name, studentNumber);
        students.add(student);
    }

    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public void enrollStudent(Student student, Course course) {
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
    }

    public ArrayList<Course> listCourses() {
        return new ArrayList<>(courses);
    }

    public ArrayList<Student> listStudents() {
        return new ArrayList<>(students);
    }

    public ArrayList<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public void listStudents(Course course) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().getId().equals(course.getId())) {
                System.out.println(enrollment.getStudent().getInformation());
            }
        }
    }

    public ArrayList<Enrollment> getEnrollments(String courseId) {
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourse().getId().equals(courseId)) {
                result.add(enrollment);
            }
        }
        return result;
    }

    public void setGradeForStudentInCourse(String studentNumber, String courseId, int grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentNumber().equals(studentNumber) &&
                enrollment.getCourse().getId().equals(courseId)) {
                enrollment.setGrade(grade);
                return;
            }
        }
    }

    public Course getCourse(String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public Student getStudent(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Enrollment> getGrades(String studentNumber) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getStudentNumber().equals(studentNumber)) {
                results.add(enrollment);
            }
        }
        return results;
    }

}


