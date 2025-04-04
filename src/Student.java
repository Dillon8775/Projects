public class Student {
    private final int[] grades = new int[5];
    private final String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public int getGrade(int i) {
        return this.grades[i];
    }

    public void setGrade(int index, int grade) {
        this.grades[index] = grade;
    }

    public String getStudentName() {
        return this.studentName;
    }
}