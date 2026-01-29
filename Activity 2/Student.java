public class Student {

    private int id;
    private String firstName, middleName, lastName, gender, email;
    private static int totalStudents = 0;

    public Student(int id, String firstName, String middleName,
                   String lastName, String gender, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        totalStudents++;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
    }
}
