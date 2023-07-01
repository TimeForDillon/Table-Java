package Table;
import java.util.Scanner;

public class TableTester
{
	public static void main(String[] args)
	{
		Table myTable = new Table();
		Scanner in = new Scanner(System.in);
		String inputAsText;
		int input = 999;
		int column=0;
		int row=0;
		
		//myTable.addLine("\"Dillon Patrick, \"\"Pickle\"\" Welsh\",1991,2121");
		
		System.out.println("This table saves Legal Names, Birth Year, and Death Year.");
		
		do
		{
			System.out.print("Please enter your data (next to continue): ");
			inputAsText = in.nextLine();
			if(!inputAsText.toUpperCase().equals("NEXT"))
			{
				myTable.addLine(inputAsText);
			}
		}while(!inputAsText.toUpperCase().equals("NEXT"));

		do
		{
			System.out.println("\rWhich row entry would you like to retrieve?");
			System.out.println("There are "+myTable.getRows()+" row entries.");
			
			do
			{
				System.out.print("Enter your selection: ");
				inputAsText = in.nextLine();
				
				if(inputAsText.contains("[a-zA-Z]+") == false)
				{
					try {
						   input = Integer.parseInt(inputAsText);
						}
						catch (NumberFormatException e)
						{
							System.out.println("That was not a number.");
							input = -999;
						}
				}
				else input = -999;
				
				if(input == -999) continue;
				else if(input<=0 || input>myTable.getRows())
				{
					System.out.println("Out of bounds.");
				}
				
			}while(input<=0 || input>myTable.getRows());
			row = input;
			
			System.out.println("\rWhich column entry would you like to retrieve?");
			System.out.println("There are "+myTable.getColumns()+" column entries.");
			
			do
			{
				System.out.print("Enter your selection: ");
				inputAsText = in.nextLine();
				
				if(inputAsText.contains("[a-zA-Z]+") == false)
				{
					try {
						   input = Integer.parseInt(inputAsText);
						}
						catch (NumberFormatException e)
						{
							System.out.println("That was not a number.");
							input = -999;
						}
				}
				else input = -999;
				
				if(input == -999) continue;
				else if(input<=0 || input>myTable.getColumns())
				{
					System.out.println("Out of bounds.");
				}
				
			}while(input<=0 || input>myTable.getColumns());
			column = input;
			
			System.out.print("\rData at row "+row+", column "+column+": ");
			System.out.println(myTable.getEntry(row-1, column-1));
			
			do
			{
				System.out.println("\rWould you like to find another entry? (y/n)");
				inputAsText = in.nextLine();
			}while(!inputAsText.toUpperCase().equals("Y") && !inputAsText.toUpperCase().equals("N"));
			
			row=0;
			column=0;
		}while(!inputAsText.toUpperCase().equals("N"));
		
		System.out.println("Thanks for using this program!");
		in.close();
	}
}

/*
Output:
This table saves Legal Names, Birth Year, and Death Year.
Please enter your data (next to continue): John Jacob Astor,1763,1848
Please enter your data (next to continue): "William Backhouse Astor, Jr.",1829,1892
Please enter your data (next to continue): "William Backhouse Astor, Jr.",1829,1892
Please enter your data (next to continue): "John Jacob ""Jakey"" Astor VI",1912,1992
Please enter your data (next to continue): next

Which row entry would you like to retrieve?
There are 4 row entries.
Enter your selection: 2

Which column entry would you like to retrieve?
There are 3 column entries.
Enter your selection: 1

Data at row 2, column 1: William Backhouse Astor, Jr.

Would you like to find another entry? (y/n)
y

Which row entry would you like to retrieve?
There are 4 row entries.
Enter your selection: 3

Which column entry would you like to retrieve?
There are 3 column entries.
Enter your selection: 1

Data at row 3, column 1: William Backhouse Astor, Jr.

Would you like to find another entry? (y/n)
y

Which row entry would you like to retrieve?
There are 4 row entries.
Enter your selection: 4

Which column entry would you like to retrieve?
There are 3 column entries.
Enter your selection: 1

Data at row 4, column 1: John Jacob "Jakey" Astor VI

Would you like to find another entry? (y/n)
n
Thanks for using this program!

 */
