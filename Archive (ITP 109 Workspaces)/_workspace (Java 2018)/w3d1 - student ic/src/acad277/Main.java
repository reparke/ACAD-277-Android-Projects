package acad277;

public class Main {

    public static void main(String[] args) {
        Student hal = new Student("Hal", "54");

        hal.enrollCourse("ACAD 277");
        hal.enrollCourse("ACAD 360");

        System.out.println("Here is Hal's info");
        System.out.println(hal);

    }
}
