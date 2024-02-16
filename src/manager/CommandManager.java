package manager;

import shapes.Shape;

public class CommandManager 
{
	private Shape[] shapes;
	private String fileNmae;
	private char compareType;
	private char sortType;

	public CommandManager(String[] args) 
	{
		// to handle three command line arguments in order-insensitive manner
		for(int i = 0; i < 3; i++) {
			// read command line of fileNmae
			if( args[i].substring(0, 2).toLowerCase().equals("-f")) 
			{	
				if(args[i].substring(2,8).toLowerCase().equals("shapes")) 
				{
					// add "res\" for "shapes..." scenario
					this.setFileNmae("res\\" + args[i].substring(2).toLowerCase());
				}
				else 
				{
					this.setFileNmae(args[i].substring(2).toLowerCase());
				}

			}
			// read command line of compareType
			else if( args[i].substring(0, 2).toLowerCase().equals("-t")) 
			{
				this.setCompareType(Character.toLowerCase(args[i].charAt(2)));
			}
			// read command line of sortType
			else if( args[i].substring(0, 2).toLowerCase().equals("-v")) 
			{
				this.setSortType(Character.toLowerCase(args[i].charAt(2)));
			}
			// invalid argument
			else 
			{
				System.out.println( "Invalid command line argument" );
				System.exit(0);
			}
		}
	}

	public Shape[] getShapes() {
		return shapes;
	}

	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}

	public String getFileNmae() {
		return fileNmae;
	}

	public void setFileNmae(String fileNmae) {
		this.fileNmae = fileNmae;
	}

	public char getCompareType() {
		return compareType;
	}

	public void setCompareType(char compareType) {
		this.compareType = compareType;
	}

	public char getSortType() {
		return sortType;
	}

	public void setSortType(char sortType) {
		this.sortType = sortType;
	}

}
