public class Course {

    String courseCode;
    String courseTitle;
    Student[] enrolledStudents;
    int enrollmentCount = 0;

    static String schoolName = "My University";

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.enrolledStudents = new Student[50];
    }

    public void enrollStudent(Student student) {
        enrolledStudents[enrollmentCount] = student;
        enrollmentCount++;
    }

    public void displayCourseInfo() {
        System.out.println("SCHOOL NAME: " + schoolName);
        System.out.println("COURSE CODE: " + courseCode);
        System.out.println("COURSE TITLE: " + courseTitle);
        System.out.println("\nENROLLED STUDENTS:");

        for (int i = 0; i < enrollmentCount; i++) {
            enrolledStudents[i].displayStudentInfo();
            System.out.println();
        }
    }

    public static String getSchoolName() {
        return schoolName;
    }
}
