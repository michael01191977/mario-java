import java.util.Scanner;
import java.util.InputMismatchException;
public class Mario
{
    static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    
    public static void main(String[] args)
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
        
       for(int numberOfSpaces = numberOfPyramidRows - MINIMUM_NUMBER_OF_BLOCKS, numberOfBlocks = MINIMUM_NUMBER_OF_BLOCKS; numberOfBlocks <= numberOfPyramidRows;  numberOfSpaces--, numberOfBlocks++)
       {
           StringBuilder pyramidRow = new StringBuilder();
           pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, ' '));
           pyramidRow.append(addBlockToPyramidRow(numberOfBlocks, '#'));
           System.out.println(pyramidRow.toString());
       }
    }
    
    private static String addBlockToPyramidRow(int countOfBlocks, char block)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countOfBlocks; i++)
        {
            sb.append(block);
        }
        return sb.toString();
    }
}