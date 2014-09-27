import marioOutput.PyramidOutput;

public class Pyramid {
	
	static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
	static int MINIMUM_NUMBER_OF_BLOCKS = 2;
	static char SPACE = ' ';
	static char BRICK = '#';

	private int pyramidHeight;
	private PyramidOutput pyramidOutput;
	
	public Pyramid(int pyramidHeight, PyramidOutput pyramidOutput)
	{
		this.pyramidHeight = pyramidHeight;
		this.pyramidOutput = pyramidOutput;
	};
	
    public void printAllPyramidRows()
    {  
       for(int numberOfSpaces = this.pyramidHeight + 1 - MINIMUM_NUMBER_OF_BLOCKS, numberOfBricks = MINIMUM_NUMBER_OF_BLOCKS; numberOfBricks <= this.pyramidHeight + 1;  numberOfSpaces--, numberOfBricks++)
       {
           StringBuilder pyramidRow = new StringBuilder();
           pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
           pyramidRow.append(addBlockToPyramidRow(numberOfBricks, BRICK));
           this.pyramidOutput.printPyramidRow(pyramidRow.toString());
       }
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

