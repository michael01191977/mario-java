import java.util.*;

import marioOutput.*;

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
       Pyramid pyramid = new Pyramid(pyramidHeight, pyramidOutput);
       pyramid.printAllPyramidRows();
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
            	selectedOutput = PyramidOutputFactory.consoleOutput();
            	break;
            case 'f':
            	selectedOutput = PyramidOutputFactory.textFileOutput();
            	break;
            }
        } while(userSelection != 'c' && userSelection != 'f');
        closeUserInputScanner();
        return selectedOutput;
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