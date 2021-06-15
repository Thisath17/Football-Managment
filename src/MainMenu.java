import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args){
        PremierLeagueManager PM = new PremierLeagueManager();
        boolean exit = false;

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n===================================");
            System.out.println("Premier League menu: ");
            System.out.println("Press 1 to create a club");
            System.out.println("Press 2 to remove a club");
            System.out.println("Press 3 to review club statics");
            System.out.println("Press 4 to display point table");
            System.out.println("Press 5 to add a club match");
            System.out.println("Press 6 to save Inputs");
            System.out.println("Press 7 to load data");
            System.out.println("Press 0 to exit");
            System.out.println("===================================");
            System.out.print("Enter your answer: ");
            int answer = scan.nextInt();

            switch (answer) {
                case 1:
                    PM.createClub();
                    break;
                case 2:
                    PM.removeClub();
                    break;
                case 3:
                    PM.displayStatics();
                    break;
                case 4:
                    PM.displayTable();
                    break;
                case 5:
                    PM.addMatch();
                    break;
                case 6:
                    PM.saveInputs();
                    break;
                case 7:
                    PM.loadData();
                    break;
                case 0:
                    PM.exit();
                    break;
                default:
                    System.out.println("\nInvalid answer,Please try again....");
                    break;
            }
        }

    }
}