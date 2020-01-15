import java.util.*;

public class UnitTestSearchHandler
{
	public static void main(String[] args)
	{
		System.out.println("==== TESTING SEARCHHANDLER ====\n");
		UnitTestOrganization.TestOrg testOrg = new UnitTestOrganization.TestOrg();
		Person testPerson = new Person();
		Person testPersonTwo = new Person();
		testPerson.setName("Mark Ericson");
		testPersonTwo.setName("Markus Georgeson");
		
		/**
		 * Testing findOrg/findPerson
		 * (Finds the first person or organization matching the passed in parameter)
		 */
		
		System.out.print("findOrg/Person: ");
		try
		{
			testOrg = (UnitTestOrganization.TestOrg)SearchHandler.findOrg("");
			testPerson = SearchHandler.findPerson("Mark");
			System.out.println("fail");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("pass");
		}
		
		/**
		 * Testing addToSearch
		 */
		SearchHandler.addToSearch(testOrg.getName(), testOrg);
		SearchHandler.addToSearch(testPerson.getName(), testPerson);
		
		System.out.print("addToSearch: ");
		try
		{
			SearchHandler.findOrg("");
			SearchHandler.findPerson("Mark");
			System.out.println("pass");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("fail");
		}
		
		/**
		 * Testing personSearch
		 * (Finds all people with a name starting with the parameter)
		 */
		LinkedList<Person> testSearch = new LinkedList<Person>();
		SearchHandler.addToSearch(testPersonTwo.getName(), testPersonTwo);
		ReportHandler.addToList(testPersonTwo);
		ReportHandler.addToList(testPerson);
		int count = 0;
		
		System.out.print("personSearch: ");
		try
		{
			testSearch = SearchHandler.personSearch("Mark");
			for(Person p : testSearch)
			{
				count++;
			}
			if(count == 2)
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("fail");
		}
	}
}
