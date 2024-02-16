package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import shapes.Shape;

public class IputManager 
{
	
	public IputManager(CommandManager cm) {
		File inputFile = new File( cm.getFileNmae());
		Scanner input = null;
		int arrayPos = 0;

		try
		{
			input = new Scanner( inputFile );
			cm.setShapes( new Shape[Integer.parseInt(input.next())] );
			
			while( input.hasNext() )
			{
				// obtain 3 arguments inside line
				String shape = input.next();
				
				double height = input.nextDouble();

				double radius = input.nextDouble();
				
				// insert object created by 3 arguments into sm Array
				String className = "shapes." + shape;
				Class<?> cls = Class.forName( className );
				
				Class<?> paramTypes[] = new Class[2];
				paramTypes[0] = Double.TYPE;
				paramTypes[1] = Double.TYPE;

				Constructor<?> ct = cls.getConstructor( paramTypes );

				Object argList[] = new Object[2];
				argList[0] = height;
				argList[1] = radius;

				cm.getShapes()[arrayPos] = (Shape) ct.newInstance( argList );
				

				arrayPos++;
			}
		}
		catch( FileNotFoundException e )
		{
			System.out.println( "Invalid argument for fileNmae" );
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		} 
		catch (SecurityException e) {
			e.printStackTrace();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
