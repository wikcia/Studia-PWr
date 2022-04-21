/**
 * Satisfied for GRASP(Expert):
 * Class with assigned commitment
 */
public class ClientsData {

     private final String name;
     private final String lastName;
     private final Components[] components;
     private final int Id;

     //constructor
    public ClientsData(String name, String lastName, Components[] components, int id) {
        this.name = name;
        this.lastName = lastName;
        this.components = components;
        Id = id;
    }

    /**
     *Method that is responsible for displaying invoice
     */
    public double getSumOfComponents() {
        System.out.println("Invoice buyer details: " + name + " " + lastName + " Id: " + Id);
        System.out.println("Component | Quantity | Netto value | Brutto value");
        double totalValue = getTotalValue();
        System.out.println("Total amount to be paid: " + totalValue);
       return totalValue;
    }

    private double getTotalValue() {
        double totalValue = 0.0;
        for(int i = 1; i <= components.length; i++) {
            double brutValue = components[i-1].getQuantity() * components[
                    i-1].getValue();
            double netValue = components[i-1].getQuantity() * components[i-1].getValue() / Constants.VAT;
            System.out.println(components[i-1].getComponentType() + " " + components[i-1].getQuantity() + " " + netValue + " " + brutValue);

            totalValue = totalValue + brutValue;
        }
        return totalValue;
    }

}
