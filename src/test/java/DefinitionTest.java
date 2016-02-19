import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  // @Rule
  // public ClearRule clearRule = new ClearRule();

  // UNIT TESTING
  @Test
  public void Definition_instantiatesCorrectly_true(){
    Definition testDefinition = new Definition("a member of the household of a high official");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_returnsSpecificDefinition_Familiar(){
    Definition testDefinition = new Definition("a member of the household of a high official");
    assertEquals("a member of the household of a high official", testDefinition.getDefinition());
  }



}
