public class Components {

    private final ComponentType componentType;
    private final double value;
    private final int quantity;

    public Components(ComponentType componentType, double value, int quantity) {
        this.componentType = componentType;
        this.value = value;
        this.quantity = quantity;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }
}
