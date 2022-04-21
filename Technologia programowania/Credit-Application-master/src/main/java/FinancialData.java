public class FinancialData {

    private int totalMonthlyIncomeInPLN;
    private int numOfFamilyMembers;

    public int getTotalMonthlyIncomeInPLN() {
        return totalMonthlyIncomeInPLN;
    }

    public int getNumOfFamilyMembers() {
        return numOfFamilyMembers;
    }

    public FinancialData(int totalMonthlyIncomeInPLN, int numOfFamilyMembers) {
        this.totalMonthlyIncomeInPLN = totalMonthlyIncomeInPLN;
        this.numOfFamilyMembers = numOfFamilyMembers;
    }

}

