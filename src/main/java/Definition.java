
public class Definition {
  private String mDefinition;
  private String mPartOfSpeech;
  private int mID;
  private static int counter = 1;

  public Definition(String newDefinition, String newPartOfSpeech) {
    mDefinition = newDefinition;
    mPartOfSpeech = newPartOfSpeech;
    mID = counter;
    counter++;
  }

  public String getDefinition() {
    return mDefinition;
  }

  public String getPartOfSpeech() {
    return mPartOfSpeech;
  }

  public int getID() {
    return mID;
  }

  public static void clear(){
    counter = 1;
  }
}
