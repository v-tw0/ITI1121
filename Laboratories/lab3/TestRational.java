public class TestRational{
  
  public static void main(String[] args){
    
    Rational a = new Rational(2,3);
    Rational b = new Rational(1,3);
    Rational c = new Rational(3);
    
    System.out.println("A: " + a);
    System.out.println("B: " + b);
    System.out.println("C: " + c);
    System.out.println("A equals B?: " + a.equals(b));
    System.out.println("A+B: " + a.plus(b));
    
    //System.out.println(a.gcd(25,5)); //wont work when it is private
    //System.out.println("numerator" + Rational.getNumerator()); // wont work since it is not static 
  }
}