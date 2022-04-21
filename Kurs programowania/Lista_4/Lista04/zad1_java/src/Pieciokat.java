public class Pieciokat extends Figura  {
    private final int bok;
    public Pieciokat(int bok) throws MojWyjatek {
        if( bok < 0 ) throw new MojWyjatek();
        this.bok = bok;
    }

    @Override
    public double obliczObwod() {
        return 5*bok;
    }

    @Override
    public double obliczPole() {
        return ((Math.sqrt(25 + 10 * Math.sqrt(5)))*bok*bok)/4;
    }

}
