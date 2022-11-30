import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Clinic{
  private static File patientFile;
  private int day;



  public Clinic(File file){
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName){
    this(new File(fileName));
  }

  public String nextDay(String fileName) throws FileNotFoundException{
    File newFile = new File(fileName);
    return nextDay(newFile);
  }

  public String nextDay(File f) throws FileNotFoundException{
    Scanner fileScanner = new Scanner(f);
    Scanner userScanner = new Scanner(System.in);
    String line = null;
    String[] tokens = null;
    String returnLine = "";

    while (fileScanner.hasNextLine()){
      line = fileScanner.nextLine();
      tokens = line.split(",");
      String name = tokens[0];
      String typeOfPet = tokens[1];
      String timeIn = tokens[3];
      String timeOut;
      String extraString;
      double health = 0;
      int painLevel = 0;
      boolean isInt = false;
      Pet pet;

      if(!(typeOfPet.equals("Dog")) && !(typeOfPet.equals("Cat"))){
        throw new InvalidPetException();
      }
      System.out.println(String.format("Consultation for %s the %s at %s. \nWhat is the health of %s?", name, typeOfPet, timeIn, name));

      while(!isInt){
        try{
          health = userScanner.nextDouble();
          isInt = true;
        } catch(Exception e) {
          System.out.println("Please enter a number");
          userScanner.nextLine();
        }
      }
      isInt = false;

      System.out.println(String.format("On a scale of 1 to 10, how much pain is %s in right now?", name));

      while(!isInt){
        try{
          painLevel = userScanner.nextInt();
          isInt = true;
        } catch(Exception e) {
          System.out.println("Please enter a number");
          userScanner.nextLine();
        }
      }
      isInt = false;

      if(typeOfPet.equals("Dog")){
        Double extra = Double.parseDouble(tokens[2]);
        pet = new Dog(name, health, painLevel, extra);
        extraString = String.valueOf(extra);
      }
      else{
        int extra = Integer.valueOf(tokens[2]);
        pet = new Cat(name, health, painLevel, extra);
        extraString = String.valueOf(extra);
      }

      health = pet.getHealth();
      painLevel = pet.getPainLevel();

      pet.speak();
      timeOut = addTime(timeIn, pet.treat());
      returnLine = returnLine + name +","+ typeOfPet +","+ extraString +","+"Day "+ day +","+ timeIn +","+ timeOut +","+ health +","+ painLevel +"\n";

    }
    day++;
    fileScanner.close();
    userScanner.close();

    return returnLine;

  }

  public static boolean addToFile(String patientInfo){
    PrintWriter filePrinter = null;
    Scanner fileScanner = null;
    String rewriteFile = "";
    if(!(patientInfo.equals(""))){
      try{
        fileScanner = new Scanner(patientFile);
        String[] fileTokens;
        String fileLine;
        String fileName;
        String newPatientLine = "";

        String[] infoTokens = patientInfo.split(",");
        String infoName = infoTokens[0];

        boolean newPatient = true;

        if(!fileScanner.hasNextLine()){
          rewriteFile = patientInfo;
        }
        else{
          while (fileScanner.hasNextLine()) {
            fileLine = fileScanner.nextLine();
            fileTokens = fileLine.split(",");
            fileName = fileTokens[0];
            if(fileName.equals(infoName)){
              fileLine = fileLine +","+ infoTokens[3] +","+ infoTokens[4] +","+ infoTokens[5]  +","+ infoTokens[6] +","+ infoTokens[7];
              rewriteFile = rewriteFile + fileLine + "\n";
              newPatient = false;
            }
            else{
              rewriteFile = rewriteFile + fileLine + "\n";
              newPatientLine = patientInfo + "\n";
            }
          }
          if(newPatient == true){
            rewriteFile = rewriteFile + newPatientLine;
          }
        }
        //System.out.println(rewriteFile);

        filePrinter = new PrintWriter(patientFile);
        filePrinter.print(rewriteFile);

      } catch(FileNotFoundException e){
        System.out.println("file not found");
        return false;
      } finally{
        if(fileScanner != null){
          fileScanner.close();
          if(filePrinter != null){
            filePrinter.close();
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
    }
    else{
      return false;
    }
  }


  private static String addTime(String timeIn, int treatmentTime){
    String hour = timeIn.substring(0,2);
    String minute = timeIn.substring(2,4);
    int newMinute = Integer.valueOf(minute) + treatmentTime;
    int newHour = Integer.valueOf(hour) + (newMinute/60);
    newMinute = newMinute%60;
    return String.format("%02d", newHour) + String.valueOf(newMinute);
  }

  // public static void main(String[] args) throws FileNotFoundException{
  //   Clinic clinic = new Clinic("Patients.csv");
  //   clinic.addToFile("FUCKER,Cat,5,Day 1,1839,1848,1.0,9");
  //
  // }

}
