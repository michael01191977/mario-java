import java.util.*;
import marioOuput.*;

public class Mario
{
    static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    static char SPACE = ' ';
    static char BRICK = '#';

    private Scanner userInputScanner;
    
    public Mario(){};
    
    public void assemblePyramid()
    {
       int pyramidHeight = promptUserForHeight();
       PyramidOutput pyramidOutput = promptUserForOutputType(pyramidHeight);
       printAllPyramidRows(pyramidHeight, pyramidOutput);
       
       System.out.println("Pyramid has been printed.");
    }
    
    private int promptUserForHeight()
    {
        int numberOfPyramidRows;
        do
       {
           System.out.print("Height: ");
           openUserInputScanner();
           try
           {
               numberOfPyramidRows = userInputScanner.nextInt();
           }
           catch(InputMismatchException e)
           {
               numberOfPyramidRows = 0;
           }
       } while(numberOfPyramidRows <= 0 || numberOfPyramidRows > MAXIMUM_NUMBER_OF_PYRAMID_ROWS);
       return numberOfPyramidRows;
    }
    
    private PyramidOutput promptUserForOutputType(int height)
    {
    	PyramidOutput selectedOutput = null;
    	char userSelection;
        do
        {
            System.out.print("Output (c for Console or f for File): ");
            userSelection = userInputScanner.next().charAt(0);
            switch(userSelection)
            {
            case 'c':
            	selectedOutput = new PyramidConsole();
            	break;
            case 'f':
            	selectedOutput = new PyramidTextFile(height);
            	break;
            }
        } while(userSelection != 'c' && userSelection != 'f');
        closeUserInputScanner();
        return selectedOutput;
    }
    
    private void printAllPyramidRows(int height, PyramidOutput outputType)
    {       

       outputType.prepareOutputDestination();

       for(int numberOfSpaces = height + 1 - MINIMUM_NUMBER_OF_BLOCKS, numberOfBricks = MINIMUM_NUMBER_OF_BLOCKS; numberOfBricks <= height + 1;  numberOfSpaces--, numberOfBricks++)
       {
           StringBuilder pyramidRow = new StringBuilder();
           pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
           pyramidRow.append(addBlockToPyramidRow(numberOfBricks, BRICK));
           outputType.setPyramidRow(pyramidRow.toString());
           outputType.printPyramidRow();
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
    
    private void openUserInputScanner()
    {
    	userInputScanner = new Scanner(System.in);
    }
    
    private void closeUserInputScanner()
    {
    	userInputScanner.close();
    }
}