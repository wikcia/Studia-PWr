public class Rectangle extends Quadrangle{

    double edge1, edge2;

    public Rectangle(double edge1, double edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    @Override
    public double area() {
        return edge1*edge2;
    }

    @Override
    public double circuit() {
        return 2*edge1 + 2*edge2;
    }
}
