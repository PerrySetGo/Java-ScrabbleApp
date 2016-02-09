import org.junit.*;
import static org.junit.Assert.*;

public ScrabbleAppTest {

  @Test
  public void isScoreCorrect_forinput_true() {
    ScrabbleApp testScrabbleApp = new ScrabbleApp();
    assertEquals(4, testScrabbleApp.getScabbleScore("test"));
   }
