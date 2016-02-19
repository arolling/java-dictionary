import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  // @Rule
  // public ClearRule clearRule = new ClearRule();

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
    Definition testDefinition = new Definition("familiar", "noun");
    assertEquals("noun", testDefinition.getPartOfSpeech());
  }

}
