public class Hexagon extends Figure {

    double edge;

    public Hexagon(double edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return (3 * Math.pow(edge, 2) * Math.sqrt(3)) / 2;
    }

    @Override
    public double circuit() {
        return 6 * edge;
    }
}
