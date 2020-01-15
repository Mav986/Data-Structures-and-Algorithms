import java.io.*;
import java.text.*;
import java.util.*;

/**
 * FILE: 	FileHandler.java
 * AUTHOR: 	Kalon Shannon-Innes
 * ID: 		18529687
 * UNIT: 	Data Structures and Algorithms
 * DATE: 	May 19, 2017 
 * SOURCE: 	Modified version of FileHandler.java I submitted for Prac01
 */
public class FileHandler 
{
	/**
	 * NAME: read
	 * IMPORT: inFilename (String)
	 * EXPORT: none
	 * PURPOSE: Read a file, processing each line one at a time
	 */
	public static void read(String inFilename)
	{
		FileInputStream stream = null;
		InputStreamReader reader;
		BufferedReader buff;
		String line;
		try
		{
			stream = new FileInputStream(inFilename);
			reader = new InputStreamReader(stream);
			buff = new BufferedReader(reader);

			line = buff.readLine();
			while(line != null)
			{
				ObjectHandler.createObject(line);
				line = buff.readLine();
			}
			stream.close();
			System.out.println("\nData loaded successfully!");
		}
		catch(IOException e)
		{
			if(stream != null)
			{
				try
				{
					stream.close();
				}
				catch(IOException e2)
				{

				}
			}
			System.out.println("\nError processing file: " + e.getMessage());
		}
	}

	/**
	 * NAME: write 
	 * IMPORT: inString (String)
	 * EXPORT: none
	 * PURPOSE: Write a string to a file with a unique name
	 */
	public static String write(String inString)
	{
		Date date = new Date();
		String sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		String filename = new File("Player-Search-" + sdf + ".txt").getAbsolutePath();
		FileOutputStream stream = null;
		PrintWriter pw;
		try
		{
			stream = new FileOutputStream(filename, true);
			pw = new PrintWriter(stream);
			
			pw.println(inString + "\n");
			pw.close();
			stream.close();
		}
		catch(IOException e)
		{
			if(stream != null)
			{
				try
				{
					stream.close();
				}
				catch(IOException e2)
				{

				}
			}
			System.out.println("Error processing file: " + e.getMessage());
		}
		return filename;
	}

	/**
	 * NAME: removeComma
	 * IMPORT: inString (String)
	 * EXPORT: commaRemoved (String Array)
	 * PURPOSE: Remove all commas from a String
	 */
	public static String[] removeComma(String inString)
	{
		String [] commaRemoved = inString.split(",");
		
		return commaRemoved;
	}

	/**
	 * NAME: removeColon 
	 * IMPORT: inString (String)
	 * EXPORT: colonRemoved (String Array)
	 * PURPOSE: Remove all colons from a String
	 */
	public static String[] removeColon(String inString)
	{
		String [] colonRemoved = inString.split(":");
		
		return colonRemoved;
	}
}
