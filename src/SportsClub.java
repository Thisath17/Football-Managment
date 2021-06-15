public abstract class SportsClub {
    String name;
    String clubLocation;
    int numberOfMembers;

    public SportsClub() {

    }

    public SportsClub(String name, String clubLocation, int numberOfMembers) {
        this.name = name;
        this.clubLocation = clubLocation;
        this.numberOfMembers = numberOfMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
       this.numberOfMembers = numberOfMembers;
    }
}
