import java.util.ArrayList;

public class Faculty {
    private static ArrayList<Faculty> faculties = new ArrayList<Faculty>();
    private String nameOfFaculty;
    private ArrayList<Direction> directions = new ArrayList<Direction>();
    public Faculty(String nameOfFaculty, ArrayList<Direction> directions) {
        this.nameOfFaculty = nameOfFaculty;
        this.directions = directions;
    }
    public static ArrayList<Faculty> facultiesBook() {
        return faculties;
    }
    public ArrayList<Direction> fac_dir() {
        return directions;
    }
    public String getNameOfFaculty() {
        return nameOfFaculty;
    }
}
