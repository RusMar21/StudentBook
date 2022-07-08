import java.util.ArrayList;

public class Direction {
    private static ArrayList<Direction> allDirections = new ArrayList<Direction>();
    private String nameOfDirection;
    private ArrayList<Subject> subjects = new ArrayList<Subject>();
    public Direction(String nameOfDirection, ArrayList<Subject> subjects) {
        this.nameOfDirection = nameOfDirection;
        this.subjects = subjects;
    }
    public String getName() {
        return nameOfDirection;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public static ArrayList<Direction> getAllDirections() {
        return allDirections;
    }
}
