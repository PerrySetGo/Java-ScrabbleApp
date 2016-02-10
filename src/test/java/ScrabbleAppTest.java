import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleAppTest {

  @Test
  public void isScoreCorrect_forinput_true() {
    ScrabbleApp testScrabbleApp = new ScrabbleApp();
    String newString = "test";
    assertEquals(4, (int) testScrabbleApp.getScrabbleScore(newString));
   }
 }
