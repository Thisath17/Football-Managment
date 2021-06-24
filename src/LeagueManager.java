import java.io.IOException;

public interface LeagueManager {

    public void createClub();
    public void removeClub();
    public void displayStatics();
    public void displayTable();
    public void addMatch();
    public void saveInputs() throws IOException;
    public void loadData(String loadedData) throws IOException;
    public void exit();

}
