import java.util.*;

/**
 * FILE: 	MenuHandler.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Version 1.0
 */
public class MenuHandler 
{
	/**
	 * NAME: mainMenu
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display the main menu and allow the user to select an option
	 */
	public static void mainMenu()
	{
		int userInput = -1;
		System.out.println("\n1 - Load Data\n"
				+ "2 - Club Report\n"
				+ "3 - Association Report\n"
				+ "4 - State Report\n"
				+ "5 - National Report\n"
				+ "6 - Person Search\n"
				+ "0 - Quit\n");
		System.out.print("Choice: ");

		try
		{
			userInput = getUserInt();
			if(userInput < 0 || userInput > 6)
			{
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nPlease enter an integer between 0 and 6!\n");
			mainMenu();
		}
		menuControl(userInput);
	}

	/**
	 * NAME: searchMenu
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display the search menu and allow a user to select an option
	 */
	public static void searchMenu()
	{
		int userInput = -1;
		System.out.print("\n1 - New search"
				+ "\n2 - Save last search to file"
				+ "\n3 - Return to main menu"
				+ "\n\nChoice: ");

		try
		{
			userInput = getUserInt();
			if(userInput < 1 || userInput > 3)
			{
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nPlease enter an integer between 1 and 3!");
		}
		searchControl(userInput);
	}

	/**
	 * NAME: getUserInt
	 * IMPORT: none
	 * EXPORT: userChoice (Integer)
	 * PURPOSE: Get user input when it is an integer
	 */
	private static int getUserInt()
	{
		Scanner getInput = new Scanner(System.in);
		int userChoice = -1;
		userChoice = getInput.nextInt();

		return userChoice;
	}

	/**
	 * NAME: menuControl
	 * IMPORT: userChoice (Integer)
	 * EXPORT: none
	 * PURPOSE: Control which methods are called based on imported parameter
	 */
	private static void menuControl(int userChoice)
	{
		switch(userChoice)
		{
			case 0:		break;
			case 1: 	loadFile();
						mainMenu();
						break;
			case 2:		ReportHandler.clubReport();
						mainMenu();
						break;
			case 3:		ReportHandler.assocReport();
						mainMenu();
						break;
			case 4:		ReportHandler.stateReport();
						mainMenu();
						break;
			case 5:		ReportHandler.nationalReport();
						mainMenu();
						break;
			case 6:		searchMenu();
						break;
			default:	break;
		}
	}

	/**
	 * NAME: searchControl
	 * IMPORT: userChoice (Integer)
	 * EXPORT: none
	 * PURPOSE: Control which methods are called based on imported parameter
	 */
	private static void searchControl(int userChoice)
	{
		switch(userChoice)
		{
			case 1:		searchPrompt();
						searchMenu();
						break;
			case 2:		SearchHandler.writePrevSearch();
						searchMenu();
						break;		
			case 3:		mainMenu();
						break;
			default:	searchMenu();
						break;
		}
	}

	/**
	 * NAME: searchPrompt
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Display a prompt and allow a user to enter a search term
	 */
	private static void searchPrompt()
	{
		Scanner getInput = new Scanner(System.in);
		String searchTerm = "";		
		LinkedList<Person> currentSearch = new LinkedList<Person>();
		System.out.println("\n---- Person Search ----");
		System.out.println("This function will allow you to perform a full or partial search of a player name."
				+ "\nThe search is case sensitive\n");
		System.out.print("Enter search term: ");
		searchTerm = getInput.nextLine();

		currentSearch = SearchHandler.personSearch(searchTerm);
		SearchHandler.printCurrentSearch(currentSearch);
	}

	/**
	 * NAME: loadFile
	 * IMPORT: file (String)
	 * EXPORT: none
	 * PURPOSE: Call the read method from FileHandler if data hasn't yet been loaded
	 */
	private static void loadFile()
	{
		Scanner getInput = new Scanner(System.in);
		String file = "";
		System.out.print("\nPlease enter a filename, including the format extension: ");
		file = getInput.nextLine();
//		try
//		{
			FileHandler.read(file);
//		}
//		catch(UnsupportedOperationException e)
//		{
//			System.out.println("Data already loaded, please restart program to load new data");
//		}
	}
}
