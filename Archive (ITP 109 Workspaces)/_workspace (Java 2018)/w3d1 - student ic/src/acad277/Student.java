package acad277;

/*
    String name
    int age
    String [] courses (fixed size)
    String id

 */
public class Student {
    private static final int MAX_COURSES = 4;

    //instance variables
    private String name;
    private String id;
    private String [] courses; // declare size later
    private int numCourses;

    public Student (String studentName, String studentId) {
        //initialize
        name = studentName;
        id = studentId;
        numCourses = 0;

        //initialize the array
        courses = new String[MAX_COURSES];
    }

    public boolean enrollCourse(String course) {
        if (numCourses >= MAX_COURSES) {
            return false;   //we can't add because array is full
        }
        else {
            courses[numCourses] = course;
            numCourses++;
            return false;
        }
    }

    public String toString() {
        String msg = name + " (" + id + ")\n";
        for (int i = 0; i < courses.length; i++) {
            msg += courses[i] + ", ";
        }
        return msg;
    }


    //setters / getters
    public String getName() {
        return name;
    }
    public String getId(){
        return id;
    }
    public void setName (String studentName) {
        name = studentName;
    }


}








