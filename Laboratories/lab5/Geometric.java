public class Geometric extends AbstractSeries {

    public int i = 1;
    public double count = 0;
    public int count2 =0;
    
    public double next() {
        if(count2==0){ 
            count = count / Math.pow(2,i-1) + 1; 
            count2++; 
            i++; 
            return count;
        }
        else { 
            count += count2 / Math.pow(2,i-1); 
            i++; 
        }
        return count;
    }
}
