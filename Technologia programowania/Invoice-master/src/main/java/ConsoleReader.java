import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

     public List<ClientsData> read() {
         Scanner in = new Scanner(System.in);
         List<ClientsData> clientsList = new ArrayList<>();
         boolean condition = true;
         int id = 0;

         while (condition) {
             int decision = getDecision(in);
             if (decision == 1) {
                 String name = getName(in);
                 String lastName = getLastName(in);
                 Components[] components = getComponents(in);
                 id++;
                 ClientsData clientsData = new ClientsData(name, lastName, components, id);
                 clientsData.getSumOfComponents();
                 clientsList.add(clientsData);
             } else if (decision == 2) {
                 ClientsData client = getClient(in, clientsList);
                 client.getSumOfComponents();
                 condition = false;
             } else if (decision == 3) {
                 condition = false;
             }
         }
         return clientsList;
     }
    private ClientsData getClient(Scanner in, List<ClientsData> clientsList) {
        String input;
        do {
            System.out.println("Enter client's id:");
            input = in.next();
        } while(!NumberValidator.validateInteger(input,1,clientsList.size()));
        int resultId = Integer.valueOf(input);
        ClientsData clientsData = clientsList.get(resultId - 1);
        return clientsData;
    }

     private String getName(Scanner in){
         String input;
         do {
             System.out.println("Enter your name");
             input = in.next();
         } while(!StringValidator.validateString(input, Constants.NAME_REGEX));
         return input;
     }

    private String getLastName(Scanner in){
        String input;
        do {
            System.out.println("Enter your last name");
            input = in.next();
        } while(!StringValidator.validateString(input, Constants.LAST_NAME_REGEX));
        return input;
    }

    private Components[] getComponents(Scanner in){
         int numOfComponents = getNumOfComponents(in);
         Components[] components = new Components[numOfComponents];//the array must be initialized
        for(int i = 1; i <= numOfComponents; i++){
            ComponentType component = getComponentType(in,i);
            int quantityOfComponents = getQuantityOfComponents(in, i);
            double componentValue = getValueOfComponent(in,i);

            Components component1 = new Components(component, componentValue, quantityOfComponents);
            components[i-1] = component1;
        }
        return components;
    }

    private int getNumOfComponents(Scanner in) {
        String input; //pobieramy dana jako string

        do {
            System.out.println("How many types of components have you ordered?");
            input = in.next();
        }while(!NumberValidator.validateInteger(input,1,Integer.MAX_VALUE));
        int numOfComponents = Integer.valueOf(input); //robimy rzutowanie na Integera
        return numOfComponents;
    }

    private ComponentType getComponentType(Scanner in, int i){
         String componentInput;
         do {
             System.out.println("Enter type of component " + i + " " + generateComponentTypeElements());
             componentInput = in.next();
         }while(!EnumValidator.validateComponentType(componentInput));
         ComponentType component = ComponentType.valueOf(componentInput);
         return component;
    }

    private int getQuantityOfComponents(Scanner in, int i){
        String componentInput;
        do {
            System.out.println("Enter quantity of component " + i);
            componentInput = in.next();
        }while(!NumberValidator.validateInteger(componentInput,1,Integer.MAX_VALUE));
            int quantity = Integer.valueOf(componentInput);
            return quantity;
    }

    private double getValueOfComponent(Scanner in, int i){
        String componentInput;
        do {
            System.out.println("Enter (brutto)value of ordered component " + i);
            componentInput = in.next();
        }while(!NumberValidator.validateDouble(componentInput,1.0,Double.MAX_VALUE));
            double value = Double.valueOf(componentInput);
            return value;
    }

    private int getDecision(Scanner in){
         String input;
        do {
            System.out.println("Enter 1 to generate a new invoice or enter 2 to view the invoice for the customer or 3 to exit");
            input = in.next();
        }while(!NumberValidator.validateInteger(input,1,3));
        int decisionNumber = Integer.valueOf(input); //robimy rzutowanie na Integera
        return decisionNumber;
    }

    /**
     * Satisfied for GRASP(Open/close principle):
     * Adding an item will not change the functionality of getComponentType method
     */
    private String generateComponentTypeElements() {
        String elements = "(";
        for(int i = 0; i < ComponentType.values().length; i++){
            elements = elements + ComponentType.values()[i].name();
            if(i < ComponentType.values().length - 1){
                elements = elements + ", ";
            }
        }
        elements = elements + ")";
        return elements;
    }
}
