import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static boolean CheckNum(String reg, String number) {
        return Pattern.matches(reg, number);
    }
    public static  boolean CheckMail(String reg, String mail) {
        return Pattern.matches(reg, mail);
    }
    public static void createDefaultValues() {
        // Предметы
        Subject subject = new Subject("Math");
        Subject subject1 = new Subject("Informatics");
        Subject subject2 = new Subject("Theory of Cyber Security");
        Subject subject3 = new Subject("Programming");
        Subject subject4 = new Subject("Russian Language");
        Subject subject5 = new Subject("English Language");
        Subject subject6 = new Subject("Physical Culture");
        Subject subject7 = new Subject("Literature");
        Subject subject8 = new Subject("Culture of country");
        Subject subject9 = new Subject("Design");
        Subject subject10 = new Subject("History of design");
        Subject subject11 = new Subject("History");
        // Списки предметов
        // Практическое ИБ
        ArrayList<Subject> progSub = new ArrayList<Subject>();
        progSub.add(subject);
        progSub.add(subject1);
        progSub.add(subject3);
        progSub.add(subject6);
        // ИБ Теор
        ArrayList<Subject> cyberSecSub = new ArrayList<Subject>();
        cyberSecSub.add(subject);
        cyberSecSub.add(subject1);
        cyberSecSub.add(subject2);
        cyberSecSub.add(subject6);
        // Лингвисты
        ArrayList<Subject> lingSub = new ArrayList<Subject>();
        lingSub.add(subject);
        lingSub.add(subject4);
        lingSub.add(subject5);
        lingSub.add(subject6);
        // Литература
        ArrayList<Subject> litSub = new ArrayList<Subject>();
        litSub.add(subject);
        litSub.add(subject4);
        litSub.add(subject8);
        litSub.add(subject6);
        litSub.add(subject7);
        // Дизайн
        ArrayList<Subject> desSub = new ArrayList<Subject>();
        desSub.add(subject);
        desSub.add(subject2);
        desSub.add(subject6);
        desSub.add(subject9);
        desSub.add(subject10);
        // История
        ArrayList<Subject> hisSub = new ArrayList<Subject>();
        hisSub.add(subject);
        hisSub.add(subject4);
        hisSub.add(subject6);
        hisSub.add(subject8);
        hisSub.add(subject11);
        // Направления
        Direction practice_cyberSecurity = new Direction("Practice CyberSecurity",progSub);
        Direction theory_cyberSecurity = new Direction("Theory CyberSecurity", cyberSecSub);
        Direction linguistic = new Direction("Linguistic", lingSub);
        Direction literature = new Direction("Literature", litSub);
        Direction design_practice = new Direction("Design", desSub);
        Direction history = new Direction("History", hisSub);
        // Списки направлений
        ArrayList<Direction> cyberSecurity_dir = new ArrayList<Direction>();
        cyberSecurity_dir.add(practice_cyberSecurity);
        Direction.getAllDirections().add(practice_cyberSecurity);
        cyberSecurity_dir.add(theory_cyberSecurity);
        Direction.getAllDirections().add(theory_cyberSecurity);
        ArrayList<Direction> humanities_dir = new ArrayList<Direction>();
        humanities_dir.add(linguistic);
        Direction.getAllDirections().add(linguistic);
        humanities_dir.add(history);
        humanities_dir.add(literature);
        Direction.getAllDirections().add(literature);
        Direction.getAllDirections().add(design_practice);
        Direction.getAllDirections().add(history);
        ArrayList<Direction> design_dir = new ArrayList<Direction>();
        design_dir.add(design_practice);
        //Факультеты
        Faculty cyberSecurity = new Faculty("CyberSecurity", cyberSecurity_dir);
        Faculty humanities = new Faculty("Humanities", humanities_dir);
        Faculty design = new Faculty("Design", design_dir);
        Faculty.facultiesBook().add(cyberSecurity);
        Faculty.facultiesBook().add(humanities);
        Faculty.facultiesBook().add(design);

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String reg_number = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        String reg_mail = "^[A-Za-z0-9+_.-]+@(.+)$";
        createDefaultValues();
        boolean flag_1 = true;
        System.out.println("Hi, it's Student DataBase");
        while (flag_1) {
            System.out.println("Choose operation: Search(1) / Sort(2) / Output(3) / Add student(4) / Exit(5)");
            System.out.print("Point: ");
            int pnt = in.nextInt();
            switch (pnt) {
                // Поиск
                case 1:
                    boolean flag_2 = true;
                    while (flag_2) {
                        System.out.println("Search: Surname(1) / Phone number(2) / Mail(3) / Main page(4)");
                        System.out.print("Point: ");
                        int pnt_1 = in.nextInt();
                        switch (pnt_1) {
                            case 1:
                                System.out.print("Surname: ");
                                in.nextLine();
                                String search_sur = in.nextLine();
                                Student.getStudentBook().stream().filter(s -> s.getSurname().equals(search_sur)).forEach(student -> student.GetInfo());;
                                break;
                            case 2:
                                System.out.print("Phone number: ");
                                in.nextLine();
                                String phone = in.nextLine();
                                Student.getStudentBook().stream().filter(student -> student.getPhoneNumber().equals(phone)).forEach(student -> student.GetInfo());
                                break;
                            case 3:
                                System.out.print("Mail: ");
                                in.nextLine();
                                String mail = in.nextLine();
                                Student.getStudentBook().stream().filter(student -> student.getMail().equals(mail)).forEach(student -> student.GetInfo() );
                                break;
                            case 4:
                                System.out.println("Return to main page");
                                flag_2 = false;
                                break;
                        }
                    }
                    break;
                // Сортировка с общим кол-вом
                case 2:
                    boolean flag_3 = true;
                    System.out.println("Sort: Faculty(1) / Direction(2) / Course(3) / Main page(4)");
                    System.out.print("Point: ");
                    int pnt_2 = in.nextInt();
                    while (flag_3) {
                        switch (pnt_2) {
                            case 1:
                                System.out.println("Faculty: CyberSecurity(1) / Humanities(2) / Design(3) / Main page(4)");
                                System.out.print("Point: ");
                                int pnt_3 = in.nextInt();
                                Student.getStudentBook().stream().filter(student -> student.getFaculty().getNameOfFaculty().equals(Faculty.facultiesBook().get(pnt_3 - 1).getNameOfFaculty())).forEach(student -> System.out.println(student.getFIO()));
                                System.out.print("Count: ");
                                System.out.println(Student.getStudentBook().stream().filter(student -> student.getFaculty().getNameOfFaculty().equals(Faculty.facultiesBook().get(pnt_3 - 1).getNameOfFaculty())).count());
                                System.out.println("Return to Main page");
                                flag_3 = false;
                                break;
                            case 2:
                                System.out.println("Directions: Practice CyberSecurity(1) / Theory CyberSecurity(2) / Linguistic(3) / Literature(4) / Design(5) / History(6)");
                                System.out.print("Point: ");
                                int dir = in.nextInt();
                                Student.getStudentBook().stream().filter(student -> student.getDirection().getName().equals(Direction.getAllDirections().get(dir - 1).getName())).forEach(student -> System.out.println(student.getFIO()));
                                System.out.print("Count: ");
                                System.out.println(Student.getStudentBook().stream().filter(student -> student.getDirection().getName().equals(Direction.getAllDirections().get(dir - 1).getName())).count());
                                System.out.println("Return to Main page");
                                flag_3 = false;
                                break;
                            case 3:
                                System.out.print("Course(1 to 4): ");
                                int course = in.nextInt();
                                Student.getStudentBook().stream().filter(student -> student.getCourse() == course).forEach(student -> System.out.println(student.getFIO()));
                                System.out.print("Count: ");
                                System.out.println(Student.getStudentBook().stream().filter(student -> student.getCourse() == course).count());
                                System.out.println("Return to Main page");
                                flag_3 = false;
                                break;
                            case 4:
                                System.out.println("Return to main page");
                                flag_3 = false;
                                break;
                        }
                    }
                    break;
                // Вывод
                case 3:
                    boolean flag_4 = true;
                    while (flag_4) {
                        System.out.println("Output: Student(1) / Faculty(2) / Main Page(3) ");
                        System.out.print("Point: ");
                        int pnt_3 = in.nextInt();
                        switch (pnt_3) {
                            // Список Студентов
                            case 1:
                                Student.getStudentBook().stream().forEach(student -> student.GetInfo());
                                System.out.print("Count: ");
                                System.out.println(Student.getStudentBook().stream().count());
                                break;
                            // Список факультетов
                            case 2:
                                Faculty.facultiesBook().stream().forEach(faculty -> System.out.println(faculty.getNameOfFaculty()));
                                System.out.print("Count: ");
                                System.out.println(Faculty.facultiesBook().stream().count());
                                break;
                            case 3:
                                System.out.println("Return to main page");
                                flag_4 = false;
                                break;
                        }
                    }
                    break;
                // Добавление
                case 4:
                    System.out.println("Add information: ");
                    System.out.print("Surname: ");
                    in.nextLine();
                    String surname = in.nextLine();
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Middle name: ");
                    String middle_name = in.nextLine();
                    System.out.println("BirthDate: ");
                    System.out.print("Day of birth: ");
                    int day = in.nextInt();
                    System.out.print("Month of birth: ");
                    int month = in.nextInt();
                    System.out.print("Year of birth: ");
                    int year = in.nextInt();
                    Calendar birthDate = new GregorianCalendar(year, month - 1, day);
                    Date date = birthDate.getTime();
                    System.out.println(date);
                    boolean flag = true;
                    // Метод для проверки корректности номера
                    String number = "";
                    while (flag) {
                        System.out.println("Pattern of number: +79xx-xxx-xx-xx" );
                        System.out.print("Phone number: ");
                        in.nextLine();
                        number = in.nextLine();
                        if (CheckNum(reg_number, number)) {
                            System.out.println("Number is correct");
                            flag = false;
                        } else {
                            System.out.println("Number is incorrect");
                        }
                    }
                    flag = true;
                    // Метод для проверки корректности почты
                    String mail = "";
                    while (flag) {
                        System.out.print("Mail: ");
                        //in.nextLine();
                        mail = in.nextLine();
                        if (CheckMail(reg_mail, mail)) {
                            System.out.println("Mail is correct");
                            flag = false;
                        } else {
                            System.out.println("Mail is incorrect");
                        }
                    }
                    System.out.print("Course(1 to 4): ");
                    int course = in.nextInt();
                    System.out.print("Choose faculty: CyberSecurity(1) / Humanities(2) / Design(3) ");
                    int fac = in.nextInt();
                    // Выбор факультета
                    Faculty faculty = Faculty.facultiesBook().get(fac - 1);
                    ArrayList<Direction> dir = faculty.fac_dir();
                    System.out.println("Directions of Faculty: ");
                    String directions_fac = "";
                    for (int i = 0; i < dir.size(); i++) {
                        String name_dir = dir.get(i).getName();
                        directions_fac += name_dir + " / ";
                        int j = i + 1;
                        System.out.println(name_dir + " " + j);
                    }
                    // Выбор направления
                    System.out.println("Choose direction: " + directions_fac);
                    System.out.print("Number of direction: ");
                    int num = in.nextInt();
                    Direction direction = dir.get(num - 1);
                    System.out.println("Direction: " + direction.getName());
                    System.out.println("Subjects of Direction");
                    for (int i = 0; i < direction.getSubjects().size(); i++) {
                        String name_sub = direction.getSubjects().get(i).getName();
                        System.out.println(name_sub);
                    }
                    Student student = new Student(name, surname, middle_name, birthDate, number, mail, course, faculty, direction );
                    Student.getStudentBook().add(student);
                    System.out.println("Student added");
                    break;
                // Выход
                case 5:
                    System.out.println("Good bye!");
                    flag_1 = false;
                    break;
                default:
                    System.out.println("Incorrect point");
                    break;
            }
        }

    }
}
