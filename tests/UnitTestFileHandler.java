public class UnitTestFileHandler
{
	public static void main(String[] args)
	{
		System.out.println("==== Unit Testing FileHandler.java ====\n");
		
		testRead();
		testWrite();
		testRemoveComma();
		testRemoveColon();
	}
	
	private static void testRead()
	{
		/**
		 * ======== TESTING READ ========
		 * Testing a real file, a fake file, and a wrong format file
		 * The test should throw an error if a file cannot be found,
		 * otherwise succeed at reading. Any errors on data format within
		 * the file should be handled later, when attempting to create
		 * objects.
		 */
		System.out.println("-------- TESTING READ --------\n");
		try
		{
			System.out.print("---- Proper File ----");
			FileHandler.read("ProperTest.csv");
			try
			{
				System.out.print("---- Fake File Test ----");
				FileHandler.read("FakeFile.csv");
				try
				{
					System.out.print("---- Bad Format Test ----");
					FileHandler.read("BadTest.txt");
					
					System.out.println("\nAll Tests Passed!");
				}
				catch(Exception e3)
				{
					System.out.print("read: fail");
				}
			}
			catch(Exception e2)
			{
				System.out.print("read: fail");
			}
		}
		catch(Exception e)
		{
			System.out.print("read: fail");
		}
	}
	
	private static void testWrite()
	{
		/**
		 * ======== TESTING WRITE ========
		 * Testing 
		 */
		String test = "Test String";
		System.out.println("\n-------- TESTING WRITE --------\n");	
		System.out.println("Verify that file has been written to: " + FileHandler.write(test));
	}
	
	private static void testRemoveComma()
	{
		String test = "Test,One,Two";
		System.out.println("\n-------- TESTING REMOVECOMMA --------\n");	
		System.out.print("testRemoveComma: ");
		String[] testResult = FileHandler.removeComma(test);
		boolean pass = testResult[0].equals("Test") && testResult[1].equals("One") && testResult[2].equals("Two");
		if(pass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
	}
	
	private static void testRemoveColon()
	{
		String test = "Test:One:Two";
		System.out.println("\n-------- TESTING REMOVECOLON --------\n");	
		System.out.print("testRemoveColon: ");
		String[] testResult = FileHandler.removeColon(test);
		boolean pass = testResult[0].equals("Test") && testResult[1].equals("One") && testResult[2].equals("Two");
		if(pass)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
	}
}
