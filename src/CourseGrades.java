import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CourseGrades {

    public static void main(String[] args) {
        String fileName = "student_grades.txt";
        GradeBook gradeBook = new GradeBook();
        Scanner scanner = new Scanner(System.in);

        String teacherName = "";
        String courseName = "";

        while (true) {
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n","Enter 1 to enter teacher name","Enter 2 to enter course name", "Enter 3 to add a student (up to 12)",
                    "Enter 4 to remove student","Enter 5 to put in grades", "Enter 6 to exit");

            int inputValue = scanner.nextInt();

            if (inputValue == 1) {
                System.out.print("Enter teacher name:\n>>>");
                teacherName = scanner.next();
                System.out.println(teacherName);
            } else if (inputValue == 2) {
                System.out.print("Enter course name:\n>>>");
                courseName = scanner.next();
                System.out.println(courseName);
            } else if (inputValue == 3) {
                System.out.print("Enter student to add:\n>>>");
                String name = scanner.next();
                if (gradeBook.getAllStudents().size() <= 12) {
                    Student student = new Student(name);
                    gradeBook.addStudent(student);
                }
            } else if (inputValue == 4) {
                System.out.print("Enter student to remove:\n>>>");
                String name = scanner.next();
                for (Student student : gradeBook.getAllStudents()) {
                    if (student.getStudentName().equals(name)) {
                        gradeBook.removeStudent(student);
                        break;
                    }
                }
            } else if (inputValue == 5) {
                System.out.print("Enter student name to change grades:\n>>>");
                scanner.nextLine();
                String name = scanner.nextLine();
                boolean found = false;
                for (Student student : gradeBook.getAllStudents()) {
                    if (student.getStudentName().equals(name)) {
                        for (int i = 0; i < 5; i++) {
                            System.out.print("Enter grade # " + (i + 1) + " for student " + name + ": ");
                            int grade = scanner.nextInt();
                            student.setGrade(i, grade);
                            System.out.println(student.getGrade(i));
                        }
                        found = true;
                        System.out.println("Student average: " + gradeBook.studentAvg(name) + "%");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            } else if (inputValue == 6) {
                try {
                    File file = new File(fileName);
                    boolean empty = file.length() == 0;

                    // Create a FileWriter, with "append" set to true so that we can add new data to the text file
                    FileWriter writer = new FileWriter(file, true);

                    writer.write(courseName + "\n");
                    writer.write(teacherName);

                    for (Student student : gradeBook.getAllStudents()) {
                        writer.write(student.getStudentName());
                        writer.write(" ");
                        writer.write(Arrays.toString(student.getGrades()));
                        writer.write("\n");
                    }

//                    if (!empty) { // Make sure we don't create a blank line on the first line
//                        writer.write("\n" + scanner.next());
//                    } else {
//                        writer.write(scanner.next());
//                    }
                    writer.close();
                } catch (IOException o) {
                    System.out.println("An error occurred.");
                    o.printStackTrace();
                }

                System.exit(0);
            } else {
                System.out.println("Error Try Again!");
            }
        }
    }
}

//menu didnt work initally when used input.next int()
//or for next line when used it for strings made extra scanner which was unncessary but it did get menu option1 to run
//tried to run with a hashmap but could not figure out how to print that
//file writing did not initally work because multiple try catch methods


/*Error PS C:\Users\riyapate3612\Downloads\hell\hell>  & 'C:\Program Files\Java\jdk-22\bin\java.exe' '@C:\Users\RIYAPA~1\AppData\Local\Temp\cp_4kjjj8w4yxrvlvn1tspe6ch8h.argfile' 'CourseGrades'
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        scanner2 cannot be resolved


        at CourseGrades.main(CourseGrades.java:42)
PS C:\Users\riyapate3612\Downloads\hell\hell> ^C
PS C:\Users\riyapate3612\Downloads\hell\hell>
PS C:\Users\riyapate3612\Downloads\hell\hell>  c:; cd 'c:\Users\riyapate3612\Downloads\hell\hell'; & 'C:\Program Files\Java\jdk-22\bin\java.exe' '@C:\Users\RIYAPA~1\AppData\Local\Temp\cp_4kjjj8w4yxrvlvn1tspe6ch8h.argfile' 'CourseGrades'
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        scanner2 cannot be resolved


        at CourseGrades.main(CourseGrades.java:42)


        that error was because runnign wrong version of file and one uysing scanner 2 was commented out*/
//built menu did not compile on vs code but did on personal
// student cannot be accessed even though everything is public fixed by moving tyo another folder
//when eneter student does anything should prompt to add gerade because soley added to the list of studenst and the array is empty fopr student
//whole menu should be in a while loop it wasnt
//should keep prompting to do stuff in gradebook till exit
//assignment sai dmake grdaes int not double
//index out of bounds excpetioon for when enterring grades
// used next line when use next
//If statement to get to the loop kept being false
//concurrent modification error fixed with a break
//nothing is being written to the file after exit
//doesnt print teacher or course name when variable declared