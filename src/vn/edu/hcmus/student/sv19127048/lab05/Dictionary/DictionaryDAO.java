package vn.edu.hcmus.student.sv19127048.lab05.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.Dictionary<br> Created by 19127048 - Nguyen Duc Nam<br>
 * Date 12/10/2021 - 8:12 PM<br> Description: JDK16<br>
 */
public class DictionaryDAO {
  private BufferedReader bufferedReader;

  public DictionaryDAO() {
    try {
      bufferedReader = new BufferedReader(new FileReader("slang.txt"));
//      fileWriter = new FileWriter("test.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load {@code "slang.txt"} vao {@link HashMap}
   *
   * @return {@link HashMap} voi {@code K} la slang word va {@code V}
   * la set definitions
   */
  public List<HashMap<String, HashSet<String>>> loadSlangAndDefinitionsMap() {
    String line;
    HashSet<String> definitionSet;
    HashSet<String> slangSet;

    HashMap<String, HashSet<String>> slangMap = new HashMap<>();
    HashMap<String, HashSet<String>> definitionMap = new HashMap<>();
    try {
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
          String[] definitionChild = definition.split(" ");

          // Map tung slang vao tung tu con
          for (String child: definitionChild) {
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
    return List.of(slangMap, definitionMap);
  }
}
