import java.util.*;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("allWords", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String wordEntry = request.queryParams("wordEntry");
      Word newWord = new Word(wordEntry);
      Collections.sort(Word.all());
      model.put("allWords", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word selectedWord = Word.find(Integer.parseInt(request.params(":id")));

      model.put("word", selectedWord);
      model.put("template", "templates/wordindex.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word selectedWord = Word.find(Integer.parseInt(request.params(":id")));

      String definitionEntry = request.queryParams("definitionEntry");
      String partOfSpeech = request.queryParams("partsOfSpeech");
      Definition newDefinition = new Definition(definitionEntry, partOfSpeech);
      selectedWord.addDefinition(newDefinition);
      Collections.sort(selectedWord.allDefinitions());
      model.put("word", selectedWord);
      model.put("template", "templates/wordindex.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
