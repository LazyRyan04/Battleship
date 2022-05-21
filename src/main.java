import board.*;
import boardObject.*;
import coordinates.*;
import java.util.Scanner;
import game.*;
import ship.*;
import ship.ShipFactory.ShipTypes;
import java.lang.NumberFormatException;

public class main
{
  public static void main(String[] args)
  {
    System.out.println("WE LIKE IVAN");
    
    boolean isGameOver = false;
    int shipsOnBoard = 5;
    String numberInputs; 
    String letterInput;
    int num = 0;
    
    
    System.out.println("WE LIKE IVAN!!");
    
    Scanner userInput = new Scanner(System.in); // Create a Scanner object

    boolean setSize = false;

    while(!setSize)
    {
      System.out.print("Please print the size of your board (Standard is 10X10): ");      
      numberInputs = userInput.nextLine();
      try
      {
        Integer.valueOf(numberInputs);
      }
      catch(NumberFormatException e)
      {
        setSize = false;
      }
      num = Integer.valueOf(numberInputs);
      setSize = true;
    }
    

    
    GameController control = GameController.init(num);
    
    
    ShipTypes type = null;
    String x;
    String y;
    int coordX = 0;
    int coordY = 0;
    RotationDirection rotate = null;
    boolean exitLoop1 = false;
    boolean exitLoop2 = false;
    boolean coordXValid = false;
    boolean coordYValid = false;


    public ShipType promptShipTypes()
    { 
      System.out.print("Input Ship type (First character of the ship please): ");
      letterInput = userInput.nextLine();

      while(!exitLoop1)
      {
        switch(letterInput)
        {
          case "a":
          case "A":
            exitLoop1 = true;
            return ShipTypes.CARRIER;
            break;
  
          case "b":
          case "B":
            exitLoop1 = true;
            return ShipTypes.BATTLESHIP;
            break;
  
          case "s":
          case "S": 
            exitLoop1 = true;
            return ShipTypes.SUBMARINE;
            break;
  
          case "c":
          case "C":  
            exitLoop1 = true;
            return ShipTypes.CARRIER;
            break;
  
          case "d":
          case "D":
            exitLoop1 = true;
            return ShipTypes.DESTROYER;
            break;
  
          default:
            System.out.print("Try again, First char of Ship: ");
            letterInput = userInput.nextLine();
            break;
        }
      }
    }

    public RotationDirection promptRotationDirection()
    {
      System.out.print("Rotate ship? (y/n): "); //WE DON'T HAVE CW ROTATION YET :(
      letterInput = userInput.nextLine();

      while(!exitLoop2)
      {
        switch(letterInput)
        {
          case "y":
            exitLoop2 = true;
            return RotationDirection.CCW;
  
          case "n":
            exitLoop2 = true;
            return RotationDirection.NO;
  
          default:
            System.out.print("Try again, Rotate Ship: ");
            letterInput = userInput.nextLine();
            break;          
        }  
      }
    }

    public int promptCoordX()
    {
      while(!coordXValid)
      {
        System.out.print("Input coordX of ship starting position: ");
        numberInputs = userInput.nextLine();
        try
        {
          Integer.valueOf(numberInputs);
        }
        catch(NumberFormatException e)
        {
           coordXValid = false;    
        } 
        coordXValid = true;
        coordX = Integer.valueOf(numberInputs);
      }
    }

    public int promptCoordY()
    {
      while(!coordYValid)
      {
        System.out.print("Input coordY of ship starting position: ");
        numberInputs = userInput.nextLine();
        try
        {
          Integer.valueOf(numberInputs);
        }
        catch(NumberFormatException e)
        {
           coordXValid = false;    
        }
        coordYValid = true;
        return coordY = Integer.valueOf(numberInputs);
      }
    }
    
    int i1 = 0;
    while(i1 < 5)
    {
      type = this.promptShipTypes();
      rotate = this.promptRotationDirection();
      coordX = this.promptCoordX();
      coordY = this.promptCoordY();  
      
      if(control.player1PutShip(type, coordX, coordY, rotate))
      {
        control.player1PutShip(type, coordX, coordY, rotate);
        ++i1;
      }

      else
      {
        System.out.println("Something went wrong, please try again.");
      }
      break;
    }
    
  }
}
