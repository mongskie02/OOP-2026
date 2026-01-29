public class Meyn {
    public static void main(String[] args) {

        System.out.println("Initial number of students: "
                + Student.getTotalStudents());

        Student s1 = new Student(101, "Tangol", "T.", "GACAYAN", "Male", "tangol@email.com");
        Student s2 = new Student(102, "Bebot", "K.", "Corpuz", "Female", "bebot@email.com");
        Student s3 = new Student(103, "Carl", "L.", "tamods", "Female", "carl   @email.com");

        System.out.println("Total number of students after creation: "
                + Student.getTotalStudents());

        System.out.println("\nStudent Information:");
        s1.displayStudentInfo();

        System.out.println("\nSchool Name: " + Course.getSchoolName());

        Course course = new Course();

        course.enrollStudent(s1);
        course.enrollStudent(s2);

        System.out.println("\nCourse Information:");
        course.displayCourseInfo();
    }
}