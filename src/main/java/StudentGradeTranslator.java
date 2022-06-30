/*
 * Using the code we wrote together in the previous lesson as a baseline, create a new method in the GradeCalculator interface 
   that will return the number of grade points needed for the numeric grade passed in to map to the next letter grade. 
 * Let's call this method howManyForNextLetter() - here is its signature:
   public int howManyForNextLetterGrade(int numberGrade);
 * For example, if numberGrade is 67, then this method will return 3 if the grading method is "heavy", 
   it will return 8 if the grading method is "slight" and 3 is the grading method is "flat".
 */

public class StudentGradeTranslator {

    GradeCalculator gradeCalculator;

    public StudentGradeTranslator() {
        this.gradeCalculator = new FlatCurveGradeCalculator();
    }

    public StudentGradeTranslator(String gradingMethod) {
        if (gradingMethod == null) {
            this.gradeCalculator = new FlatCurveGradeCalculator();
        } else if (gradingMethod.equals("FLAT")) {
            this.gradeCalculator = new FlatCurveGradeCalculator();
        } else if (gradingMethod.equals("SLIGHT")) {
            this.gradeCalculator = new SlightCurveGradeCalculator();
        } else if (gradingMethod.equals("HEAVY")) {
            this.gradeCalculator = new HeavyCurveGradeCalculator();
        }
    }

    public String getLetterGrade(int numberGrade) {
        return gradeCalculator.getLetterGrade(numberGrade);
    }

    public int howManyForNextLetterGrade(int numberGrade) {
        return gradeCalculator.howManyForNextLetterGrade(numberGrade);
    }

    public boolean isPassingGrade(int numberGrade) {
        return gradeCalculator.isPassingGrade(numberGrade);
    }

    interface GradeCalculator {
        public String getLetterGrade(int numberGrade);
        public boolean isPassingGrade(int numberGrade);
        public int howManyForNextLetterGrade(int numberGrade);
    }

    class FlatCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 60) {
                return "F";
            }
            if (numberGrade < 70) {
                return "D";
            }
            if (numberGrade < 80) {
                return "C";
            }
            if (numberGrade < 90) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 60) return true;
            return false;
        }

        @Override
        public int howManyForNextLetterGrade(int numberGrade) {
            if (numberGrade < 0 || numberGrade > 100)
                return -1;
            if (numberGrade >= 90) { // 90-100
                return 0;
            } else if (numberGrade >= 80 && numberGrade < 90) { // 81-89
                return 90-numberGrade;
            } else if (numberGrade >=70 && numberGrade < 80) { // 70-79
                return 80-numberGrade;
            } else if (numberGrade >=60 && numberGrade < 70) { // 60-69
                return 70-numberGrade;
            } else if (numberGrade <= 59) { // 0-59
                return 60-numberGrade;
            }  
            return -1;
        }

    }

    class SlightCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 55) { //0-54
                return "F";
            }
            if (numberGrade < 65) { //55-64
                return "D";
            }
            if (numberGrade < 75) { //65-74
                return "C";
            }
            if (numberGrade < 85) { //75-84
                return "B";
            }
            return "A"; // 85-100
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 55) return true;
            return false;
        }

        @Override
        public int howManyForNextLetterGrade(int numberGrade) {
            if (numberGrade < 0 || numberGrade > 100)
                return -1;
            if (numberGrade >= 85) { // 85-100
                return 0;
            } else if (numberGrade >= 75 && numberGrade <= 84) { // 75-84
                return 85-numberGrade;
            } else if (numberGrade >= 65 && numberGrade <= 74) { // 65-74
                return 75-numberGrade;
            } else if (numberGrade >=55 && numberGrade <= 64) { // 55-64
                return 65-numberGrade;
            } else if (numberGrade <= 54) { // 0-54
                return 55-numberGrade;
            }  
            return -1;
        }
    }

    class HeavyCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 50) { // 0-49
                return "F";
            }
            if (numberGrade < 60) { // 50-59
                return "D";
            }
            if (numberGrade < 70) { // 60-69
                return "C";
            }
            if (numberGrade < 80) { // 70-79
                return "B";
            }
            return "A"; // 80-100
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 50) return true;
            return false;
        }

        @Override
        public int howManyForNextLetterGrade(int numberGrade) {
            if (numberGrade < 0 || numberGrade > 100)
                return -1;
            if (numberGrade >= 80) { // 80-100
                return 0;
            } else if (numberGrade >= 70 && numberGrade <= 79) { // 70-79
                return 80-numberGrade;
            } else if (numberGrade >= 60 && numberGrade <= 69) { // 60-69
                return 70-numberGrade;
            } else if (numberGrade >= 50 && numberGrade <= 59) { // 50-59
                return 60-numberGrade;
            } else if (numberGrade <= 49) { // 0-49
                return 50-numberGrade;
            } 
            return -1;
        }
    }
}