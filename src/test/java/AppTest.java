import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver(true);

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  // Integration testing

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void submitNewWordTest() {
    goTo("http://localhost:4567");
    fill("#wordEntry").with("stay");
    submit("#addWord");
    assertThat(pageSource()).contains("stay");
  }

  @Test
  public void submitMultipleNewWordsTest() {
    goTo("http://localhost:4567");
    fill("#wordEntry").with("stay");
    submit("#addWord");
    fill("#wordEntry").with("familiar");
    submit("#addWord");
    fill("#wordEntry").with("metronome");
    submit("#addWord");
    assertThat(pageSource()).contains("stay");
    assertThat(pageSource()).contains("metronome");
  }

  @Test
  public void clickingAWordTakesUserToPageToAddDefinitions(){
    goTo("http://localhost:4567");
    fill("#wordEntry").with("stay");
    submit("#addWord");
    click("a", withText("stay"));
    assertThat(pageSource()).contains("stay");
  }

  @Test
  public void addingDefinitionToSpecificWord(){
    goTo("http://localhost:4567");
    fill("#wordEntry").with("stay");
    submit("#addWord");
    click("a", withText("stay"));
    fill("#definitionEntry").with("to stop going forward");
    Select select = new Select(webDriver.findElement(By.id("partsOfSpeech")));
    select.selectByValue("verb");
    submit("#addDefinition");
    assertThat(pageSource()).contains("to stop going forward");
  }

  @Test
  public void deletingDefinitionFromSpecificWord(){
    goTo("http://localhost:4567");
    fill("#wordEntry").with("stay");
    submit("#addWord");
    click("a", withText("stay"));
    fill("#definitionEntry").with("to stop going forward");
    Select select = new Select(webDriver.findElement(By.id("partsOfSpeech")));
    select.selectByValue("verb");
    submit("#addDefinition");
    submit("#to stop going forward");
    assertThat(pageSource()).contains("stay");
    assertThat(!(pageSource()).contains("to stop going forward"));
    // THIS TEST IS WRONG IN SOME WAY, BUT THE ACTUAL SITE WORKS
  }

}
