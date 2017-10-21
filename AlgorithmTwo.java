package main.Java;


import java.util.ArrayList;

public class AlgorithmTwo implements AlgorithmInterface {
    int x;
    int m;
    int wordPos;
    String [] wordList;
    char [] word;
    int wordLength;
    char [][] puzzle;
    boolean wordFound;
    boolean listFound;
    private ArrayList listOfWordsFound = new ArrayList();

    /*
     * This method should initiate the word search solver given a list of words and the puzzle board.
     * When the word search solver has completed, it will return a ResultsEngine object to MainController
     */
    public ResultsEngine init(String[] listOfWords, char[][] puzzle){
        m = listOfWords.length;
        x = puzzle.length;
        wordList = listOfWords;
        this.puzzle = puzzle;
        listFound = false;
        printPuzzle();
        wordPos = 0;
        setWord(listOfWords[0]);


        //should return getData();
        return null;
    }

    public void printPuzzle(){

        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if (j == 9) {
                    System.out.println(puzzle[i][j]);
                }
                else {
                    System.out.print(puzzle[i][j]+" ");
                }
            }

        }
    }

    public int getWordLength(){ return wordLength; }

    /*
     * Set a new word in wordList to search for. Set wordLength automatically with new word.
     * Set wordFound to false when originally setting new word.
     */
    public void setWord(String aWord){
        this.word = aWord.toCharArray();
        wordLength = word.length;
        wordFound = false;
        System.out.println(word);
        findWord();

    }

    public void findWord(){
        int k = 0;
        printPuzzle();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if(puzzle[i][j] == word[k]){
                    //letter found
                    System.out.println('\n');
                    System.out.println("found at: " + puzzle[i][j] + " I: " + i + " J: " + j);
                    MyPair temp = new MyPair(i,j);
                    listOfWordsFound.add(temp);
                    if(k == wordLength-1){
                        wordFound = true;
                        nextStep();
                        break;
                    } else {
                        k++;
                    }
                    //move k to search for next letter in word
                }
            }

        }

    }

    public void nextStep(){
        wordPos++;
        if (wordPos > wordList.length-1){
            System.out.println("\n Found all words");
        }
        else{
            System.out.println("\n New Word: " + wordList[wordPos]);
            setWord(wordList[wordPos]);

        }
    }








    /*
     * This method needs to create a ResultsEngine object and return it.
     * An example has been commented out for you to see
     */
    public ResultsEngine getData() {
        //        ResultsEngine data = new ResultsEngine(foundAtIndexes, oneWordTime, allWordsTime, oneWordComparison,
        //                allWordsComparisons);
        return null;
    }

    public static void main(String[] args) {
        String[] listOfWordsFive;
        listOfWordsFive = new String[]{ "tag", "html", "osx", "java", "python"};
        GenerateWordSearch puzzle = new GenerateWordSearch(listOfWordsFive, 10);
        AlgorithmTwo k = new AlgorithmTwo();
        k.init(listOfWordsFive, puzzle.returnPuzzle());
    }


}
