public class Pentagon extends Figure{
    double edge;

    Pentagon(double bok){
        this.edge = bok;
    }

    @Override
    public double area() {
        return (Math.pow(edge, edge) * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4);
    }

    @Override
    public double circuit() {
        return 5* edge;
    }
}
