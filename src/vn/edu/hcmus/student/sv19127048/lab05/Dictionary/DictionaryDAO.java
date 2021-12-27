package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Dictionary<br> Created by 19127048 - Nguyen Duc Nam<br>
 * Date 12/10/2021 - 8:12 PM<br> Description: JDK16<br>
 */
public class DictionaryDAO {

  private HashMap<String, HashSet<String>> slangMap;
  private HashMap<String, HashSet<String>> definitionMap;

  public DictionaryDAO() {
    loadSlangAndDefinitionsMap();
  }

  /**
   * Lay slang tu slang.txt duoi dang {@link HashMap}
   * @return slang - definition dang {@link HashMap}
   */
  public HashMap<String, HashSet<String>> getSlangMap() {
    return slangMap;
  }

  /**
   * Save slang map duoi dang binary
   */
  public void saveSlangMap(HashMap<String, HashSet<String>> slangMap) {
    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("slang.dat"));
      objectOutputStream.writeObject(slangMap);
      objectOutputStream.flush();
      objectOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load slang map o dang binary tu {@code slang.dat} vao {@link HashMap} object
   *
   * @return {@link HashMap} slang map co key la String, Value la {@link HashSet}
   */
  public HashMap<String, HashSet<String>> loadSlangMap() {
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("slang.dat"));
      slangMap = (HashMap<String, HashSet<String>>) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return slangMap;
  }

  /**
   * Lay slang tu slang.txt duoi dang {@link HashMap}
   * @return slang - definition dang {@link HashMap}
   */
  public HashMap<String, HashSet<String>> getDefinitionMap() {
    return definitionMap;
  }

  /**
   * Save definition map duoi dang binary
   * @param definitionMap definition map
   */
  public void saveDefinitionMap(HashMap<String, HashSet<String>> definitionMap) {
    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("definition.dat"));
      objectOutputStream.writeObject(definitionMap);
      objectOutputStream.flush();
      objectOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load definition map o dang binary tu {@code definition.dat} vao {@link HashMap} object
   *
   * @return {@link HashMap} slang map co key la String, Value la {@link HashSet}
   */
  public HashMap<String, HashSet<String>> loadDefinitionMap() {
    try {
      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("definition.dat"));
      definitionMap = (HashMap<String, HashSet<String>>) objectInputStream.readObject();
      objectInputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return definitionMap;
  }

  /**
   * Restore dictionary
   */
  public void restoreDefaultDictionary() {
    loadSlangAndDefinitionsMap();
  }

  /**
   * Load {@code "slang.txt"} vao {@link HashMap}
   */
  private void loadSlangAndDefinitionsMap() {
    BufferedReader bufferedReader = null;

    String line;
    HashSet<String> definitionSet;
    HashSet<String> slangSet;

    slangMap = new HashMap<>();
    definitionMap = new HashMap<>();
    try {
      bufferedReader = new BufferedReader(new FileReader("slang.txt"));

      while ((line = bufferedReader.readLine()) != null) {
        // Split slang va meaning
        String[] SlangMeaning = line.split("`");
        String slang = SlangMeaning[0];
        String meaning = SlangMeaning[1];

        String[] definitions = meaning.split("\\| ");
        // Map tung definition vao slangMap
        /*
         * Key: slang
         * Value: definition
         */
        // Xet truong hop co 1 definition
        if (definitions.length == 1) {
          // Slang co nhieu hon 1 definition
          if (slangMap.containsKey(slang)) {
            definitionSet = slangMap.get(slang);
            definitionSet.add(meaning);
          } else {  // Slang co 1 definition
            definitionSet = new HashSet<>();
            definitionSet.add(meaning);
            slangMap.put(slang, definitionSet);
          }
        } else {  // Xet truong hop co nhieu hon 1 definition
          // Slang co nhieu hon 1 definition
          if (slangMap.containsKey(slang)) {
            definitionSet = slangMap.get(slang);
            definitionSet.addAll(Arrays.asList(definitions));
          } else { // Slang co 1 definition
            definitionSet = new HashSet<>(Arrays.asList(definitions));
            slangMap.put(slang, definitionSet);
          }
        }

        // Map tung slang vao tung tu le trong definition
        /*
         * Key: definition
         * Value: slang
         */
        for (String definition : definitions) {
          // Split 1 tu dai ra thanh tung tu con. Vi du: "Thank You" -> "Thank" "You"
          String[] childDefinition = definition.split(" ");

          // Map tung slang vao tung tu con
          for (String child: childDefinition) {
            // Definition co nhieu hon 1 slang
            if (definitionMap.containsKey(child)) {
              slangSet = definitionMap.get(child);
              slangSet.add(slang);
            } else {  // Definition co 1 slang
              slangSet = new HashSet<>();
              slangSet.add(slang);
              definitionMap.put(child, slangSet);
            }
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
