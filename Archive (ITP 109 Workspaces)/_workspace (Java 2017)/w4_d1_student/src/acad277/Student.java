package acad277;

/*
    String id
    String name
    array of courses (String name of courses)
    int numberOfCourses

    String major
    d-clear for specific courses
    double GPA
    int year

 */
public class Student {
    public final static int MAX_COURSES = 6;
    public static int numStudents = 0;

    private String name;
    private String id;
    private String[] courses;       //typically DO declare but don't initialize the array
    private int numberOfCourses;    //how many courses are you enrolled in

    //constructor
//    public Student (String n, String i){
    public Student (String n){
        name = n;
        id = Integer.toString(numStudents);     //converts an int to a String
        numStudents++;
        numberOfCourses = 0;    //no courses enrolled
        courses = new String[MAX_COURSES];
    }


    public String getName () {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    public String getId () {
        return id;
    }
    public int getNumberOfCourses() {
        return numberOfCourses;
    }
    public String[] getCourse() {
        return courses;
    }
    public String getCourseString() {
        String result = "";
        for (int i = 0; i < numberOfCourses; i++) {
            result += courses[i] + " ";
        }
        return result;
    }
    public void displayInfo () {
        System.out.println("Student: " + name
                            + ", id: " + id
                            + "\n\t" + getCourseString());
    }

    public boolean addCourse(String nameOfCourse) {
        boolean success;
        if(numberOfCourses >= MAX_COURSES) {
            System.out.println("You are already enrolled in the max number of courses");
            success = false;
        }
        else {
            courses[numberOfCourses] = nameOfCourse;
            numberOfCourses++;
            success = true;
        }
        return success;
    }

    public boolean deleteCourse(String nameOfCourse) {
        boolean success = false;        //flag

        for (int i = 0; i < courses.length; i++){
            if (courses[i].equalsIgnoreCase(nameOfCourse)) {
                courses[i] = "";
                numberOfCourses--;
                success = true;
                break;
            }
        }
        if (success == false) {
            System.out.println("Course not found");
        }
        return success;

    }









}







