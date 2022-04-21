public class Prostokat extends Czworokat {
    private final int bok1, bok2, bok3, bok4;
    public Prostokat(int bok1, int bok2, int bok3, int bok4) throws MojWyjatek{
        if( bok1 < 0 || bok2 <0 || bok3 < 0 || bok4 < 0) throw new MojWyjatek();
        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
        this.bok4 = bok4;
    }

    @Override
    public double obliczObwod() {
        return bok1 + bok2 + bok3 + bok4;
    }

    @Override
    public double obliczPole() {
        if( bok1 == bok2 || bok1 == bok4) {
            return bok1 * bok3;
        }
        else{
            return bok1 * bok2;
        }
    }
}
