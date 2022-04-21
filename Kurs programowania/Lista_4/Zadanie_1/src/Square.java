public class Square extends Quadrangle{

    double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return Math.pow(edge, 2);
    }

    @Override
    public double circuit() {
        return 4 * edge;
    }
}
