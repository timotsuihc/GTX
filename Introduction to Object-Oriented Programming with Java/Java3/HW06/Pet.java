public abstract class Pet{

  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel){
    if(health > 1.0){
      this.health = 1.0;
    }
    else if(health < 0.0){
      this.health = 0.0;
    }
    else{
      this.health = health;
    }

    if(painLevel > 10){
      this.painLevel = 10;
    }
    else if(painLevel < 1){
      this.painLevel = 1;
    }
    else{
      this.painLevel = painLevel;
    }

    this.name = name;
  }

  public String getName(){
    return name;
  }

  public double getHealth(){
    return health;
  }

  public int getPainLevel(){
    return painLevel;
  }

  public abstract int treat();

  public void speak(){
    String str = "Hello! My name is " + name;
    if(painLevel > 5){
      System.out.print(str.toUpperCase() + " ");
    }
    else{
      System.out.print(str + " ");
    }

  }

  public boolean equals(Object o){
    if(o instanceof Pet){
      Pet x = (Pet)o;
      if((x.name).equals(name)){
        return true;
      }
      return false;
    }
    else{
      return false;
    }
  }

  protected void heal(){
    health = 1.0;
    painLevel = 1;
  }


}
