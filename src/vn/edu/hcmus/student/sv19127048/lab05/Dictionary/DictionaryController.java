package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

  public HashSet<String> getDefinitionsBySlangWord(String word) {
    return dictionaryService.getDefinitionsBySlangWord(word);
  }

  public String[] getSlangWordsByDefinition(String definition) {
    return dictionaryService.getSlangWordsByDefinition(definition);
  }

  public String[] getSlangWords() {
    return dictionaryService.getSlangWords();
  }

  /**
   * Update definition cua 1 slang word
   *
   * @param slangWord slang word
   * @param oldDefinition definition muon update
   * @param newDefinition definition moi
   *
   * @return neu slang word ton tai va update thanh cong tra ve {@code true},
   * con khong tra ve {@code false}
   */
  public Boolean updateSlangDefinition(String slangWord, String oldDefinition, String newDefinition) {
    return dictionaryService.updateSlangDefinition(slangWord, oldDefinition, newDefinition);
  }

  /**
   * Delete 1 slang word
   * @param slangWord slang word can delete
   * @return tra ve {@code true} neu slang word do ton tai va delete thanh cong,
   * neu khong tra ve {@code false}
   */
  public Boolean deleteSlangWord(String slangWord) {
    return dictionaryService.deleteSlangWord(slangWord);
  }

  public String getRandomSlangWord() {
    return dictionaryService.getRandomSlangWord();
  }

  /**
   * Kiem tra slang do co ton tai trong dictionary hay khong
   * @param slangWord slang word
   * @return tra ve {@code true} neu ton tai, neu khong tra ve {@code false}
   */
  public Boolean isSlangWordExist(String slangWord) {
    return dictionaryService.isSlangWordExist(slangWord);
  }


  /**
   * Restore lai default dictionary
   */
  public void restoreDefaultDictionary() {
    dictionaryService.restoreDefaultDictionary();
  }
}
