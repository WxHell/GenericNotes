import java.util.ArrayList;
import java.util.List;

public class SportsTeam {
    private String teamName;
    private List<Player> teamMembers = new ArrayList<>();
    private  int totalWins = 0;
    private int totalLoses = 0;
    private int totalTies = 0;

    public SportsTeam(String teamName) {
        this.teamName= teamName;
    }
    public void addTeamMember(Player player){
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.println(teamName + "Roster:");
        System.out.println(teamMembers);
    }

    public int ranking(){
        return (totalLoses * 2 )+ totalTies + 1 ;
    }
    public String setScore(int ourScore,int theirScore){
        String message = "Lose to";
        if (ourScore > theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;//toplam beraberlik
            message = "tied";
        }else {
            if (ourScore < theirScore){
                totalLoses++;
                message = "losed";
            }
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + "(Ranked "+ ranking() +")";
    }
}
