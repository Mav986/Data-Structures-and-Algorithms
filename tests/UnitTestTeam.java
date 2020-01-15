
public class UnitTestTeam
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing Team.java ====\n");
		LinkedList<Person> testList = new LinkedList<Person>();
		Person testObj = new Person();
		testList.insertLast(testObj);

		LinkedList<Person> testListTwo = new LinkedList<Person>();
		Person testObjTwo = new Person();
		testListTwo.insertLast(testObjTwo);
		
		/**
		 * ======== TESTING CONSTRUCTORS ========
		 */		
		Team o1 = new Team();
		Team o2 = new Team("name here", "short name here", 
				"address here", "contact name here", "contact email here", testList, testListTwo);
		Team o3 = new Team(o2);

		System.out.print("constructors: ");
		boolean consPass = o1.getName().equals("") && o2.getName().equals("name here") && o3.getName().equals("name here");
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
		boolean checkPassTwo;
		boolean addsPass;
		boolean addsPassTwo;
		boolean pass;
		
		// If a player or coach exists, fail the test
		checkPass = o1.getPlayers().isEmpty();
		checkPassTwo = o1.getCoaches().isEmpty();
		
		o1.addPlayer(testObj);
		o1.addCoach(testObjTwo);
		
		addsPass = !o1.getPlayers().isEmpty();
		addsPassTwo = !o1.getCoaches().isEmpty();
		
		pass = checkPass && checkPassTwo && addsPass && addsPassTwo;
		
		if(pass)
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
		boolean equalsPass = o2.equals(o3);
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
		o1.setName(o2.getName());
		setGetPass = o1.getName().equals(o2.getName());
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
