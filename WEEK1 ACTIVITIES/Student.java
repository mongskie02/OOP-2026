public class Student {
    int studentID;
    String firstName;
    String middleName;
    String lastName;
    String gender;
    String email;
    int totalStudents;

    public Student(int studentID, String firstName, String middleName, String lastName, String gender, String email) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Student () {
        
    }
    
    public void displayStudentInfo() {
        System.out.println("----STUDENT INFORMATION----");
        System.out.println("STUDENT ID: " + this.studentID);
        System.out.println("FIRST NAME:" + this.middleName);
        System.out.println("MIDDLE NAME: " + this.middleName );
        System.out.println("LAST NAME: " + this.lastName);
        System.out.println("GENDER: " + this.gender);
        System.out.println("EMAIL: " + this.email);

    }
    public static int getTotalStudents() {
        return totalStudents;


    }


    



}
