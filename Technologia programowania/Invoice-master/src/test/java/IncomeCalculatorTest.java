import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientsDataTest {


    @Test
    public void test() {
        //given
        Components component1 = new Components(ComponentType.COAT,200,1);
        Components component2 = new Components(ComponentType.SHIRT,80,2);
        Components[] components = {component1,component2};
        ClientsData cut = new ClientsData("Test","Test", components,1);
        //when
        double result = cut.getSumOfComponents();
        //then
        assertEquals(200*1 + 80*2,result);
    }

}
