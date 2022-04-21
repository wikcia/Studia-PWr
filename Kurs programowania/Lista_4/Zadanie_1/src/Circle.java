public class Circle extends Figure {

        double radius;
        double power;

        Circle(double radius){
            this.radius = radius;
            power = Math.pow(radius, 2);
        }

        @Override
        public double area() {
            return Math.PI*power;
        }

        @Override
        public double circuit() {
            return 2*Math.PI* radius;
        }
}
