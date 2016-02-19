public class Word{
  private String mWord;
  private String mPartOfSpeech;

  public Word(String newWord, String newPartOfSpeech) {
    mWord = newWord;
    mPartOfSpeech = newPartOfSpeech;
  }

  public String getWord() {
    return mWord;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }
}
