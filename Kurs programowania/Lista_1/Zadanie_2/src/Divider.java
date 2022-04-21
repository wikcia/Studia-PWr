
public class Divider {

    public static int div(int n){
        for (int i = n/2; i > 0; i--) {
            if (n % i == 0)
                return i;
        }
        return 1;
    }

    public static void main(String args[]){
            int x;
            for (int i = 0; i < args.length; i++){
                try {
                    x = Integer.parseInt(args[i]);
                    if( x > 0) {
                        System.out.println(args[i] + ": " + div(x));
                    }else{
                        System.out.println("Given number is not a positive natural number.");
                    }

                } catch(NumberFormatException e){
                    System.out.println("Given number is not an integer.");
                }
            }
    }
}
