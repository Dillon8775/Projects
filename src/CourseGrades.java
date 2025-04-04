import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CourseGrades {

    public static void main(String[] args) {
        String fileName = "student_grades.txt";
        GradeBook gradeBook = new GradeBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n","Enter 1 to enter teacher name","Enter 2 to enter course name", "Enter 3 to add a student (up to 12)",
                    "Enter 4 to remove student","Enter 5 to put in grades", "Enter 6 to exit");

            int inputValue = scanner.nextInt();

            if (inputValue == 1) {
//            teacherName = scanner.next();
//            System.out.println("Teacher Name: "+ teacherName);
            } else if (inputValue == 2) {
//            courseName = scanner.next();
//            System.out.println("Course Name: "+courseName);
            } else if (inputValue == 3) {
                System.out.print("Enter student to add:\n>>>");
                String name = scanner.nextLine();
                if (gradeBook.getAllStudents().size() <= 12) {
                    Student student = new Student(name);
                    gradeBook.addStudent(student);
                }
            } else if (inputValue == 4) {
                System.out.print("Enter student name to change grades:\n>>>");
                String name = scanner.nextLine();
                for (Student student : gradeBook.getAllStudents()) {
                    if (student.getStudentName().equals(name)) {
                        for (int i = 0; i < 5; i++) {
                            System.out.print("Enter grade # " + (i + 1) + " for student " + name);
                            int grade = scanner.nextInt();
                            student.setGrade(i, grade);
                            System.out.println(student.getGrade(i));
                        }
                    }
                }
            } else if (inputValue==5) {

            } else if (inputValue==6){

            } else {
                System.out.println("Error Try Again!");
            }

            try {
                File file = new File(fileName);
                boolean empty = file.length() == 0;

                // Create a FileWriter, with "append" set to true so that we can add new data to the text file
                FileWriter writer = new FileWriter(file, true);

                if (!empty) { // Make sure we don't create a blank line on the first line
                    writer.write("\n" + scanner.next());
                } else {
                    writer.write(scanner.next());
                }
                writer.close();
            } catch (IOException o) {
                System.out.println("An error occurred.");
                o.printStackTrace();
            }
        }
    }
}