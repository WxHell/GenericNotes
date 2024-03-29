import java.util.ArrayList;
import java.util.List;
record Affiliation(String name,String type,String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + " )";
    }
}
public class Team<T extends Player,S> {
    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private  int totalWins = 0;
    private int totalLoses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName= teamName;
    }
    public Team(String teamName,S affiliation) {
        this.teamName= teamName;
        this.affiliation=affiliation;
    }

    public void addTeamMember(T t){
        if (!teamMembers.contains(t)){
            teamMembers.add(t);
        }
    }

    public void listTeamMembers(){
        System.out.print(teamName + "Roster:");
        System.out.println((affiliation == null ? "": "AFFILIATION: "+affiliation));
        for (T t :teamMembers){
            System.out.println(t.name());
        }
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
//E for Elemnt
//K for Key
//N for Number
//T for Type
//V for Value
//S,U,V etc. for 2and,3rd,4th types