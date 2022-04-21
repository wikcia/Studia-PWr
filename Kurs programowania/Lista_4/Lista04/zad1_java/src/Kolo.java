public class Kolo extends Figura  {
    private final int promien;
    public Kolo (int promien) throws MojWyjatek{
        if(promien < 0) throw new MojWyjatek();
        this.promien = promien;
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * promien * promien;
    }
}