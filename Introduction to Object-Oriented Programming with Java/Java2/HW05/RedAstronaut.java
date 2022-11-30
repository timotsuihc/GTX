import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
  private String skill;

  public RedAstronaut(String name, int susLevel, String skill){
    super(name, susLevel);
    this.skill=skill.toLowerCase();
  }

  public RedAstronaut(String name){
    super(name, 15);
    this.skill = "experienced";
  }


  public void emergencyMeeting(){

    Arrays.sort(super.getPlayers());
    if (this.isFrozen() == true){
      return;
    }
    else if(super.getPlayers()[(super.getPlayers().length)-1].getName() == this.getName()){
      return;
    }

    for (int i=super.getPlayers().length-1; i>=0; i--){
      if(super.getPlayers()[i].isFrozen()==false){
        for (int j=i-1; j>=0; j--){
          if(super.getPlayers()[j].isFrozen()==false){
            if (super.getPlayers()[i].getSusLevel() != super.getPlayers()[j].getSusLevel()){
              super.getPlayers()[i].setFrozen(true);
              super.gameOver();
              return;
            }
            else{
              return;
            }
          }
        }
      }
    }


  }

  public void freeze(Player p){
    if(p instanceof Impostor || this.isFrozen() == true || p.isFrozen() == true){
    }
    else if(this.getSusLevel() < p.getSusLevel()){
      p.setFrozen(true);
    }
    else if(this.getSusLevel() > p.getSusLevel()){
      this.setSusLevel(this.getSusLevel() * 2);
    }
    super.gameOver();
  }

  public void sabotage(Player p){
    if(p instanceof Impostor || this.isFrozen() == true || p.isFrozen() == true){
    }
    else if(this.getSusLevel() < 20){
      p.setSusLevel((int)(p.getSusLevel() * 1.5));
    }
    else{
      p.setSusLevel((int)(p.getSusLevel() * 1.25));
    }
  }

  public boolean equals(Object o){
    if (o instanceof RedAstronaut){
      RedAstronaut x = (RedAstronaut) o;
      if (super.equals(x) && this.skill.equals(x.getSkill())){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      return false;
    }


  }

  public String toString(){
    String x = new String(super.toString() + " I am an "+ this.skill + " player!");
    if (this.getSusLevel() > 15){
      return x.toUpperCase();
    }
    else{
      return x;
    }
  }

  public String getSkill(){
    return this.skill;
  }


}
