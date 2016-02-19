import java.util.*;


public class Word implements Comparable<Word>{
  private String mWord;
  private int mID;
  private static ArrayList<Word> allWords = new ArrayList<Word>();
  private ArrayList<Definition> mWordDefinitions;

  @Override
  public int compareTo(Word other) {
    return mWord.compareToIgnoreCase(other.mWord);
  }


  public Word(String newWord) {
    mWord = newWord;
    allWords.add(this);
    mID = allWords.size();
    mWordDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public int getID() {
    return mID;
  }

  public void addDefinition(Definition newDefinition){
    mWordDefinitions.add(newDefinition);
  }

  public ArrayList<Definition> allDefinitions() {
    return mWordDefinitions;
  }


  // All static functions below
  public static ArrayList<Word> all(){
    return allWords;
  }

  public static void clear(){
    allWords.clear();
  }

  public static Word find(int id){
    for (Word entry : allWords) {
      if (id == entry.getID()){
        return entry;
      }
    }
    return null;
  }

}
