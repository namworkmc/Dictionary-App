package vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/12/2021 - 12:07 PM<br> Description: JDK16<br>
 */
public class DictionaryHistoryDAO {

  DictionaryHistoryDAO() {}

  public ArrayList<String> getHistory() {
    ArrayList<String> history = new ArrayList<>();
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader("history.txt"));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        history.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return history;
  }

  /**
   * Ghi lich su tim kiem vao file .txt
   * @param searchWord search word
   */
  public void writeSearchHistory(String searchWord) {
    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter("history.txt", true);
      fileWriter.write(searchWord + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (fileWriter != null) {
          fileWriter.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
