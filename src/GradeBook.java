import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getAllStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void changeGrade(String name) {
        for (Student obj : this.getAllStudents()) {
            if (obj.getStudentName().equals(name)) {

            }
        }
    }

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