
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CTRL + ALT + T -tworzenie klasy do testu jednostkowego
 */
class IncomeCalculatorTest {

    @Test
    public void test(){
        //given
        int totalMonthlyIncomeInPLN = 2000;
        int numOfFamilyMembers = 4;
        IncomeCalculator cut = new IncomeCalculator(totalMonthlyIncomeInPLN,numOfFamilyMembers); //cut- class under test
        //when
        DecisionType result = cut.incomePerFamilyMember();
        //then
        assertEquals(DecisionType.NEGATIVE,result);
    }
    //
    @Test
    public void test2(){
        //given
        int totalMonthlyIncomeInPLN = 11000;
        int numOfFamilyMembers = 4;
        IncomeCalculator cut = new IncomeCalculator(totalMonthlyIncomeInPLN,numOfFamilyMembers); //cut- class under test
        //when
        DecisionType result = cut.incomePerFamilyMember();
        //then
        assertEquals(DecisionType.POSITIVE,result);
    }

}