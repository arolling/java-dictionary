public class Definition {
  private String mDefinition;
  private String mPartOfSpeech;

  public Definition(String newDefinition, String newPartOfSpeech) {
    mDefinition = newDefinition;
    mPartOfSpeech = newPartOfSpeech;
  }

  public String getDefinition() {
    return mDefinition;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }
}
