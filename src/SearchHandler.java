/**
 * FILE: 	SearchHandler.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Version 1.0
 */
public class SearchHandler
{
	private static LinkedList<Person> prevSearch = new LinkedList<Person>();
	private static BinarySearchTree<Organization> orgSearch = new BinarySearchTree<Organization>();
	private static BinarySearchTree<Person> peopleSearch = new BinarySearchTree<Person>();
	
	/**
	 * NAME: addToSearch
	 * IMPORT: orgKey (String)
	 * IMPORT: org (Organization)
	 * EXPORT: none
	 * PURPOSE: Add an organization to the search tree
	 * NOTE: Overloaded method for user simplicity
	 */
	public static void addToSearch(String orgKey, Organization org)
	{
		orgSearch.insert(orgKey, org);
	}
	
	/**
	 * NAME: addToSearch
	 * IMPORT: personKey (String)
	 * IMPORT: inPerson (Person)
	 * EXPORT: none
	 * PURPOSE: Add a person to the search tree
	 * NOTE: Overloaded method for user simplicity
	 */
	public static void addToSearch(String personKey, Person person)
	{
		peopleSearch.insert(personKey, person);
	}
	
	/**
	 * NAME: findOrg
	 * IMPORT: orgName (String)
	 * EXPORT: found (Organization)
	 * PURPOSE: Wrapper method to find an organization
	 */
	public static Organization findOrg(String orgName)
	{
		Organization found = orgSearch.find(orgName);
		
		return found;
	}
	
	/**
	 * NAME: findPerson
	 * IMPORT: personName (String)
	 * EXPORT: found (Person)
	 * PURPOSE: Wrapper method to find a single person
	 */
	public static Person findPerson(String personName)
	{
		Person found = peopleSearch.find(personName);
		
		return found;
	}
	
	/**
	 * NAME: personSearch
	 * IMPORT: searchTerm (String)
	 * EXPORT: none
	 * PURPOSE: Find all people who's name starts with the search term
	 */
	public static LinkedList<Person> personSearch(String searchTerm)
	{
		LinkedList<Person> currentSearch = new LinkedList<Person>();
		LinkedList<Person> people = ReportHandler.getPeople();
		for(Person person : people)
		{
			if(person.getName().startsWith(searchTerm))
			{
				currentSearch.insertLast(person);		
			}
		}
		prevSearch = currentSearch;
		
		return currentSearch;
	}

	/**
	 * NAME: writePrevSearch 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Print the previous search to file
	 */
	public static void writePrevSearch()
	{
		String filename = "";
		for(Person person : prevSearch)
		{
			filename = FileHandler.write(person.toString());
		}
		System.out.println("\nSaved to file: " + filename);
	}

	/**
	 * NAME: printCurrentSearch
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: print search results to console
	 */
	public static void printCurrentSearch(LinkedList<Person> currentSearch)
	{
		for(Person person : currentSearch)
		{
			System.out.println("\n" + person.toString());
		}
	}
}
