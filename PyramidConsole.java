package marioOutput;


public class PyramidConsole implements PyramidOutput{
	
	private String pyramidRow;
	
	public PyramidConsole(String pyramidRow)
	{
		this.pyramidRow = pyramidRow;
	};
	
	public void printPyramidRow(String pyramidRow)
	{
		this.pyramidRow = pyramidRow;
		System.out.println(toString());
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
