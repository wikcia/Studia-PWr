public class Romb extends Czworokat {
    private final int bok, kat;
    public Romb( int bok, int kat) throws MojWyjatek{
        if( bok < 0 || kat < 0 ) throw new MojWyjatek();
        this.bok = bok;
        this.kat = kat;
    }

    @Override
    public double obliczObwod() {
        return 4*bok;
    }

    @Override
    public double obliczPole() {
        return bok * bok * Math.sin(Math.toRadians(kat));
    }
}
