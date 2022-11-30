public class Fly{

  //instance variables
  private double mass;
  private double speed;


  //static constant/variables
  private static final double defMass = 5;
  private static final double defSpeed = 10;

  //constructor
  public Fly(double initMass, double initSpeed){
    if (initMass<0 || initSpeed<0){
      return;
    }
    mass = initMass;
    speed = initSpeed;
  }

  public Fly(double initMass){
    this(initMass, defSpeed);
  }

  public Fly(){
    this(defMass, defSpeed);
  }

  //methods
  //getter
  public double getMass(){
    return mass;
  }

  public double getSpeed(){
    return speed;
  }
  //setter
  public void setMass(double newMass){
    if (newMass>=0){
      mass = newMass;
    }
  }

  public void setSpeed(double newSpeed){
    if (newSpeed>0){
      speed = newSpeed;
    }
  }
  //toString
  public String toString(){
    if (mass <= 0){
      return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", speed);
    }
    else{
      return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", speed, mass);
    }

  }

  //grow
  public void grow(int growth){
    if (growth<0){
      return;
    }
    for (int i=0; i<growth; i++){
      mass = mass+1;
      if (mass <= 20){
        speed = speed+1;
      }
      else{
        speed = speed-0.5;
      }
    }
  }

  //isDead
  public boolean isDead(){
    if (mass == 0){
      return true;
    }
    else{
      return false;
    }
  }

  //main

  public static void main(String[] args) {
    //Fly tester = new Fly(0,10);
    //System.out.println(tester.toString());
    //tester.grow(2);
    // System.out.println(tester.toString());
    // System.out.println(tester.isDead());

  }


}
