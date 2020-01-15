import java.util.*;

public class UnitTestObjectHandler
{
	private static String national;
	private static String state;
	private static String association;
	private static String club;
	private static String team;
	private static String person;
	private static String wrongFormat;
	
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing ObjectHandler.java ====\n");
		initializeStrings();
		System.out.print("real data: ");
		legitTest();
		System.out.print("fake data: ");
		fakeTest();
	}
	
	private static void fakeTest()
	{
		try
		{
			//Empty
			ObjectHandler.createObject("");
			SearchHandler.findOrg("");
			SearchHandler.findPerson("");			
		}
		catch(NoSuchElementException e)
		{
			try
			{
				//Duplicate
				ObjectHandler.createObject(national);
				SearchHandler.findOrg("tennis australia");
				
				try
				{
					//Wrong Format
					ObjectHandler.createObject(wrongFormat);
					SearchHandler.findOrg(wrongFormat);
					SearchHandler.findPerson(wrongFormat);
				}
				catch(NoSuchElementException e3)
				{
					System.out.println("pass");
				}
			}
			catch(NoSuchElementException e2)
			{
				System.out.println("fail2");
			}
		}		
	}
	
	private static void legitTest()
	{
		ObjectHandler.createObject(national);
		ObjectHandler.createObject(state);
		ObjectHandler.createObject(association);
		ObjectHandler.createObject(club);
		ObjectHandler.createObject(team);
		ObjectHandler.createObject(person);
		System.out.println("pass");
	}
	
	private static void initializeStrings()
	{
		national = "NATIONAL,"
				+ "SPORT:Tennis,"
				+ "NAME:Tennis Australia,"
				+ "CONTACT_NAME:All-Bus Dumbell-Door,"
				+ "CONTACT_EMAIL:tennisAust@fakedomain.org,"
				+ "CONTACT_ADDRESS:1 Infinite Loop";
		
		state = "STATE,"
				+ "NAME:Tennis WA,"
				+ "PARENT:Tennis Australia,"
				+ "CONTACT_NAME:Lorde,"
				+ "CONTACT_EMAIL:TennisWA@fakedomain.org,"
				+ "CONTACT_ADDRESS:2 Infinite Loop";
		
		association = "ASSOCIATION,"
				+ "NAME:Kalamunda Tennis Association,"
				+ "SHORT:KNA_WA,"
				+ "PARENT:Tennis WA,"
				+ "CONTACT_NAME:Several Snakes,"
				+ "CONTACT_EMAIL:KNL@fakedomain.org,"
				+ "CONTACT_ADDRESS:52 Serpentine Meander,"
				+ "UMPIRE:Ali Berthelette";
		
		club = "CLUB,"
				+ "NAME:Manaaki Tennis Club,"
				+ "SHORT:Manaaki,"
				+ "PARENT:SDNA_WA,"
				+ "CONTACT_NAME:Her Money-Stranger,"
				+ "CONTACT_EMAIL:Manaaki@fakedomain.org,"
				+ "CONTACT_ADDRESS:570 Serpentine Meander";
		
		team = "TEAM,"
				+ "NAME:Hearts3,"
				+ "PARENT:Hearts,"
				+ "CONTACT_NAME:Ron Sneazely,"
				+ "CONTACT_EMAIL:Ron.Sneazely@fakedom.org,"
				+ "CONTACT_ADDRESS:806 Infinite Loop,"
				+ "PLAYER:Harry Lotta";
		
		person = "NAME:Harry Lotta"
				+ "CONTACT_EMAIL:Harry.Lotta@fakedom.org"
				+ "DOB:21/05/2017";
		
		wrongFormat = "NAME:Kalamunda Tennis Association,"
				+ "SHORT:KNA_WA,"
				+ "PARENT:Tennis WA,"
				+ "CONTACT_NAME:Several Snakes,"
				+ "CONTACT_EMAIL:KNL@fakedomain.org,"
				+ "ASSOCIATION,"
				+ "CONTACT_ADDRESS:52 Serpentine Meander,"
				+ "UMPIRE:Ali Berthelette";
	}
}
