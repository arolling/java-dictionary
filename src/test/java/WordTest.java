import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  // UNIT TESTING
  @Test
  public void Word_instantiatesCorrectly_true(){
    Word testWord = new Word("familiar");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_returnsSpecificWord_Familiar(){
    Word testWord = new Word("familiar");
    assertEquals("familiar", testWord.getWord());
  }

  @Test
  public void all_returnsAllWordsInMemory_true(){
    Word testWord2 = new Word("and");
    Word testWord = new Word("familiar");
    assertTrue(Word.all().contains(testWord2));
    assertTrue(Word.all().contains(testWord));
  }

  @Test
  public void clear_erasesAllCurrentWordsFromList_true(){
    Word testWord2 = new Word("and");
    Word testWord = new Word("familiar");
    Word.clear();
    assertEquals(0, Word.all().size());
  }
}
