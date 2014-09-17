import java.util.Scanner;
import java.util.InputMismatchException;
public class Mario
{
    static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    static char SPACE = ' ';
    static char BRICK = '#';

    public Mario(){};
    
    public void assemblePyramid()
    {
       int pyramidHeight = promptUserForHeight();
       printPyramid(pyramidHeight);
    }
    
    private int promptUserForHeight()
    {
        int numberOfPyramidRows;
        do
       {
           System.out.print("Height: ");
           Scanner userInput = new Scanner(System.in);
           try
           {
               numberOfPyramidRows = userInput.nextInt();
           }
           catch(InputMismatchException e)
           {
               numberOfPyramidRows = 0;
           }
       } while(numberOfPyramidRows <= 0 || numberOfPyramidRows > MAXIMUM_NUMBER_OF_PYRAMID_ROWS);
       return numberOfPyramidRows;
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
     
    private void printPyramid(int height)
    {
       for(int numberOfSpaces = height - MINIMUM_NUMBER_OF_BLOCKS, numberOfBlocks = MINIMUM_NUMBER_OF_BLOCKS; numberOfBlocks <= height;  numberOfSpaces--, numberOfBlocks++)
       {
           StringBuilder pyramidRow = new StringBuilder();
           pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
           pyramidRow.append(addBlockToPyramidRow(numberOfBlocks, BRICK));
           System.out.println(pyramidRow.toString());
       }
    }
}