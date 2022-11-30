public class Dog extends Pet{
  private double droolRate;
  public Dog(String name, double health, int painLevel, double droolRate){
    super(name, health, painLevel);
    if(droolRate <= 0){
      this.droolRate = 0.5;
    }
    else{
      this.droolRate = droolRate;
    }
  }
  public Dog(String name, double health, int painLevel){
    this(name, health, painLevel, 5);
  }

  public double getDroolRate(){
    return droolRate;
  }


  @Override
  public int treat(){

    if(droolRate < 3.5){
      int timeHeal = (int)Math.ceil(getPainLevel()*2/getHealth());
      heal();
      return timeHeal;
    }
    else if(droolRate >= 3.5 && droolRate <= 7.5){
      int timeHeal = (int)Math.ceil(getPainLevel()/getHealth());
      heal();
      return timeHeal;
    }
    else{
      int timeHeal = (int)Math.ceil(getPainLevel()/(getHealth()*2));
      heal();
      return timeHeal;
    }
  }

  @Override
  public void speak(){
    super.speak();
    for(int i = 0; i < getPainLevel(); i++){
      if(getPainLevel() <= 5){
        System.out.print("bark ");
      }
      else{
        System.out.print("BARK ");
      }
    }
    System.out.print("\n");
  }

  @Override
  public boolean equals(Object o){
    if(o instanceof Dog){
      Dog x = (Dog)o;
      if(super.equals(x) && x.droolRate == droolRate){
        return true;
      }
      return false;
    }
    else{
      return false;
    }
  }

}
