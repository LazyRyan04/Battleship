import coordinates.Point;
import coordinates.RotationDirection;
import game.GameController;
import ship.ShipFactory.ShipTypes;

import java.util.Scanner;


public class main {
    public static ShipTypes promptShipTypes(Scanner userInput) {

        System.out.print("Input Ship type (First character of the ship please): ");
        String letterInput = userInput.nextLine();

        switch (letterInput) {
            case "a":
            case "A":
                return ShipTypes.CARRIER;

            case "b":
            case "B":
                return ShipTypes.BATTLESHIP;

            case "s":
            case "S":
                return ShipTypes.SUBMARINE;

            case "c":
            case "C":
                return ShipTypes.CRUISER;

            case "d":
            case "D":
                return ShipTypes.DESTROYER;
        }
        return null;
    }

    public static RotationDirection promptRotationDirection(Scanner userInput) {
        System.out.print("Rotate ship? (y/n): "); //WE DON'T HAVE CW ROTATION YET :(
        String letterInput = userInput.nextLine();

        switch (letterInput) {
            case "y":
                return RotationDirection.CCW;

            case "n":
                return RotationDirection.NO;
        }
        return null;
    }

    public static int promptCoordX(Scanner userInput) {
        System.out.print("Input coordX: ");
        String numberInputs = userInput.nextLine();
        return Integer.parseInt(numberInputs);

    }

    public static int promptCoordY(Scanner userInput) {
        System.out.print("Input coordY: ");
        String numberInputs = userInput.nextLine();
        return Integer.parseInt(numberInputs);
    }

    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        GameController control = GameController.init(10);

        System.out.println("Player 1 put ships down!");
        System.out.println(control.p1SeeOBoard());
        for(int i = 0; i < 5; i++)
        {
            ShipTypes shipType = promptShipTypes(userInput);
            RotationDirection rotDir = promptRotationDirection(userInput);
            int coordX = promptCoordX(userInput);
            int coordY = promptCoordY(userInput);

            control.player1PutShip(shipType, coordX, coordY, rotDir);
            System.out.println(control.p1SeeOBoard());
        }
        clearScreen();
        System.out.println("Player 2 put ships down!");
        System.out.println(control.p2SeeOBoard());
        for(int i = 0; i < 1; i++) {
            ShipTypes shipType = promptShipTypes(userInput);
            RotationDirection rotDir = promptRotationDirection(userInput);
            int coordX = promptCoordX(userInput);
            int coordY = promptCoordY(userInput);

            control.player2PutShip(shipType, coordX, coordY, rotDir);
            System.out.println(control.p2SeeOBoard());
        }
        clearScreen();
        while(true)
        {
            System.out.println("Player 1 Attack");
            System.out.println(control.p1SeeRBoard());
            System.out.println(control.p1SeeOBoard());
            Point setPoint = new Point(promptCoordX(userInput), promptCoordY(userInput));
            control.player1Attack(setPoint);
            System.out.println(control.p1SeeRBoard());
            int win = control.won(5);
            if(win == 1)
            {
                System.out.println("Player 1 won!");
                System.exit(0);
            }
            userInput.nextLine();
            clearScreen();
          
            System.out.println("Player 2 Attack");
            System.out.println(control.p2SeeRBoard());
            System.out.println(control.p2SeeOBoard());
            setPoint = new Point(promptCoordX(userInput), promptCoordY(userInput));
            control.player2Attack(setPoint);
            System.out.println(control.p2SeeRBoard());           
            win = control.won(5);
            if(win == -1)
            {
                System.out.println("Player 2 won!");
                System.exit(0);
            }
            userInput.nextLine();
            clearScreen(); 



        }
    }

}
