/**
 * FILE: 	Person.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Modified version of Person.java I submitted for Prac01
 */
public class Person
{
	private String name;
	private String contactEmail;
	private String dob;

	/**
	 * NAME: Default Constructor 
	 * IMPORT: none
	 * EXPORT: none
	 * PURPOSE: Create a default Person object
	 */
	public Person()
	{
		setName("");
		setContactEmail("");
		setDob("");
	}
	
	/**
	 * NAME: Standard Constructor 
	 * IMPORT: inName, inContactEmail (String)
	 * IMPORT: inDob (String)
	 * EXPORT: none
	 * PURPOSE: Create a custom Person object
	 */
	public Person(String inName, String inContactEmail, String inDob)
	{
		setName(inName);
		setContactEmail(inContactEmail);
		setDob(inDob);
	}
	
	/**
	 * NAME: Copy Constructor 
	 * IMPORT: inPerson (Person)
	 * EXPORT: none
	 * PURPOSE: Create a copy of a Person object
	 */
	public Person(Person inPerson)
	{
		setName(inPerson.getName());
		setContactEmail(inPerson.getContactEmail());
		setDob(inPerson.getDob());
	}

	/**
	 * NAME: setName 
	 * IMPORT: inName (String)
	 * EXPORT: none
	 * PURPOSE: Setter for name class field
	 */
	public void setName(String inName) 
	{
		name = inName;
	}

	/**
	 * NAME: getName 
	 * IMPORT: none
	 * EXPORT: name (String)
	 * PURPOSE: Getter for name class field
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * NAME: setcontactEmail 
	 * IMPORT: inContactEmail (String)
	 * EXPORT: none
	 * PURPOSE: Setter for contactEmail class field
	 */
	public void setContactEmail(String inContactEmail)
	{
		contactEmail = inContactEmail;
	}

	/**
	 * NAME: getContactEmail 
	 * IMPORT: none
	 * EXPORT: contactEmail (String)
	 * PURPOSE: Getter for contactEmail class field
	 */
	public String getContactEmail()
	{
		return contactEmail;
	}

	/**
	 * NAME: setDob
	 * IMPORT: inDob (String)
	 * EXPORT: none
	 * PURPOSE: Setter for dob class field
	 */
	public void setDob(String inDob)
	{
		dob = inDob;
	}

	/**
	 * NAME: getDob 
	 * IMPORT: none
	 * EXPORT: dob (String)
	 * PURPOSE: Getter for dob class field
	 */
	public String getDob()
	{
		return dob;
	}
	
	/**
	 * NAME: toString
	 * IMPORT: none
	 * EXPORT: outString (String)
	 * PURPOSE: Convert a Person object to a String
	 */
	public String toString()
	{
		String outString = "Name: " + this.getName() + "\nContact Email: " + this.getContactEmail() + "\nDate of Birth: " + this.getDob();
		
		return outString;
	}
	
	/**
	 * NAME: equals
	 * IMPORT: inObj (Object)
	 * EXPORT: isEqual (Boolean)
	 * PURPOSE: Check if two Person objects are equal
	 * ASSERTION: Two Person objects are equal if they have the same name and contact email
	 */
	public boolean equals(Object inObj)
	{
		boolean isEqual = false;
		Person person;
		if(inObj instanceof Person)
		{
			person = (Person)inObj;
			if(person.getName().equals(this.getName()))
			{
				if(person.getContactEmail().equals(this.getContactEmail()))
				{
					isEqual = true;
				}
			}
		}
		return isEqual;
	}
}
