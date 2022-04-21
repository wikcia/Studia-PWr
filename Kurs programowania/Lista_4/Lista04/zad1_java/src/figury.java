class MojWyjatek extends Exception{}

public class figury {

    public static void main(String[] args){

        if( args == null){
            System.exit(0);
        }

        String obiekty = args[0];
        Figura[] figury = new Figura[obiekty.length()];

        int j = 1;
        int nrFig = 0;
        int p = 0;
        for(int i = 0; i < obiekty.length(); i++) {
            char figura = obiekty.charAt(i);

            switch (figura) {
                case 'o' -> {
                    try {
                        figury[nrFig] = new Kolo(Integer.parseInt(args[j]));
                        nrFig++;
                    } catch (MojWyjatek | NumberFormatException e) {
                        System.out.println("Nie mozna utworzyc kola poniewaz podano zly parametr");
                    } catch(ArrayIndexOutOfBoundsException a){
                        System.out.println("Nie mozna utworzyc kola poniewaz nie podano parametru");
                    }
                    j++;
                }
                case 'c' -> {
                    int[] dane = new int[5];
                    int h = j;
                    try {
                        for (int k = 0; k <= 4; k++) {
                            dane[k] = Integer.parseInt(args[h]);
                            h++;
                        }

                        if (dane[0] == dane[1] && dane[0] == dane[2] && dane[0] == dane[3]) {
                            if (dane[4] == 90) {
                                figury[nrFig] = new Kwadrat(dane[0]);
                                nrFig++;
                            } else if (dane[4] > 90 && dane[4] < 180) {
                                figury[nrFig] = new Romb(dane[0], 180 - dane[4]);
                                nrFig++;
                            } else {
                                figury[nrFig] = new Romb(dane[0], dane[4]);
                                nrFig++;
                            }
                        } else if (((dane[0] == dane[1] && dane[2] == dane[3]) || (dane[0] == dane[2] && dane[1] == dane[3]) ||
                                (dane[0] == dane[3] && dane[1] == dane[2])) && dane[4] == 90) {
                            figury[nrFig] = new Prostokat(dane[0], dane[1], dane[2], dane[3]);
                            nrFig++;
                        }

                    } catch(ArrayIndexOutOfBoundsException ex) {
                        System.out.println("Nie mozna utworzyc czworokata poniewaz zostala podana zbyt mala ilosc parametrow");
                    } catch (MojWyjatek | NumberFormatException e) {
                        System.out.println("Nie mozna utworzyc czworokata poniewaz podano zly parametr");
                    }
                    j = j + 5;
                }
                case 'p' -> {
                    try {
                        figury[nrFig] = new Pieciokat(Integer.parseInt(args[j]));
                        nrFig++;
                    } catch (MojWyjatek | NumberFormatException e) {
                        System.out.println("Nie mozna utworzyc pieciokata poniewaz podano zly parametr");
                    } catch (ArrayIndexOutOfBoundsException a){
                        System.out.println("Nie mozna utworzyc pieciokata poniewaz nie podano parametru");
                    }
                    j++;
                }
                case 's' -> {
                    try {
                        figury[nrFig] = new Szesciokat(Integer.parseInt(args[j]));
                        nrFig++;
                    } catch (MojWyjatek | NumberFormatException e) {
                        System.out.println("Nie mozna utworzyc szesciokata poniewaz podano zly parametr");
                    }catch(ArrayIndexOutOfBoundsException a){
                        System.out.println("Nie mozna utworzyc szesciokata poniewaz nie podano parametru");
                    }
                    j++;
                }
                default ->
                    System.out.println("Nie mozna utworzyc figury o znaku: " + obiekty.charAt(i));
            }
        }

        for (int m = 0; m < nrFig; m++) {
            System.out.println(figury[m].getClass().getName() + ": obwod = " + figury[m].obliczObwod() + ", pole = " + figury[m].obliczPole());
        }
    }
}
