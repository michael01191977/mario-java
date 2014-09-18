import java.util.*;
import java.io.*;

public class Mario
{
    static int MAXIMUM_NUMBER_OF_PYRAMID_ROWS = 23;
    static int MINIMUM_NUMBER_OF_BLOCKS = 2;
    static char SPACE = ' ';
    static char BRICK = '#';
    static String FILENAME = "mario.txt";
    
    private File outputFile;

    public Mario(){};
    
    public void assemblePyramid()
    {
       int pyramidHeight = promptUserForHeight();
       char pyramidOutput = promptUserForOutputType();
       printAllPyramidRows(pyramidHeight, pyramidOutput);
       System.out.println("Pyramid has been printed.");
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
    
    private char promptUserForOutputType()
    {
        char selectedOutput;
        do
        {
            System.out.print("Output (c for Console or f for File): ");
            Scanner userInput = new Scanner(System.in);
            selectedOutput = userInput.next().charAt(0);
        } while(selectedOutput != 'c' && selectedOutput != 'f');
        return selectedOutput;
    }
    
    private void printAllPyramidRows(int height, char outputType)
    {
       if(outputType == 'f')
       {
           prepareOuputFile();
       }
       
       for(int numberOfSpaces = height + 1 - MINIMUM_NUMBER_OF_BLOCKS, numberOfBlocks = MINIMUM_NUMBER_OF_BLOCKS; numberOfBlocks <= height + 1;  numberOfSpaces--, numberOfBlocks++)
       {
           StringBuilder pyramidRow = new StringBuilder();
           pyramidRow.append(addBlockToPyramidRow(numberOfSpaces, SPACE));
           pyramidRow.append(addBlockToPyramidRow(numberOfBlocks, BRICK));
           printPyramidRow(outputType, pyramidRow.toString());
       }
    }
    
    private void prepareOuputFile()
    {
        File currentOutputFile = new File(FILENAME);
        if(currentOutputFile.exists())
        {
            currentOutputFile.delete();          
        }
        outputFile = new File(FILENAME);
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
    
    private void printPyramidRow(char outputType, String pyramidRow)
    {
        switch(outputType)
           {
               case 'c':
                    System.out.println(pyramidRow);
                    break;
               case 'f':
                    printToOuputFile(pyramidRow);
                    break;
           }
    }
        
    private void printToOuputFile(String row) 
    {
        try
        {
            FileWriter fileWriter = new FileWriter(outputFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(row);
            fileWriter.close();
        }
        catch(IOException e)
        {
            String fileWriterException = e.toString();
            System.out.println(fileWriterException);
        }  
    }
}