import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Student {
    private static ArrayList<Student> studentBook = new ArrayList<Student>();
    private String name;
    private String surname;
    private String middleName;
    private Calendar birthDate;
    private String phoneNumber;
    private String mail;
    private int course;
    private  Faculty faculty;
    private Direction direction;
    public Student(String name, String surname, String middleName, Calendar birthDate, String phoneNumber, String mail, int course, Faculty faculty, Direction direction) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.course = course;
        this.faculty = faculty;
        this.direction = direction;
    }
    public static ArrayList<Student> getStudentBook() {
        return studentBook;
    }
    public String getSurname() {
        return surname;
    }
    public String  getPhoneNumber() {
        return phoneNumber;
    }
    public String getMail() {
        return mail;
    }
    public Faculty getFaculty() {
        return faculty;
    }
    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getFIO() {
        return surname + " " + name + " " + middleName;
    }
    public int getCourse() {
        return course;
    }
    public Direction getDirection() {
        return direction;
    }
    public void GetInfo() {
        System.out.println("Surname: " + surname);
        System.out.println("Name: " + name);
        System.out.println("Middle name: " + middleName);
        Date date = birthDate.getTime();
        System.out.println("Birth Date: " + date );
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Mail: " + mail);
        System.out.println("Course: " + course);
        System.out.println("Faculty: " + faculty.getNameOfFaculty());
        System.out.println("Direction: " + direction.getName());
    }
}
