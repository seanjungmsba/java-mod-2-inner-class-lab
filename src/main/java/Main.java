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

        public int howManyForNextLetterGrade(int numberGrade) {

        }
    }

    class SlightCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 55) {
                return "F";
            }
            if (numberGrade < 65) {
                return "D";
            }
            if (numberGrade < 75) {
                return "C";
            }
            if (numberGrade < 85) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 55) return true;
            return false;
        }

        public int howManyForNextLetterGrade(int numberGrade) {
            
        }
    }

    class HeavyCurveGradeCalculator implements GradeCalculator {
        public String getLetterGrade(int numberGrade) {
            if (numberGrade < 50) {
                return "F";
            }
            if (numberGrade < 60) {
                return "D";
            }
            if (numberGrade < 70) {
                return "C";
            }
            if (numberGrade < 80) {
                return "B";
            }
            return "A";
        }

        public boolean isPassingGrade(int numberGrade) {
            if (numberGrade >= 50) return true;
            return false;
        }

        public int howManyForNextLetterGrade(int numberGrade) {
            
        }
    }
}