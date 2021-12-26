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
   * Update slang name
   * @param oldSlangWord slang word name cu
   * @param newSlangWord slang word name moi
   * @return {@code true} neu nhu update thanh cong nguoc lai tra ve {@code false}
   */
  public Boolean updateSlangWord(String oldSlangWord, String newSlangWord) {
    return dictionaryService.updateSlangWord(oldSlangWord, newSlangWord);
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

  /**
   * Random slang word
   * @return random slang word
   */
  public String getRandomSlangWord() {
    return dictionaryService.getRandomSlangWord();
  }

  /**
   * Get random definition word
   *
   * @return random definition
   */
  public String getRandomDefinition() {
    return dictionaryService.getRandomDefinition();
  }

  public String[] getRandomSlangWords(String definition) {
    return dictionaryService.getRandomSlangWords(definition);
  }

  /**
   * Random definition trong do co 1 tu la definition cua slang
   * @return random definition
   */
  public String[] getRandomDefinitions(String slangWord) {
    return dictionaryService.getRandomDefinitions(slangWord);
  }

  /**
   * Kiem tra slang do co ton tai trong dictionary hay khong
   * @param slangWord slang word
   * @return tra ve {@code true} neu ton tai, neu khong tra ve {@code false}
   */
  public Boolean isSlangWordExist(String slangWord) {
    return dictionaryService.isSlangWordExist(slangWord);
  }

  public Boolean isDefinitionOfSlangCorrect(String slangWord, String definition) {
    return dictionaryService.isDefinitionOfSlangCorrect(slangWord, definition);
  }

  /**
   * Restore lai default dictionary
   */
  public void restoreDefaultDictionary() {
    dictionaryService.restoreDefaultDictionary();
  }
}
