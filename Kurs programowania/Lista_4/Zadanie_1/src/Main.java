import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DeclarationOfTheMethods[] FirstArgumentMain = new DeclarationOfTheMethods[args[0].length()];
        int counter = 1;
        double parameter;

        for (int i = 0; i < args[0].length(); i++) {
            char result = args[0].charAt(i);

            switch (result) {
                case 'o':
                    try {
                        parameter = Double.parseDouble(args[counter]);
                        if(parameter > 0) {
                            Circle circle = new Circle(parameter);
                            FirstArgumentMain[i] = circle;
                            counter++;
                            break;
                        }
                        else{
                            System.out.println(args[counter] + " cannot be a radius");
                            counter++;
                            FirstArgumentMain[i] = null;
                        }
                    } catch(NumberFormatException exception){
                        System.out.println(args[counter] + " nie jest liczba");
                    }
                case 'c':   //w tym switchu wszystkie czworokaty
                    double[] edges = new double[4];
                    int j;
                    try {
                        for (j = 0; j < 4; j++) {
                            edges[j] = Double.parseDouble(args[counter + j]);
                            if(edges[j] < 0.0){
                                break;
                            }
                        }
                        Arrays.sort(edges); //sortujemy tablice bokow rosnaco
                        double kat;
                        kat = Double.parseDouble(args[counter + 4]);
                        if (kat > 0 && kat < 180) {

                            if ((edges[0] == edges[1]) && (edges[1] == edges[2]) && (edges[2] == edges[3])) {
                                if (kat == 90) {
                                    Square square = new Square(edges[0]);
                                    FirstArgumentMain[i] = square;
                                } else {
                                    Rhombus rhombus = new Rhombus(edges[0], kat);
                                    FirstArgumentMain[i] = rhombus;
                                }
                            } else if ((edges[0] == edges[1]) && (edges[2] == edges[3])) {
                                Rectangle rectangle = new Rectangle(edges[0], edges[2]);
                                FirstArgumentMain[i] = rectangle;
                            }
                        } else {
                            System.out.println("Inappropriate angle!");
                        }

                    } catch(NumberFormatException exception){
                        System.out.println(args[counter] + " cannot be a number");
                    }
                    counter = counter + 5; //sytuacja gdy nie zostanie spelniony zaden warunek w try
                    break;                 //wtedy pomijamy argumenty dla danej figury i przechodzimy do nastepnej
                case 'p':
                    try {
                        parameter = Double.parseDouble(args[counter]);
                        if(parameter > 0) {
                            Pentagon pentagon = new Pentagon(parameter);
                            FirstArgumentMain[i] = pentagon;
                            counter++;
                            break;
                        }
                        else{
                            System.out.println(args[counter] + " cannot be an edge");
                            counter++;
                            FirstArgumentMain[i] = null;
                        }
                    } catch(NumberFormatException exception){
                        System.out.println(args[counter] + " is not a number");
                    }
                case 's':
                    try {
                        parameter = Double.parseDouble(args[counter]);
                        if(parameter > 0) {
                            Hexagon hexagon = new Hexagon(parameter);
                            FirstArgumentMain[i] = hexagon;
                            counter++;
                            break;
                        }
                        else{
                            System.out.println(args[counter] + " cannot be an edge");
                            counter++;
                            FirstArgumentMain[i] = null;
                        }
                    } catch(NumberFormatException exception){
                        System.out.println(args[counter] + " is not a number");
                    }
                default:
                    System.out.println("Inappropriate sign");
            }
        }
        for (DeclarationOfTheMethods declarationOfTheMethods : FirstArgumentMain) {
            if (declarationOfTheMethods != null) {
                System.out.println("Area: " + declarationOfTheMethods.area());
                System.out.println("Circuit: " + declarationOfTheMethods.circuit());
            }
        }
    }
}