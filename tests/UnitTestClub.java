public class UnitTestClub
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing Club.java ====\n");
		LinkedList<Team> t1 = new LinkedList<Team>();
		Team team = new Team();
		t1.insertLast(team);
		
		/**
		 * ======== TESTING CONSTRUCTORS ========
		 */		
		Club c1 = new Club();
		Club c2 = new Club("name here", "short name here", 
				"address here", "contact name here", "contact email here", t1);
		Club c3 = new Club(c2);

		System.out.print("constructors: ");
		boolean consPass = c1.getName().equals("") && c2.getName().equals("name here") && c3.getName().equals("name here");
		if(consPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		/**
		 * ======== TESTING ADDERS ========
		 */
		System.out.print("adder: ");
		boolean checkPass;
		boolean addsPass;
		// If a team exists, fail the test
		checkPass = c1.getTeams().isEmpty();		
		c1.addChild(team);
		addsPass = !c1.getTeams().isEmpty();
		if(checkPass && addsPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		/**
		 * ======== TESTING EQUALS ========
		 */
		System.out.print("equals: ");
		boolean equalsPass = c2.equals(c3);
		if(equalsPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		/**
		 * ======== TESTING SETTERS/GETTERS ========
		 */
		System.out.print("set/get: ");
		boolean setGetPass;
		c1.setName(c2.getName());
		setGetPass = c1.getName().equals(c2.getName());
		if(setGetPass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
}
