public class FootballClub extends SportsClub{
    int wins;
    int draws;
    int defeats;
    int numOfReceivedGoals;
    int numOfScoredGoals;
    int numOfPlayedMatches;
    int currentClubPoints;

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
                ", numOfReceivedGoals=" + numOfReceivedGoals +
                ", numOfScoredGoals=" + numOfScoredGoals +
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
}
