package acad277;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //instantiate new arraylist
        ArrayList<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Naylee"));

        Student s1 = new Student("Rob");
        studentList.add(s1);

        //instantiate EVERY object in the listt
        for (int i = 0; i < 3; i++) {
            //old
            //students[i] = new Student("name");
            studentList.add(new Student("name"));
        }

        //access position 0 in arraylist and call the setName() method on it
        studentList.get(0).setName("Noreen");
        studentList.get(0).addCourse("PE 129");

        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).displayInfo();
        }

        //change first student's name to noreen and enroll in PE class



//        Student sonika = new Student("Sonika");
//
//
//
//        sonika.addCourse("ACAD 277");
//        sonika.addCourse("ITP 405");
//        sonika.addCourse("BUAD 450");
//        sonika.addCourse("PE 390");
//        sonika.addCourse("MPGU 125");
//        sonika.addCourse("CTAN 452");
//        sonika.addCourse("GERO 320");
//
//        sonika.displayInfo();
//
//        sonika.deleteCourse("PE 390");
//        sonika.displayInfo();
//
//
//        //create an array of students
//        Student[] students = new Student[3];
//        //initialize every element of the array
//        for (int i = 0; i < students.length; i++) {
//            students[i] = new Student("name");
//        }
//
//        students[1] = sonika;
//
//        for (int i = 0; i < students.length; i++) {
//            students[i].displayInfo();
//        }




    }
}
