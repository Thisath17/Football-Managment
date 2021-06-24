import java.util.Comparator;

public class FootballClub extends SportsClub{
    int wins,draws,defeats,numOfPlayedMatches,numOfScoredGoals,numOfReceivedGoals,currentClubPoints;

    public FootballClub() {
    }

    @Override
    public String toString() {
        return "\nFootballClub{" +
                " name='" + name +'\''+
                ", clubLocation='" + clubLocation +'\''+
                ", numberOfMembers=" + numberOfMembers +
                ", numOfPlayedMatches=" + numOfPlayedMatches +
                ", wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", numOfScoredGoals=" + numOfScoredGoals +
                ", numOfReceivedGoals=" + numOfReceivedGoals +
                ", currentClubPoints=" + currentClubPoints +
                '}'+'\n' ;
    }

    public FootballClub(String name, String clubLocation, int numberOfMembers, int wins, int draws, int defeats, int numOfReceivedGoals, int numOfScoredGoals, int numOfPlayedMatches, int currentClubPoints) {
        super(name, clubLocation, numberOfMembers);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numOfReceivedGoals = numOfReceivedGoals;
        this.numOfScoredGoals = numOfScoredGoals;
        this.numOfPlayedMatches = numOfPlayedMatches;
        this.currentClubPoints = currentClubPoints;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumOfReceivedGoals() {
        return numOfReceivedGoals;
    }

    public void setNumOfReceivedGoals(int numOfReceivedGoals) {
        this.numOfReceivedGoals = numOfReceivedGoals;
    }

    public int getNumOfScoredGoals() {
        return numOfScoredGoals;
    }

    public void setNumOfScoredGoals(int numOfScoredGoals) {
        this.numOfScoredGoals = numOfScoredGoals;
    }

    public int getNumOfPlayedMatches() {
        return numOfPlayedMatches;
    }

    public void setNumOfPlayedMatches(int numOfPlayedMatches) {
        this.numOfPlayedMatches = numOfPlayedMatches;
    }

    public int getCurrentClubPoints() {
        return currentClubPoints;
    }

    public void setCurrentClubPoints(int currentClubPoints) {
        this.currentClubPoints = currentClubPoints;
    }
    
        public static Comparator<FootballClub> comparatorMethod = new Comparator<FootballClub>() {
        @Override
        public int compare(FootballClub o1, FootballClub o2) {
            Integer newPoint1 = o1.getCurrentClubPoints();
            Integer newPoint2 = o2.getCurrentClubPoints();

            int pointCompare = newPoint2.compareTo(newPoint1);

            if (pointCompare!=0){
                return newPoint2.compareTo(newPoint1);
            }

            Integer newGoal1 = o1.getNumOfScoredGoals()-o1.getNumOfReceivedGoals();
            Integer newGoal2 = o2.getNumOfScoredGoals()-o2.getNumOfReceivedGoals();
            return newGoal2.compareTo(newGoal1);
        }
    };
    
}
