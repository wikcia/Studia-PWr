public class Rhombus extends Quadrangle {

    double edge, angle, radians;

    public Rhombus(double edge, double angle) {
        this.edge = edge;
        this.angle = angle;
        radians = Math.toRadians(angle);
    }

    @Override
    public double area() {
        return (Math.pow(edge, 2) * Math.sin(radians));
    }

    @Override
    public double circuit() {
        return 4 * edge;
    }
}
