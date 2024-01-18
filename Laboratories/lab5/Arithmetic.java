public class Arithmetic extends AbstractSeries {

    public int i = 1;
    public double count = 0;

    public double next() {
        count = count + i;
        i++;
        return count;
    }
}
