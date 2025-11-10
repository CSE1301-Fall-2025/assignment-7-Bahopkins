package assignment7;

public class Course {
	private String name;
    private int credits;
    private int capacity;
    private Student[] roster;
    private int enrolled;

    public Course(String name, int credits, int capacity) {
        this.name = name;
        this.credits = credits;
        this.capacity = capacity;
        this.roster = new Student[capacity];
        this.enrolled = 0;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsRemaining() {
        return capacity - enrolled;
    }

    public boolean addStudent(Student s) {
        for (int i = 0; i < enrolled; i++) {
            if (roster[i].getId() == s.getId()) {
                return false;
            }
        }
        if (enrolled < capacity) {
            roster[enrolled] = s;
            enrolled++;
            return true;
        }
        return false;
    }

    public Student getStudentAt(int index) {
        return roster[index];
    }

    public String generateRoster() {
        String result = "";
        for (int i = 0; i < enrolled; i++) {
            result += roster[i].getFullName();
            if (i < enrolled - 1) {
                result += "\n";
            }
        }
        return result;
    }

    public double calculateAverageGPA() {
        if (enrolled == 0) {
            return 0;
        }
        double totalGPA = 0;
        for (int i = 0; i < enrolled; i++) {
            totalGPA += roster[i].calculateGradePointAverage();
        }
        return totalGPA / enrolled;
    }

    public String toString() {
        return name + " (" + credits + " credits";
    }
}
