package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

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

  public HashSet<String> getDefinitions(String word) {
    return dictionaryService.getDefinitions(word);
  }

  public HashSet<String> getSlangs(String word) {
    return dictionaryService.getSlangs(word);
  }
}
