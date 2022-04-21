public class Figure {

    public enum OneParameterFigure implements OneParameterFiguresMethods {
        CIRCLE("circle"),
        SQUARE("square"),
        PENTAGON("pentagon"),
        HEXAGON("hexagon");

        private final String name;
        OneParameterFigure(String name) {
            this.name = name;
        }

        @Override
        public double area(double edge, OneParameterFigure oneParameterFigure) {
            if(oneParameterFigure == CIRCLE){
                return Math.PI * edge * edge;
            }
            else if(oneParameterFigure == SQUARE){
                return edge*edge;
            }
            else if(oneParameterFigure == PENTAGON){
                return Math.pow(edge, edge) * Math.sqrt(25 + 10 * Math.sqrt(5)) / 4;
            }
            else if(oneParameterFigure == HEXAGON){
                return (3 * Math.pow(edge, 2) * Math.sqrt(3)) / 2;
            }
            return 0;
        }

        @Override
        public double circuit(double edge, OneParameterFigure oneParameterFigure) {
            if (oneParameterFigure == CIRCLE) {
                return 2 * Math.PI * edge;
            } else if (oneParameterFigure == SQUARE) {
                return 4 * edge;
            } else if (oneParameterFigure == PENTAGON) {
                return 5 * edge;
            } else if (oneParameterFigure == HEXAGON) {
                return 6 * edge;
            }
            return 0;
        }

    }
    public enum TwoParameterFigure implements TwoParameterFiguresMethods {
        RECTANGLE("rectangle"),
        RHOMBUS("rhombus");

        private final String name;

        TwoParameterFigure(String name) {
            this.name = name;
        }

        @Override
        public double area(double edge1, double edge2, TwoParameterFigure twoParameterFigure) {
            if(twoParameterFigure == RECTANGLE){
                return edge1*edge2;
            }
            else if(twoParameterFigure == RHOMBUS){
                return Math.pow(edge1, 2) * Math.sin(Math.toRadians(edge2));
            }
            return 0;
        }

        @Override
        public double circuit(double edge1, double edge2, TwoParameterFigure twoParameterFigure) {
            if(twoParameterFigure == RECTANGLE){
                return 2*edge1+2*edge2;
            }
            else if(twoParameterFigure == RHOMBUS){
                return 4*edge1;
            }
            return 0;
        }
    }
}
