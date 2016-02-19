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
  public void getWord_returnsSpecificWordString_Familiar(){
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

  @Test
  public void find_getsSpecificWordObject_familiar(){
    Word testWord = new Word("and");
    Word testWord2 = new Word("familiar");
    Word testWord3 = new Word("angels");
    Word testWord4 = new Word("gambler");
    assertEquals(testWord3, Word.find(3));
  }

  @Test
  public void addDefinition_addsDefinitionObjectToSpecificWord_true(){
    Word testWord = new Word("and");
    Word testWord2 = new Word("familiar");
    Word testWord3 = new Word("angels");
    Word testWord4 = new Word("gambler");
    Definition testDefinition = new Definition("a member of the household of a high official", "noun");
    Definition testDefinition2 = new Definition("one who is well acquainted with something", "noun");
    Definition testDefinition3 = new Definition("frequently seen or experienced", "adjective");
    Definition testDefinition4 = new Definition("possibly known but not clearly remembered", "adjective");
    testWord2.addDefinition(testDefinition2);
    assertTrue(testWord2.allDefinitions().contains(testDefinition2));
  }
}
