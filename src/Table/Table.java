package Table;
import java.util.ArrayList;

/**
 * A Table that stores information.
 */
public class Table
{
	public static final int MAX_COLUMN = 3;
	ArrayList<ArrayList<String>> tableRow;
	
	/**
	 * Constructs an empty Table object.
	 */
	public Table()
	{
		this.tableRow = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * Adds a line of information to the table.
	 * @param line Information to be added to table.
	 */
	public void addLine(String line)
	{
		ArrayList<String> newLine = new ArrayList<String>();
		String first, second, third, quote;
		if(line.contains("\""))
		{
			if(line.contains("\","))
			{
				first = line.substring(line.indexOf("\"")+1, line.indexOf("\",")).trim();
				if(first.contains("\"\""))
				{
					String old = first.substring(first.indexOf("\"\""), first.lastIndexOf("\"\"")+2);
					quote = first.substring(first.indexOf("\"\"")+1, first.lastIndexOf("\"\"")+1);
					first = first.replaceFirst(old, quote);
					//System.out.print(first);
				}
			}
			else if(line.contains("\"\""))
			{
				first = line.substring( 0, line.indexOf(",")).trim();
				String old = first.substring(first.indexOf("\"\""), first.lastIndexOf("\"\"")+2);
				quote = first.substring(first.indexOf("\"\"")+1, first.lastIndexOf("\"\"")+1);
				first = first.replaceFirst(old, quote);
			}
			else first = "error";
		}
		else
			first = line.substring( 0, line.indexOf(",")).trim();
		second = line.substring(line.indexOf(",")+1, line.lastIndexOf(",")).trim();
		third = line.substring(line.lastIndexOf(",")+1, line.length()).trim();
		newLine.add(first);
		newLine.add(second);
		newLine.add(third);
		this.tableRow.add(newLine);
	}
	
	/**
	 * Retrieves data in given row and column in table.
	 * @param row Row in table.
	 * @param column Column in table.
	 * @return Data in given table location.
	 */
	public String getEntry(int row, int column)
	{
		return this.tableRow.get(row).get(column);
	}
	
	/**
	 * Returns number of rows.
	 * @return Number of rows.
	 */
	public int getRows()
	{
		return this.tableRow.size();
	}
	
	/**
	 * Returns number of columns.
	 * @return number of columns.
	 */
	public int getColumns()
	{
		return Table.MAX_COLUMN;
	}
}
