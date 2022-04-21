public class IncomeCalculator {

    private int totalMonthlyIncomeInPLN;
    private int numOfFamilyMembers;
    public static final int cons = 2000;

    public IncomeCalculator(int totalMonthlyIncomeInPLN, int numOfFamilyMembers) {
        this.totalMonthlyIncomeInPLN = totalMonthlyIncomeInPLN;
        this.numOfFamilyMembers = numOfFamilyMembers;
    }

    public DecisionType incomePerFamilyMember() {

        if (totalMonthlyIncomeInPLN / numOfFamilyMembers > cons) {
            return DecisionType.POSITIVE;
         } else {
            return DecisionType.NEGATIVE;
        }
    }

}
