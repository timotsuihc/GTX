public class Gameplay{

  public static void printAll(){
    System.out.println();
    for (int i = 0; i < Player.getPlayers().length; i++){
      System.out.println(Player.getPlayers()[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);
    RedAstronaut Liam = new RedAstronaut("liam", 19, "experienced");
    RedAstronaut Sus = new RedAstronaut("Suspicious Person", 100, "expert");


    Liam.sabotage(Bob);
    Liam.freeze(Sus);
    Liam.freeze(Albert);
    Albert.emergencyMeeting();


    Sus.emergencyMeeting();



    Bob.emergencyMeeting();
    System.out.println(Heath);
    Heath.completeTask();
    System.out.println(Heath);
    Heath.completeTask();
    System.out.println(Heath);
    Heath.completeTask();
    System.out.println(Heath);
    Liam.freeze(Angel);
    Liam.sabotage(Bob);
    Liam.sabotage(Bob);
    Liam.freeze(Bob);
    ////1
    //Angel.emergencyMeeting();

    //2
    for(int i=0; i<5; i++){
      Liam.sabotage(Heath);
      System.out.println(Heath);
    }
    Liam.freeze(Heath);



  }
}
