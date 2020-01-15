
public class UnitTestState
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing State.java ====\n");
		LinkedList<Association> testList = new LinkedList<Association>();
		Association testObj = new Association();
		testList.insertLast(testObj);
		
		/**
		 * ======== TESTING CONSTRUCTORS ========
		 */		
		State o1 = new State();
		State o2 = new State("name here", "short name here", 
				"address here", "contact name here", "contact email here", testList);
		State o3 = new State(o2);

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
		boolean addsPass;
		// If a team exists, fail the test
		checkPass = o1.getAssociations().isEmpty();		
		o1.addChild(testObj);
		addsPass = !o1.getAssociations().isEmpty();
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
