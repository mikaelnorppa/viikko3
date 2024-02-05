package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }
    
    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream("savestudents.dat"));
            studentWriter.writeObject(students);
            studentWriter.close();
            System.out.println("Opiskelijat tallennettu tiedostoon");
        } catch (IOException e) {
            System.out.println("Oppilaitten tallentaminen ei onnistunut");
            e.printStackTrace();
        }
    }

    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream("savestudents.dat"));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
            System.out.println("Opiskelijat ladattu tiedostosta");
        } catch (FileNotFoundException e) {
            System.out.println("Oppilaitten lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Oppilaitten lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Oppilaitten lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }       

}
