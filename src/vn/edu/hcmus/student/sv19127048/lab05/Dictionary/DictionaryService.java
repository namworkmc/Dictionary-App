package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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


  public DictionaryService() {
    dictionaryDAO = new DictionaryDAO();

    List<HashMap<String, HashSet<String>>> hashMapList = dictionaryDAO.loadSlangAndDefinitionsMap();
    slangMap = hashMapList.get(0);
    definitionMap = hashMapList.get(1);
  }

  public void addDefinitions(String word, String newDefinition) {
    HashSet<String> definitions = slangMap.get(word);
    definitions.add(newDefinition);
  }

  public HashSet<String> getDefinitions(String word) {
    return slangMap.get(word);
  }

  /**
   * Add definition vao slang
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
    HashSet<String> defitionSet = slangMap.get(slangWord);
    defitionSet.add(newDefinition);
  }

  public HashSet<String> getSlangs(String word) {
    return definitionMap.get(word);
  }

  public Boolean isSlangExisted(String word) {
    return slangMap.containsKey(word);
  }
}
