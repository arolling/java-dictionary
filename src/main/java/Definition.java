import java.util.*;

public class Definition implements Comparable<Definition> {
  private String mDefinition;
  private String mPartOfSpeech;
  private int mID;
  private static int counter = 1;

  @Override
  public int compareTo(Definition other) {
    return mPartOfSpeech.compareTo(other.mPartOfSpeech);
  }


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
