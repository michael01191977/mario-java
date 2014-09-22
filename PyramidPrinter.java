package marioOuput;

public class PyramidPrinter {
	
	static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    static char SPACE = ' ';
    static char BRICK = '#';
	
	private int height;
	
	public PyramidPrinter(int height)
	{
		this.height = height;
	}
	

	
	public String createPyramidRow(int numberOfSpaces, int numberOfBlocks)
    {       
    	StringBuilder pyramidRow = new StringBuilder();
        pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
        pyramidRow.append(addBlockToPyramidRow(numberOfBlocks, BRICK));
        return pyramidRow.toString();
    }
    
    private String addBlockToPyramidRow(int countOfBlocks, char block)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countOfBlocks; i++)
        {
            sb.append(block);
        }
        return sb.toString();
    }	
}
