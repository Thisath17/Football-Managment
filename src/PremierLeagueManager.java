import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{
    
    // Creating the arraylists 
    static ArrayList<FootballClub> insertData= new ArrayList<>();
    static ArrayList<ArrayList<String>> insertData2= new ArrayList<>();

    // Methode for creating a new club
    @Override
    public void createClub() {
        System.out.println("-----------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter the name of the club: ");
        String clubName = scan.nextLine();
        System.out.print("Enter the club location: ");
        String clubLocation = scan.nextLine();
        System.out.print("Enter the number of club members: ");
        int numOfClubMembers = scan.nextInt();

        int wins=0,draws=0,defeats=0,numOfReceivedGoals=0,numOfScoredGoals=0,numOfPlayedMatches=0,currentClubPoints=0;
        
        insertData.add(new FootballClub(clubName,clubLocation,numOfClubMembers,wins,draws,defeats,numOfReceivedGoals,numOfScoredGoals,numOfPlayedMatches,currentClubPoints));

        System.out.println(insertData);
        System.out.println(clubName+" is successfully added to the system....");
        System.out.println("-----------------------------------------");
    }

    // Methode for the romoving a club
    @Override
    public void removeClub() {
        System.out.println("-----------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the need to remove club name: ");
        String removeClub = scan.nextLine();

        Iterator checkClubName = insertData.iterator();

        while (checkClubName.hasNext()){
            FootballClub sp = (FootballClub) checkClubName.next();

            if (removeClub.equals(sp.name)) {
                insertData.remove(sp);
                System.out.println(sp.name+" club is successfully removed...");
                System.out.println("-----------------------------------------");
            } else {
                System.out.println("There is no club found under this name....");
                System.out.println("-----------------------------------------");
            }
        }


    }

    // Methode for the review a team status
    @Override
    public void displayStatics() {
        System.out.println("-----------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the club name: ");
        String showStatictics = scan.nextLine();

        Iterator checkClubName = insertData.iterator();

        while (checkClubName.hasNext()){
            FootballClub data = (FootballClub) checkClubName.next();

            if (showStatictics.equals(data.name)){
                System.out.println("\nClub Name             : "+data.name);
                System.out.println("Club Location           : "+data.clubLocation);
                System.out.println("Number of Members       : "+data.numberOfMembers);
                System.out.println("Number of played matches: "+data.numOfPlayedMatches);
                System.out.println("Number of wins          : "+data.wins);
                System.out.println("Number of draws         : "+data.draws);
                System.out.println("Number of defeats       : "+data.defeats);
                System.out.println("Number of Received Goals: "+data.numOfReceivedGoals);
                System.out.println("Number of Scored Goals  : "+data.numOfScoredGoals);
                System.out.println("Club Points             : "+data.currentClubPoints);
                System.out.println("-----------------------------------------");
            }else{
                System.out.println("There is no club found under this name, Please try again...");
                System.out.println("-----------------------------------------");
            }
        }

    }

    // Methode for the table desplay
    @Override
    public void displayTable() {
        Collections.sort(insertData,FootballClub.comparatorMethod);
        System.out.println("Point Table : ");
        for (FootballClub fbc : insertData) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(fbc);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }

    }

    // Methode for the adding a new match
    @Override
    public void addMatch() {
        System.out.println("-----------------------------------------");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter date of the match (DD/MM/YYYY): ");
        String matchDate = scan.nextLine();
        System.out.print("Enter first team name: ");
        String firstTeam = scan.nextLine();
        FootballClub team1 = null;
        int id1 = 0;
        for (FootballClub fClubName: insertData){
            if(fClubName.getName().equals(firstTeam)){
                team1 = fClubName;
                break;
            }
            id1++;
        } if (team1==null){
            System.out.println(team1+" club is not registered for this premier league....");
            System.out.println("-----------------------------------------");
            return;
        }

        System.out.print("Enter second team name: ");
        String secondTeam = scan.nextLine();
        FootballClub team2 = null;
        int id2 = 0;
        for (FootballClub fClubName: insertData){
            if(fClubName.getName().equals(secondTeam)){
                team2 = fClubName;
                break;
            }
            id2++;
        }if (team2==null){
            System.out.println(team2+" club is not registered for this premier league....");
            System.out.println("-----------------------------------------");
            return;
        }

        System.out.print("Enter first team goals: ");
        int firstTeamGoals = scan.nextInt();

        System.out.print("Enter second team goals: ");
        int secondTeamGoals = scan.nextInt();

        // Creating the inner arraylist
        String intToString1 = String.valueOf(firstTeamGoals);
        String intToString2 = String.valueOf(secondTeamGoals);
        ArrayList<String> innerArrayList = new ArrayList<>();
        innerArrayList.add(firstTeam);
        innerArrayList.add(secondTeam);
        innerArrayList.add(intToString1);
        innerArrayList.add(intToString2);
        innerArrayList.add(matchDate);

        // Condision for that team 1 winning
        if (firstTeamGoals>secondTeamGoals){
            System.out.println("\n"+firstTeam+" team is the winner...");
            System.out.println(secondTeam+" team has loss this match...");
            innerArrayList.add(firstTeam);

            // Win team status adding to the first array
            insertData.get(id1).setWins(team1.getWins()+1);
            insertData.get(id1).setNumOfScoredGoals(team1.getNumOfScoredGoals()+firstTeamGoals);
            insertData.get(id1).setNumOfReceivedGoals(team1.getNumOfReceivedGoals()+secondTeamGoals);
            insertData.get(id1).setCurrentClubPoints(team1.getCurrentClubPoints()+3);
            insertData.get(id1).setNumOfPlayedMatches(team1.getNumOfPlayedMatches()+1);

            // Defeat team status adding to the first array
            insertData.get(id2).setDefeats(team2.getDefeats()+1);
            insertData.get(id2).setNumOfScoredGoals(team2.getNumOfScoredGoals()+secondTeamGoals);
            insertData.get(id2).setNumOfReceivedGoals(team2.getNumOfReceivedGoals()+firstTeamGoals);
            insertData.get(id2).setNumOfPlayedMatches(team2.getNumOfPlayedMatches()+1);

            System.out.println("\nFootballClub{" +
                    " name='" + team1.name +'\''+
                    ", clubLocation='" + team1.clubLocation +'\''+
                    ", numberOfMembers=" + team1.numberOfMembers +
                    ", numOfPlayedMatches=" + team1.numOfPlayedMatches +
                    ", wins=" + team1.wins +
                    ", draws=" + team1.draws +
                    ", defeats=" + team1.defeats +
                    ", numOfReceivedGoals=" + team1.numOfReceivedGoals +
                    ", numOfScoredGoals=" + team1.numOfScoredGoals +
                    ", currentClubPoints=" + team1.currentClubPoints +
                    '}'+'\n');

            System.out.println("\nFootballClub{" +
                    " name='" + team2.name +'\''+
                    ", clubLocation='" + team2.clubLocation +'\''+
                    ", numberOfMembers=" + team2.numberOfMembers +
                    ", numOfPlayedMatches=" + team2.numOfPlayedMatches +
                    ", wins=" + team2.wins +
                    ", draws=" + team2.draws +
                    ", defeats=" + team2.defeats +
                    ", numOfScoredGoals=" + team2.numOfScoredGoals +
                    ", numOfReceivedGoals=" + team2.numOfReceivedGoals +
                    ", currentClubPoints=" + team2.currentClubPoints +
                    '}'+'\n');

        } 
        // Condision for that two teams are drow
        else if (firstTeamGoals==secondTeamGoals){
            System.out.println("\n"+"This is a draw match...");
            innerArrayList.add("Draw");

            insertData.get(id1).setDraws(team1.getDraws()+1);
            insertData.get(id1).setNumOfScoredGoals(team1.getNumOfScoredGoals()+firstTeamGoals);
            insertData.get(id1).setNumOfReceivedGoals(team1.getNumOfReceivedGoals()+secondTeamGoals);
            insertData.get(id1).setCurrentClubPoints(team1.getCurrentClubPoints()+1);
            insertData.get(id1).setNumOfPlayedMatches(team1.getNumOfPlayedMatches()+1);

            insertData.get(id2).setDraws(team2.getDraws()+1);
            insertData.get(id2).setNumOfScoredGoals(team2.getNumOfScoredGoals()+secondTeamGoals);
            insertData.get(id2).setNumOfReceivedGoals(team2.getNumOfReceivedGoals()+firstTeamGoals);
            insertData.get(id2).setCurrentClubPoints(team2.getCurrentClubPoints()+1);
            insertData.get(id2).setNumOfPlayedMatches(team2.getNumOfPlayedMatches()+1);

            System.out.println("\nFootballClub{" +
                    " name='" + team1.name +'\''+
                    ", clubLocation='" + team1.clubLocation +'\''+
                    ", numberOfMembers=" + team1.numberOfMembers +
                    ", numOfPlayedMatches=" + team1.numOfPlayedMatches +
                    ", wins=" + team1.wins +
                    ", draws=" + team1.draws +
                    ", defeats=" + team1.defeats +
                    ", numOfReceivedGoals=" + team1.numOfReceivedGoals +
                    ", numOfScoredGoals=" + team1.numOfScoredGoals +
                    ", currentClubPoints=" + team1.currentClubPoints +
                    '}'+'\n');

            System.out.println("\nFootballClub{" +
                    " name='" + team2.name +'\''+
                    ", clubLocation='" + team2.clubLocation +'\''+
                    ", numberOfMembers=" + team2.numberOfMembers +
                    ", numOfPlayedMatches=" + team2.numOfPlayedMatches +
                    ", wins=" + team2.wins +
                    ", draws=" + team2.draws +
                    ", defeats=" + team2.defeats +
                    ", numOfScoredGoals=" + team2.numOfScoredGoals +
                    ", numOfReceivedGoals=" + team2.numOfReceivedGoals +
                    ", currentClubPoints=" + team2.currentClubPoints +
                    '}'+'\n');

        }
        // Condision for that team 2 winning
        else {
            System.out.println("\n"+secondTeam+" team is the winner...");
            System.out.println(firstTeam+" team has loss this match...");
            innerArrayList.add(secondTeam);

            // Win team status adding to the first array
            insertData.get(id2).setWins(team2.getWins()+1);
            insertData.get(id2).setNumOfScoredGoals(team2.getNumOfScoredGoals()+secondTeamGoals);
            insertData.get(id2).setNumOfReceivedGoals(team2.getNumOfReceivedGoals()+firstTeamGoals);
            insertData.get(id2).setCurrentClubPoints(team2.getCurrentClubPoints()+3);
            insertData.get(id2).setNumOfPlayedMatches(team2.getNumOfPlayedMatches()+1);

            // Defeat team status adding to the first array
            insertData.get(id1).setDefeats(team1.getDefeats()+1);
            insertData.get(id1).setNumOfScoredGoals(team1.getNumOfScoredGoals()+firstTeamGoals);
            insertData.get(id1).setNumOfReceivedGoals(team1.getNumOfReceivedGoals()+secondTeamGoals);
            insertData.get(id1).setNumOfPlayedMatches(team1.getNumOfPlayedMatches()+1);

            System.out.println("\nFootballClub{" +
                    " name='" + team1.name +'\''+
                    ", clubLocation='" + team1.clubLocation +'\''+
                    ", numberOfMembers=" + team1.numberOfMembers +
                    ", numOfPlayedMatches=" + team1.numOfPlayedMatches +
                    ", wins=" + team1.wins +
                    ", draws=" + team1.draws +
                    ", defeats=" + team1.defeats +
                    ", numOfReceivedGoals=" + team1.numOfReceivedGoals +
                    ", numOfScoredGoals=" + team1.numOfScoredGoals +
                    ", currentClubPoints=" + team1.currentClubPoints +
                    '}'+'\n');

            System.out.println("\nFootballClub{" +
                    " name='" + team2.name +'\''+
                    ", clubLocation='" + team2.clubLocation +'\''+
                    ", numberOfMembers=" + team2.numberOfMembers +
                    ", numOfPlayedMatches=" + team2.numOfPlayedMatches +
                    ", wins=" + team2.wins +
                    ", draws=" + team2.draws +
                    ", defeats=" + team2.defeats +
                    ", numOfScoredGoals=" + team2.numOfScoredGoals +
                    ", numOfReceivedGoals=" + team2.numOfReceivedGoals +
                    ", currentClubPoints=" + team2.currentClubPoints +
                    '}'+'\n');
        }
        insertData2.add(innerArrayList);
    }

    // Methode for the saving data
    @Override
    public void saveInputs() throws IOException {
        // Saving all data to a file
        File dataStore = new File("D:\\Thisath\\IIT\\Level 5 CS\\Object-Oriented Programming (5COSC007C)\\Refer\\Data File\\allClubData");
        FileOutputStream outputData = new FileOutputStream(dataStore);
        ObjectOutputStream getFileData = new ObjectOutputStream(outputData);

        for (FootballClub fObject:insertData){
            getFileData.writeObject(fObject);
        }

        // Saving all added data to a txt file 
        if (insertData.size()>0){
            FileWriter writerData = new FileWriter("D:\\Thisath\\IIT\\Level 5 CS\\Object-Oriented Programming (5COSC007C)\\Refer\\Data File\\matchData.txt");
            for (ArrayList<String> matchArray:insertData2){
                writerData.write(matchArray+System.lineSeparator());
            }
            writerData.close();
        }

        System.out.println("Details Successfully saved in the Premier Leuge System...");

    }

    // Methode for the load data
    @Override
    public void loadData(String loadedData) throws IOException {
        FileInputStream inputData = new FileInputStream(loadedData);
        ObjectInputStream inputData2 = new ObjectInputStream(inputData);

        File newLoadData = new File ("D:\\Thisath\\IIT\\Level 5 CS\\Object-Oriented Programming (5COSC007C)\\Refer\\Data File\\matchData.txt");

        if (newLoadData.length()>0) {
            FileReader newLoadData2 = new FileReader(newLoadData);
            char[] chars = new char[(int) newLoadData.length()];
            newLoadData2.read(chars);

            String fileData = new String(chars);

            String[] newArray = fileData.split(System.lineSeparator());
            for (String fileList : newArray) {
                //removing brackets
                fileList = fileList.replace("[", "").replace("]", "");

                //splitting the elements by comma and space
                List<String> asList = Arrays.asList(fileList.split(", "));
                insertData2.add(new ArrayList<>(asList));

            }
//            System.out.println("Loaded Data...\n" + insertData2);
//            newLoadData2.close();
        }
        for (;;){
            try {
                FootballClub fbLoad = (FootballClub) inputData2.readObject();
                insertData.add(fbLoad);

//                System.out.println("FootballClub{" +
//                        "clubName=" + fbLoad.name +
//                        ", location=" + fbLoad.clubLocation +
//                        ", playedMatches=" + fbLoad.numOfPlayedMatches +
//                        ", wins=" + fbLoad.wins +
//                        ", draws=" + fbLoad.draws +
//                        ", defeats=" + fbLoad.defeats +
//                        ", scoredGoals=" + fbLoad.numOfScoredGoals +
//                        ", receivedGoals=" + fbLoad.numOfReceivedGoals +
//                        ", points='" + fbLoad.currentClubPoints + '}');
//                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            }catch (IOException | ClassNotFoundException e){
                break;
            }
        }
        System.out.println("Data successfully loaded....");
    }

    // Methode for the exit
    @Override
    public void exit() {
        System.exit(0);
    }

    // Method to throw an error massage when data loading get an error
    public void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}