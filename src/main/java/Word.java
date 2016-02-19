import java.util.ArrayList;

public class Word{
  private String mWord;
  private int mID;
  private static ArrayList<Word> allWords = new ArrayList<Word>();


  public Word(String newWord) {
    mWord = newWord;
    allWords.add(this);
    mID = allWords.size();
  }

  public String getWord() {
    return mWord;
  }

  public int getID() {
    return mID;
  }

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
