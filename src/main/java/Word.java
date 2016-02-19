import java.util.ArrayList;

public class Word{
  private String mWord;
  private static ArrayList<Word> allWords = new ArrayList<Word>();


  public Word(String newWord) {
    mWord = newWord;
    allWords.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Word> all(){
    return allWords;
  }

  public static void clear(){
    allWords.clear();
  }

}
