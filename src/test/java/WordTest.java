import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  // @Rule
  // public ClearRule clearRule = new ClearRule();

  // UNIT TESTING
  @Test
  public void Word_instantiatesCorrectly_true(){
    Word testWord = new Word("familiar", "noun");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_returnsSpecificWord_Familiar(){
    Word testWord = new Word("familiar", "noun");
    assertEquals("familiar", testWord.getWord());
  }

  @Test
  public void getPartOfSpeech_returnsTypeOfSpecificWord_noun(){
    Word testWord = new Word("familiar", "noun");
    assertEquals("noun", testWord.getPartOfSpeech());
  }

}
