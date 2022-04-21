public class PascalTriangleRowTest {

        public static void main(String[] args){
            int n,k;
            try{
                n = Integer.parseInt(args[0]);
                if (n < 0)
                    System.out.println(args[0] + " can't be a number od triangle's row");
                else{
                    PascalTriangleRow PascalTriangleRow = new PascalTriangleRow(n);
                    for (int i = 1; i < args.length; i++) {
                        try {
                            k = Integer.parseInt(args[i]);
                            if(k > n) { System.out.println("outside the range of an array"); }
                            else
                                System.out.println(args[i] + "->" + PascalTriangleRow.index(k));

                        } catch (NumberFormatException ex) {
                            System.out.println(args[i] + " is not a number");
                        } catch (MyException ex) {
                            System.out.println(args[i] + " can't be a number od triangle's row");
                        }
                    }
                }
            }
            catch(NumberFormatException ex){
                System.out.println(args[0] + " nie jest liczbą");
            }
        }
    }

