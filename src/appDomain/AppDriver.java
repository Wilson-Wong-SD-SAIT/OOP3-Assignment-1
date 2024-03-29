package appDomain;

import manager.CommandManager;
import manager.IputManager;
import manager.SortManager;
import manager.OutputManager;

public class AppDriver
{
	public static void main( String[] args )
	{
		// parse command line arguments: fileNmae, compareType, sortType
		CommandManager cm = new CommandManager(args);
		
		// create Shape[] Array based on fileNmae
		new IputManager(cm);
		
		// sort Shape[] Array based on compareType, sortType
		Object outputList[] = new SortManager(cm).output();
		
		String sortClass = (String)outputList[0];
		String compareMethod = (String)outputList[1];
		String compareParameter = (String)outputList[2];
		long start = (Long)outputList[3];
		long stop = (Long)outputList[4];
		
		// output benchmark and sorted values
		new OutputManager(cm, sortClass, compareMethod, compareParameter, start, stop);

		
		
		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests
		
		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		
		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String
		
	}
}
