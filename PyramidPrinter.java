package marioOutput;

public class PyramidPrinter {
	
	static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    static char SPACE = ' ';
    static char BRICK = '#';
    
    private StringBuilder pyramidRow;

	public String createPyramidRow(int numberOfSpaces, int numberOfBlocks)
    {       
    	pyramidRow = new StringBuilder();
        pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
        pyramidRow.append(addBlockToPyramidRow(numberOfBlocks, BRICK));
        return toString();
        
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
    
    public java.lang.String toString()
    {	
    	return "1" + pyramidRow.toString();
    }
}
