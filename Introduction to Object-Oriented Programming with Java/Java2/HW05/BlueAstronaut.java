import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{

  private int numTasks;
  private int taskSpeed;

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public BlueAstronaut(String name){
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }

  public void emergencyMeeting(){
    Arrays.sort(super.getPlayers());
    if (this.isFrozen() == true){
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
  public void completeTask(){
    if (this.isFrozen() == true){
    }
    else if(this.numTasks == 0){
      return;
    }
    else if (this.taskSpeed > 20){
      numTasks = numTasks - 2;
    }
    else{
      numTasks--;
    }
    if (numTasks <= 0){
      numTasks = 0;
      System.out.println("I have completed all my tasks");
      this.setSusLevel((int)(Math.floor(this.getSusLevel() * 0.5)));
    }

  }

  public boolean equals(Object o){
    if (o instanceof BlueAstronaut){
      BlueAstronaut x = (BlueAstronaut) o;
      if (super.equals(x) && this.numTasks == x.getnumTasks() && this.taskSpeed == x.getTaskSpeed()){
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
    String x = new String(super.toString() + " I have " + numTasks + " left over.");
    if (this.getSusLevel() > 15){
      return x.toUpperCase();
    }
    else{
      return x;
    }
  }

  public int getnumTasks(){
    return this.numTasks;
  }

  public int getTaskSpeed(){
    return this.taskSpeed;
  }

}
