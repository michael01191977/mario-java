package marioOutput;

import java.io.*;

public class PyramidTextFile implements PyramidOutput {
	
	static int MINIMUM_NUMBER_OF_BLOCKS = 2;
	static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static char SPACE = ' ';
    static char BRICK = '#';
	static String FILENAME = "mario.txt";
	
	private File outputFile;
	private String pyramidRow;
	
	public PyramidTextFile(String pyramidRow)
	{
		this.pyramidRow = pyramidRow;
	};

	public void printPyramidRow(String pyramidRow)
	{		
		this.pyramidRow = pyramidRow;
		this.outputFile = new File(FILENAME);
		if(isFirstRow())
		{
			prepareOutputDestination();
		}
		printToOutputDestination();
	}

	private boolean isFirstRow()
	{
		String firstRow = " ##";
		int rowLength = this.pyramidRow.length();
		return this.pyramidRow.substring(rowLength - 3, rowLength).equals(firstRow);
	}
	
	private void prepareOutputDestination()
    {
        File currentOutputFile = new File(FILENAME);
        if(currentOutputFile.exists())
        {
            currentOutputFile.delete();          
        }
        this.outputFile = new File(FILENAME);
    }
	
	private void printToOutputDestination()
	{
		try(FileWriter fileWriter = new FileWriter(this.outputFile, true))
        {
			PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(toString());
            printWriter.close();
        }
        catch(IOException e)
        {
            String fileWriterException = e.toString();
            System.out.println(fileWriterException);
        } 	
	}
	
	@Override
	public java.lang.String toString()
	{
		String proposedPyramidRow = this.pyramidRow.toString();
		for(int i = 0, strLength = proposedPyramidRow.length(); i < strLength; i++)
		{
			char proposedPyramidBlock = proposedPyramidRow.charAt(i);
			if(proposedPyramidBlock != ' ' && proposedPyramidBlock != '#')
			{
				proposedPyramidRow.replace(proposedPyramidBlock, '#');
			}
		}
		return this.pyramidRow;
	}
}