package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.util.Collections;
import java.util.HashSet;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Dictionary<br> Created by 19127048 - Nguyen Duc Nam<br>
 * Date 12/10/2021 - 8:12 PM<br> Description: JDK16<br>
 */
public class DictionaryController {
  DictionaryService dictionaryService;

  public DictionaryController() {
    this.dictionaryService = new DictionaryService();
  }

  /**
   * Add definition vao slang aka override slang da ton tai
   * @param newSlangWord slang word moi
   * @param newDefinition definition moi
   */
  public void addNewSlangWord(String newSlangWord, String newDefinition) {
    dictionaryService.addNewSlangWord(newSlangWord, newDefinition);
  }

  /**
   * Add them definition vao slang word da ton tai
   * @param slangWord slang word da ton tai
   * @param newDefinition definition moi
   */
  public void addNewDefinition(String slangWord, String newDefinition) {
    dictionaryService.addNewDefinition(slangWord, newDefinition);
  }

  public HashSet<String> getDefinitions(String word) {
    return dictionaryService.getDefinitions(word);
  }

  public HashSet<String> getSlangWords(String word) {
    return dictionaryService.getSlangWords(word);
  }
}
