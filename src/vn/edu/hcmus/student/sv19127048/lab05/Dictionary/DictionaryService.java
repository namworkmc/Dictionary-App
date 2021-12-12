package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Dictionary<br>
 * Created by 19127048 - Nguyen Duc Nam<br>
 * Date 12/10/2021 - 8:12 PM<br>
 * Description: JDK16<br>
 */
public class DictionaryService {
  DictionaryDAO dictionaryDAO;

  HashMap<String, HashSet<String>> slangMap;
  HashMap<String, HashSet<String>> definitionMap;

  /**
   * Constructor cua service class cua Dictionary<br>
   * Khoi tao {@link DictionaryDAO}<br>
   * Load {@code slang.txt} vao {@link HashMap} slangMap va {@link HashMap} definitionMap<br>
   */
  public DictionaryService() {
    dictionaryDAO = new DictionaryDAO();

    List<HashMap<String, HashSet<String>>> hashMapList = dictionaryDAO.loadSlangAndDefinitionsMap();
    slangMap = hashMapList.get(0);
    definitionMap = hashMapList.get(1);
  }

  /**
   * Add definition vao slang aka override slang da ton tai
   * @param newSlangWord slang word moi
   * @param newDefinition definition moi
   */
  public void addNewSlangWord(String newSlangWord, String newDefinition) {
    slangMap.put(newSlangWord, new HashSet<>(Collections.singleton(newDefinition)));
  }

  /**
   * Add them definition vao slang word da ton tai
   * @param slangWord slang word da ton tai
   * @param newDefinition definition moi
   */
  public void addNewDefinition(String slangWord, String newDefinition) {
    HashSet<String> definitionSet = slangMap.get(slangWord);
    definitionSet.add(newDefinition);
  }

  /**
   * Lay tat ca cac definition cua slang word
   *
   * @param slangWord slang word
   * @return list cac definition
   */
  public HashSet<String> getDefinitionsBySlangWord(String slangWord) {
    return slangMap.get(slangWord);
  }

  /**
   * Lay tat cac slang word co cung definition
   *
   * @param definition slang word
   * @return list cac slang word
   */
  public String[] getSlangWordsByDefinition(String definition) {
    String[] strs = definition.split(" ");

    HashSet<String> intersectionSet = new HashSet<>(definitionMap.get(strs[0]));
    for (int i = 1; i < strs.length; ++i) {
      intersectionSet.retainAll(definitionMap.get(strs[i]));
    }

    return intersectionSet.toArray(new String[0]);
  }

  public String[] getSlangWords() {
    return slangMap.keySet().toArray(new String[0]);
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
    if (isSlangWordExist(slangWord)) {
      HashSet<String> definitionSet = getDefinitionsBySlangWord(slangWord);
      definitionSet.remove(oldDefinition);
      definitionSet.add(newDefinition);

      return true;
    }

    return false;
  }

  /**
   * Delete 1 slang word
   * @param slangWord slang word can delete
   * @return tra ve {@code true} neu slang word do ton tai va delete thanh cong,
   * neu khong tra ve {@code false}
   */
  public Boolean deleteSlangWord(String slangWord) {
    if (isSlangWordExist(slangWord)) {
      slangMap.remove(slangWord);

      return true;
    }

    return false;
  }

  /**
   * Lay random slang word cua slangMap
   * @return random slang word
   */
  public String getRandomSlangWord() {
    Set<String> keySet = slangMap.keySet();
    return keySet.stream().skip(new Random().nextInt(keySet.size())).findFirst().orElse(null);
  }

  /**
   * Kiem tra slang do co ton tai trong dictionary hay khong
   * @param slangWord slang word
   * @return tra ve {@code true} neu ton tai, neu khong tra ve {@code false}
   */
  public Boolean isSlangWordExist(String slangWord) {
    return slangMap.containsKey(slangWord);
  }
}