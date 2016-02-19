import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  // UNIT TESTING
  @Test
  public void Definition_instantiatesCorrectly_true(){
    Definition testDefinition = new Definition("a member of the household of a high official", "noun");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_returnsSpecificDefinition_Familiar(){
    Definition testDefinition = new Definition("a member of the household of a high official", "noun");
    assertEquals("a member of the household of a high official", testDefinition.getDefinition());
  }

  @Test
  public void getPartOfSpeech_returnsTypeOfSpecificDefinition_noun(){
    Definition testDefinition = new Definition("a member of the household of a high official", "noun");
    assertEquals("noun", testDefinition.getPartOfSpeech());
  }

  @Test
  public void getID_returnsUniqueIDOfSpecificDefinition_true(){
    Definition testDefinition = new Definition("a member of the household of a high official", "noun");
    Definition testDefinition2 = new Definition("one who is well acquainted with something", "noun");
    Definition testDefinition3 = new Definition("frequently seen or experienced", "adjective");
    Definition testDefinition4 = new Definition("possibly known but not clearly remembered", "adjective");
    assertEquals(3, testDefinition3.getID());
  }

}
