public class Cat extends Pet{
  int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught){
    super(name, health, painLevel);
    if(miceCaught < 0){
      this.miceCaught = 0;
    }
    else{
      this.miceCaught = miceCaught;
    }
  }

  public Cat(String name, double health, int painLevel){
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught(){
    return miceCaught;
  }



  @Override
  public int treat(){

    if(miceCaught < 4){
      int timeHeal = (int)Math.ceil(getPainLevel()*2/getHealth());
      heal();
      return timeHeal;
    }
    if(miceCaught >= 4 && miceCaught <= 7){
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
    for(int i=0; i<getPainLevel(); i++){
        if(getPainLevel()<=5){
          System.out.print("meow ");
        }
        else{
          System.out.print("MEOW ");
        }
    }
    System.out.print("\n");
  }

  @Override
  public boolean equals(Object o){
    if(o instanceof Cat){
      Cat x = (Cat)o;
      if(super.equals(o) && x.miceCaught == miceCaught){
        return true;
      }
      return false;
    }
    else{
      return false;
    }
  }

}
