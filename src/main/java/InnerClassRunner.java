import java.util.HashMap;
import java.util.Map;

public class InnerClassRunner {

    public static void main(String[] args) {

        String gradingMethod = "SLIGHT"; // FLAT // HEAVY
        StudentGradeTranslator gradeTranslator = new StudentGradeTranslator(gradingMethod);

        HashMap<String, String> studentGrades = new HashMap<String, String>();
        studentGrades.put("Student A", "54");
        studentGrades.put("Student B", "63");
        studentGrades.put("Student C", "77");
        studentGrades.put("Student D", "80");

        // get all the student and their grades using each entry
        System.out.println("List of students and their grades:");
        System.out.println("==================================");
        for (Map.Entry<String, String> studentGrade: studentGrades.entrySet()) {
            System.out.println(studentGrade.getKey() + "'s grade is " +
                    gradeTranslator.getLetterGrade(Integer.parseInt(studentGrade.getValue())));
            System.out.println("Passed? " + gradeTranslator.isPassingGrade(Integer.parseInt(studentGrade.getValue())));
            System.out.println("How many points needed to get next letter grade? " + gradeTranslator.howManyForNextLetterGrade(Integer.parseInt(studentGrade.getValue())));
            System.out.println("=====================================");
        }

    }

}
