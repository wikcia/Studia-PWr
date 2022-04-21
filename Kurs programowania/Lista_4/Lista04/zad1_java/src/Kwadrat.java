public class Kwadrat extends Czworokat {
    private final int bok;
    public Kwadrat (int bok) throws MojWyjatek{
        if(bok < 0) throw new MojWyjatek();
        this.bok = bok;

    }

    @Override
    public double obliczObwod() {
        return 4*bok;
    }

    @Override
    public double obliczPole() {
        return bok * bok;
    }
}
