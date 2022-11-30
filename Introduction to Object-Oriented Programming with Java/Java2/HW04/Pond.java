public class Pond{
  //methods


  //main
  public static void main(String[] args){

    Frog frogPeepo = new Frog("Peepo");
    Frog frogPepe = new Frog("Pepe", 10, 15);
    Frog frogPeepaw = new Frog("Peepaw", 4.6, 5);
    Frog frogL = new Frog("L", 1, 1);

    Fly flyA = new Fly(1,3);
    Fly flyB = new Fly(6);
    Fly flyL = new Fly(10);

    frogL.setSpecies("1331 Frogs");
    System.out.println(frogPeepo.toString());
    frogPeepo.eat(flyB);
    System.out.println(flyB.toString());
    frogPeepo.grow(8);
    frogPeepo.eat(flyB);
    System.out.println(flyB.toString());
    System.out.println(frogPeepo.toString());
    System.out.println(frogL.toString());
    frogPeepaw.grow(4);
    System.out.println(frogPeepaw.toString());
    System.out.println(frogPepe.toString());

  }

}
