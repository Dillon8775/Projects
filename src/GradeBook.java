import java.util.ArrayList;

public class GradeBook {
    private final ArrayList<Student> students = new ArrayList<>(); // Array list of students

    /**
     * Returns the array list of students.
     */
    public ArrayList<Student> getAllStudents() {
        return this.students;
    }

    /**
     * Adds a student to the array list of students.
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the array list of students.
     */
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    /**
     * Returns the average % of a student's grades.
     */
    public int studentAvg(String studentName) {
        int allGradesAddedUp = 0;
        String validName = "";
        for (Student student : students) {
            if (student.getStudentName().equals(studentName)) {
                validName = studentName;
                for (int grade : student.getGrades()) {
                    allGradesAddedUp += grade;
                }
            }
        }
        if (validName.isEmpty()) {
            System.out.println("Student not found!");
            return 0;
        } else {
            return allGradesAddedUp / 5;
        }
    }

    // Unused method
    public int testAvg(String studentName, int test) {
        int total = 0;
        Student studentToUse = null;
        for (Student student : students) {
            if (student.getStudentName().equals(studentName)) {
                studentToUse = student;
                for (int i = 0; i < student.getGrades().length; i++) {
                    total += student.getGrade(test);
                }
            }
        }

        if (studentToUse == null) {
            System.out.println("Student not found!");
            return 0;
        } else {
            return total / studentToUse.getGrades().length;
        }
    }
}