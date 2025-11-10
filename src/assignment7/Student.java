package assignment7;

public class Student {
	private String firstName;
    private String lastName;
    private int Id;
    private int totalAttemptedCredits;
    private int totalPassingCredits;
    private double totalQualityPoints;
    private double bearBucksBalance;

    public Student(String firstName, String lastName, int Id, int totalAttemptedCredits, int totalPassingCredits, double totalQualityPoints, double bearBucksBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = Id;
        this.totalAttemptedCredits = totalAttemptedCredits;
        this.totalPassingCredits = totalPassingCredits;
        this.totalQualityPoints = totalQualityPoints;
        this.bearBucksBalance = bearBucksBalance;
    }

    public Student(String firstName, String lastName, int Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = Id;
    }    

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getId() {
        return Id;
    }

    public int getTotalAttemptedCredits() {
        return totalAttemptedCredits;
    }

    public int getTotalPassingCredits() {
        return totalPassingCredits;
    }

    public double calculateGradePointAverage() {
        if (totalAttemptedCredits == 0) {
        return 0;
        }
        return totalQualityPoints / totalAttemptedCredits;
    }

    public void submitGrade(double grade, int credits) {
        totalAttemptedCredits += credits;
        totalQualityPoints += grade * credits;
        if (grade >= 1.7) {
            totalPassingCredits += credits;
        }
    }

    public String getClassStanding() {
        if (totalPassingCredits < 30) {
            return "First Year";
        }
        else if (totalPassingCredits < 60) {
            return "Sophomore";
        }
        else if (totalPassingCredits < 90) {
            return "Junior";
        }
        else {
            return "Senior";
        }
    }

    public boolean isEligibleForPhiBetaKappa() {
        double GPA = calculateGradePointAverage();
        if (totalAttemptedCredits >= 98 && GPA >= 3.60) {
            return true;
        }
        if (totalAttemptedCredits >= 75 && GPA >= 3.80) {
            return true;
        }
        return false;
    }

    public void depositBearBucks(double amount) {
        bearBucksBalance += amount;
    }

    public void deductBearBucks(double amount) {
        bearBucksBalance -= amount;
    }

    public double getBearBucksBalance() {
        return bearBucksBalance;
    }

    public double cashOutBearBucks() {
        double amountToReturn;
        if (bearBucksBalance > 10.0) {
            amountToReturn = bearBucksBalance - 10.0;
        } else {
            amountToReturn = 0.0;
        }
        bearBucksBalance = 0.0;
        return amountToReturn;
    }

    public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
        String legacyLastName;
        if (isHyphenated) {
            legacyLastName = this.lastName + "-" + otherParent.lastName;
        } 
        else {
            legacyLastName = this.lastName;
        }
        Student child = new Student(firstName, legacyLastName, id);
        double myMoney = this.cashOutBearBucks();
        double theirMoney = otherParent.cashOutBearBucks();
        child.bearBucksBalance = myMoney + theirMoney;
        return child;
    }

    public String toString() {
        return getFullName() + getId();
    }
}
