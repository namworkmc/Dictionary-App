package vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/12/2021 - 12:06 PM<br> Description: JDK16<br>
 */
public class DictionaryHistoryService {
  DictionaryHistoryDAO dictionaryHistoryDAO;

  DictionaryHistoryService() {
    dictionaryHistoryDAO = new DictionaryHistoryDAO();
  }

  public String[][] getHistory() {
    ArrayList<String> history = dictionaryHistoryDAO.getHistory();
    int size = history.size();
    String[][] strings = new String[size][];
    for (int i = 0; i < size; ++i) {
      strings[i] = new String[] {history.get(i)};
    }
    return strings;
  }

  /**
   * Ghi lich su tim kiem vao file .txt
   * @param searchWord search word
   */
  public void writeSearchHistory(String searchWord) {
    if (!searchWord.isBlank()) {
      dictionaryHistoryDAO.writeSearchHistory(searchWord);
    }
  }
}
