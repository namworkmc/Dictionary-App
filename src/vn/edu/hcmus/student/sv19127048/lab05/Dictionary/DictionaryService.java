package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

    slangMap = dictionaryDAO.getSlangMap();
    definitionMap = dictionaryDAO.getDefinitionMap();
  }

  /**
   * Add definition vao slang aka override slang da ton tai
   * @param newSlangWord slang word moi
   * @param newDefinition definition moi
   */
  public void addNewSlangWord(String newSlangWord, String newDefinition) {
    // Map definition vao slang map
    slangMap.put(newSlangWord, new HashSet<>(Collections.singleton(newDefinition)));
    // Map slang word vao definition map
    definitionMap.put(newDefinition, new HashSet<>(Collections.singleton(newSlangWord)));
  }

  /**
   * Add them definition vao slang word da ton tai
   * @param slangWord slang word da ton tai
   * @param newDefinition definition moi
   */
  public void addNewDefinition(String slangWord, String newDefinition) {
    // Map definition vao slang map
    slangMap.get(slangWord).add(newDefinition);
    // Map slang word vao definition map
    definitionMap.get(newDefinition).add(slangWord);
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
   * @return tra {@link String}[] cac slang word neu definition do co ton tai
   * tra ve chuoi rong {@code ""} neu khong ton tai
   */
  public String[] getSlangWordsByDefinition(String definition) {
    String[] strs = definition.split(" ");

    HashSet<String> slangSet = definitionMap.get(strs[0]);
    if (slangSet != null) {
      HashSet<String> intersectionSet = new HashSet<>(definitionMap.get(strs[0]));
      for (int i = 1; i < strs.length; ++i) {
        intersectionSet.retainAll(definitionMap.get(strs[i]));
      }

      return intersectionSet.toArray(new String[0]);
    } else {
      return new String[] {""};
    }
  }

  /**
   * Lay tat ca cac slang word
   * @return
   */
  public String[] getSlangWords() {
    return slangMap.keySet().toArray(new String[0]);
  }

  /**
   * Update slang name
   * @param oldSlangWord slang word name cu
   * @param newSlangWord slang word name moi
   * @return {@code true} neu nhu update thanh cong nguoc lai tra ve {@code false}
   */
  public Boolean updateSlangWord(String oldSlangWord, String newSlangWord) {
    if (isSlangWordExist(oldSlangWord)) {
      // Update lai slang map
      HashSet<String> definitionSet = slangMap.get(oldSlangWord);
      slangMap.put(newSlangWord, definitionSet);
      slangMap.remove(oldSlangWord);

      // Update lai definition map
      for (String definition: definitionSet) {
        // Split definition ra tung tu le
        for (String childDefinition: definition.split(" ")) {
          definitionMap.get(childDefinition).add(newSlangWord);
          definitionMap.get(childDefinition).remove(oldSlangWord);
        }
      }

      return true;
    }
    return false;
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

      // Update lai definition map
      for (String childDefinition: oldDefinition.split(" ")) {
        definitionMap.get(childDefinition).remove(slangWord);
      }
      for (String childDefinition: newDefinition.split(" ")) {
        definitionMap.put(childDefinition, new HashSet<>(Collections.singleton(slangWord)));
      }

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
      // Lay ra definition set vua remove de remove cac slang trong definition map
      HashSet<String> removedDefinitionSet = slangMap.remove(slangWord);

      // Remove cac slang word trong definition map
      for (String definition: removedDefinitionSet) {
        // Split definition ra tung tu le
        for (String definitionChild: definition.split(" ")) {
          definitionMap.get(definitionChild).remove(slangWord);
        }
      }

      return true;
    }

    return false;
  }

  /**
   * Random slang word
   * @return random slang word
   */
  public String getRandomSlangWord() {
    Set<String> slangWords = slangMap.keySet();
    return slangWords.stream().skip(new Random().nextInt(slangWords.size())).findFirst().orElse(null);
  }

  /**
   * Random definition
   * @return random definition
   */
  public String getRandomDefinition() {
    Set<String> keySet = slangMap.keySet();
    return keySet.stream().skip(new Random().nextInt(keySet.size())).findFirst().orElse(null);
  }

  /**
   * Random definition trong do co 1 tu la definition cua slang
   * @return random definition
   */
  public String[] getRandomDefinition(String slangWord) {
    if (isSlangWordExist(slangWord)) {
      String[] definitions = new String[4];

      // Random 1 definition cua slang word
      HashSet<String> definitionSet = slangMap.get(slangWord);
      String slangDefinition = definitionSet.stream().skip(new Random().nextInt(definitionSet.size())).findFirst().orElse("");
      definitions[0] = slangDefinition;

      Set<String> slangWords = slangMap.keySet();
      for (int i = 1; i < 4; ++i) {
        // Random 1 slang word
        String randomSlang = slangWords.stream().skip(new Random().nextInt(slangWords.size())).findFirst().orElse(null);
        // Kiem tra xem slang word vua random co trung voi slang word input khong, neu co random lai
        while (slangWord.equals(randomSlang)) {
          randomSlang = slangWords.stream().skip(new Random().nextInt(slangWords.size())).findFirst().orElse(null);
        }

        definitionSet = slangMap.get(randomSlang);
        slangDefinition = definitionSet.stream().skip(new Random().nextInt(definitionSet.size())).findFirst().orElse("");

        definitions[i] = slangDefinition;
      }

      // Shuffle definitions
      Collections.shuffle(Arrays.asList(definitions));
      return definitions;
    }
    return null;
  }

  /**
   * Kiem tra slang do co ton tai trong dictionary hay khong
   * @param slangWord slang word
   * @return tra ve {@code true} neu ton tai, neu khong tra ve {@code false}
   */
  public Boolean isSlangWordExist(String slangWord) {
    return slangMap.containsKey(slangWord);
  }

  /**
   * Kiem tra nghia cua definition dung voi slang word khong
   *
   * @param slangWord slang word
   * @param definition definition
   * @return {@code true} neu dung nguoc lai {@code false}
   */
  public Boolean isDefinitionOfSlangCorrect(String slangWord, String definition) {
    return slangMap.get(slangWord).contains(definition);
  }

  /**
   * Restore lai default dictionary
   */
  public void restoreDefaultDictionary() {
    slangMap = dictionaryDAO.getSlangMap();
    definitionMap = dictionaryDAO.getDefinitionMap();
  }
}