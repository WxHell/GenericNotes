interface Player{
    String name();
}
record BaseballPlayer(String name,String position) implements Player {}
record FootballPlayer(String name,String position) implements Player {}
record VolleyballPlayer(String name,String position) implements Player{}
public class Main {
    public static void main(String[] args) {
   var philly = new Affiliation("city","Philadelphia, PA","US");

    BaseballTeam GS1 = new BaseballTeam("GS1");
    BaseballTeam FB1 = new BaseballTeam("FB1");
    scoreResult(GS1, 20,FB1,10);

    SportsTeam GS2 = new SportsTeam("GS");
    SportsTeam FB2 = new SportsTeam("FB");
    scoreResult(GS2, 20,FB2,10);

    Team<BaseballPlayer,Affiliation> GS = new Team<>("GS",philly);
    Team<BaseballPlayer,Affiliation> FB = new Team<>("FB");
    scoreResult(GS, 20,FB,10);

    var harper = new BaseballPlayer("B Harper","Right Fielder");

    var mars = new BaseballPlayer("B Marsh","Right Fielder");
    GS.addTeamMember(harper);
    GS.addTeamMember(mars);

    var alex = new BaseballPlayer("Alex","Forward");
    GS.addTeamMember(alex);//football takımına baseball oyuncusu ekliyor
    GS.listTeamMembers();
    SportsTeam afc1=new SportsTeam("Adelaide Crwos");

    Team<FootballPlayer,String> afc=new Team<>("Adelaide Crows","City of Adelaide,South Australia, in Au");
    var tex = new FootballPlayer("Tex Waller","Center half forward");
    afc.addTeamMember(tex);

    var zaha = new FootballPlayer("Zaha","SLK");
    afc.addTeamMember(zaha);
    afc.listTeamMembers();

    Team<VolleyballPlayer,Affiliation> adelaide =new Team<>("Adelaide Storm");
    adelaide.addTeamMember(new VolleyballPlayer("N Roberts","Setter"));
    adelaide.listTeamMembers();

    var canberra = new Team<VolleyballPlayer,Affiliation>("Canberra Heat");
    canberra.addTeamMember(new VolleyballPlayer("B black","Forward"));
    canberra.listTeamMembers();
    scoreResult(canberra,0,adelaide,1);
    }
    public static  void  scoreResult(BaseballTeam team1,int t1_score,
                                     BaseballTeam team2,int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
    public static  void  scoreResult(SportsTeam team1,int t1_score,
                                       SportsTeam team2,int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }

    public static  void  scoreResult(Team team1,int t1_score,
                                     Team team2,int t2_score){
        String message = team1.setScore(t1_score,t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n",team1,message,team2);
    }
}
