import java.util.HashMap;
import java.util.Arrays;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class ScrabbleApp {
    public static void main(String[] args) {
        staticFileLocation("/public"); //for future use
        get("/", (request, response) -> {
            HashMap <String, Integer> model = new HashMap<>();
            return new ModelAndView(model, "templates/scrabbleinput.vtl");
        }, new VelocityTemplateEngine());

        get("/scrabbleoutput", (request, response) -> {
            HashMap model = new HashMap();
            String userInput = request.queryParams("userInput").toUpperCase();
            char[] letterArray = userInput.toCharArray();

            model.put("userInput", userInput);

            HashMap <Character, Integer> scores = new HashMap<>();

            scores.put('A', 1);
            scores.put('E', 1);
            scores.put('I', 1);
            scores.put('O', 1);
            scores.put('U', 1);
            scores.put('L', 1);
            scores.put('N', 1);
            scores.put('R', 1);
            scores.put('S', 1);
            scores.put('T', 1);

            scores.put('D', 2);
            scores.put('G', 2);

            scores.put('B', 3);
            scores.put('C', 3);
            scores.put('M', 3);
            scores.put('P', 3);

          	scores.put('F', 4);
          	scores.put('H', 4);
          	scores.put('V', 4);
          	scores.put('W', 4);
          	scores.put('Y', 4);

          	scores.put('K', 5);

          	scores.put('J', 8);
          	scores.put('X', 5);

			      scores.put('Q', 10);
			      scores.put('Z', 10);

            Integer scoreKeeper = 0;

            for (char letter : letterArray){
              Integer letterValue = scores.get(letter);
              scoreKeeper += letterValue;
            }
            model.put("scoreKeeper", scoreKeeper);

            return new ModelAndView(model, "templates/scrabbleoutput.vtl");
        }, new VelocityTemplateEngine());

        }

    }
