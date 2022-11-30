public class Frog{

  //instance variables
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;

  //static constant/variables
  private static String species = "Rare Pepe";
  private static final int defAge = 5;
  private static final double defTongueSpeed = 5;

  //constructor
  public Frog(String initName, int initAge, double initTongueSpeed){
    if(initAge<0 || initTongueSpeed<0){
      return;
    }
    name = initName;
    age = initAge;
    tongueSpeed = initTongueSpeed;
    //isFroglet
    if (age>1 && age<7){
      isFroglet = true;
    }
    else{
      isFroglet = false;
    }
  }

  public Frog(String initName, double initAgeInYears, double initTongueSpeed){
    this(initName, (int)(initAgeInYears * 12), initTongueSpeed);
  }

  public Frog(String initName){
    this(initName, defAge, defTongueSpeed);
  }

  //methods

  public void grow(int growth){
    if (growth<0){
      return;
    }
    for(int i=0; i<growth; i++){

      age++;

      if (age<=12){
        tongueSpeed = tongueSpeed+1;
      }
      if (tongueSpeed > 5){
        if (age>30){
          tongueSpeed = tongueSpeed-1;
        }
      }


      //isFroglet
      if (age>1 && age<7){
        isFroglet = true;
      }
      else{
        isFroglet = false;
      }

    }
  }

  public void grow(){
    grow(1);
  }

  public void eat(Fly fly){
    if (fly.isDead()){
      return;
    }
    if ((fly.getSpeed() < tongueSpeed) && (fly.getMass()>0.5*age)){
      grow(1);
      fly.setMass(0);
    }
    else{
      fly.grow(1);
    }
  }

  //toString
  public String toString(){
    if (isFroglet){
      return  String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }
    else{
      return  String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }
  }

  //setter/getter
  public String getSpecies(){
    return species;
  }

  public void setSpecies(String newSpecies){
    species = newSpecies;
  }

  //main

  public static void main(String[] args) {
    Frog tester = new Frog("iAmTester", 25, 30);
    System.out.println(tester.toString());
    tester.grow(10);
    System.out.println(tester.toString());

    Frog tester2 = new Frog("iAmTester2", 5, 5);
    System.out.println(tester2.toString());
    tester2.grow(8);
    System.out.println(tester2.toString());

    //tester.grow(10);
    //System.out.println(tester.toString());
  }


}
