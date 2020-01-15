
public class UnitTestReportHandler
{	
	public static void main(String[] args)
	{
		National nat = new National();
		State state = new State();
		Association assoc = new Association();
		Club club = new Club();
		Team team = new Team();
		Person player = new Person();		
		Umpire umpire = new Umpire();
		Person coach = new Person();
		
		nat.setName("NatOne");
		state.setName("StateOne");
		assoc.setName("AssocOne");
		club.setName("ClubOne");
		team.setName("TeamOne");
		player.setName("PlayerOne");
		umpire.setName("UmpireOne");
		coach.setName("CoachOne");
		
		nat.addChild(state);
		state.addChild(assoc);
		assoc.addChild(club);
		assoc.addUmpire(umpire);
		club.addChild(team);
		team.addPlayer(player);
		team.addCoach(coach);
		
		ReportHandler.addToList(nat);
		ReportHandler.addToList(state);
		ReportHandler.addToList(assoc);
		ReportHandler.addToList(club);
		ReportHandler.addToList(team);
		ReportHandler.addToList(player);
		SearchHandler.addToSearch(player.getName(), player);
		SearchHandler.addToSearch(umpire.getName(), umpire);
		SearchHandler.addToSearch(coach.getName(), coach);

		System.out.print("&&&&&&&& TESTING NATIONALREPORT &&&&&&&& \n");
		ReportHandler.nationalReport();
		System.out.print("\n&&&&&&&& TESTING STATEREPORT &&&&&&&& \n");
		ReportHandler.stateReport();
		System.out.print("\n&&&&&&&& TESTING ASSOCIATIONREPORT &&&&&&&& \n");
		ReportHandler.assocReport();
		System.out.print("\n&&&&&&&& TESTING CLUBREPORT &&&&&&&&\n");
		ReportHandler.clubReport();
	}
}
