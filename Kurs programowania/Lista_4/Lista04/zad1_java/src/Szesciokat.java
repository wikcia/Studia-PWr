public class Szesciokat extends Figura {
    private final int bok;
    public Szesciokat(int bok) throws MojWyjatek {
        if( bok < 0 ) throw new MojWyjatek();
        this.bok = bok;
    }

    @Override
    public double obliczObwod() {
        return 6*bok;
    }

    @Override
    public double obliczPole() {
        return (3 * Math.sqrt(3) * bok * bok) / 2;
    }
}
