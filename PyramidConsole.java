package marioOuput;

import marioOuput.PyramidOutput;
public class PyramidConsole implements PyramidOutput{
	
	private String pyramidRow;
	
	public PyramidConsole(){};
	
	public void setPyramidRow(String pyramidRow)
	{
		this.pyramidRow = pyramidRow;
	}
	
	public void printPyramidRow()
	{
		System.out.println(this.pyramidRow);
	}


	public void prepareOutputDestination()
	{	
		
	}


}
