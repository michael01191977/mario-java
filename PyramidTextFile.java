package marioOuput;

import marioOuput.*;
import java.io.*;

public class PyramidTextFile implements PyramidOutput {
	
	static int MINIMUM_NUMBER_OF_BLOCKS = 2;
	static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static char SPACE = ' ';
    static char BRICK = '#';
	static String FILENAME = "mario.txt";
	
	private File outputFile;
	private int height;
	private String pyramidRow;
	
	public PyramidTextFile(int height){
		this.height = height;		
	};
	
	public void setPyramidRow(String pyramidRow)
	{
		this.pyramidRow = pyramidRow;
	}
				
	public void printPyramidRow()
	{
		try
        {
            FileWriter fileWriter = new FileWriter(this.outputFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(this.pyramidRow);
            fileWriter.close();
        }
        catch(IOException e)
        {
            String fileWriterException = e.toString();
            System.out.println(fileWriterException);
        }  
	}

	public void prepareOutputDestination()
    {
        File currentOutputFile = new File(FILENAME);
        if(currentOutputFile.exists())
        {
            currentOutputFile.delete();          
        }
        this.outputFile = new File(FILENAME);
    }
}
