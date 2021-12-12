package vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.DictionaryHistory<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/12/2021 - 12:06 PM<br> Description: JDK16<br>
 */
public class DictionaryHistoryController {

  DictionaryHistoryService dictionaryHistoryService;

  public DictionaryHistoryController() {
    dictionaryHistoryService = new DictionaryHistoryService();
  }

  public String[][] getHistory() {
    return dictionaryHistoryService.getHistory();
  }

  /**
   * Ghi lich su tim kiem vao file .txt
   * @param searchWord search word
   */
  public void writeSearchHistory(String searchWord) {
    dictionaryHistoryService.writeSearchHistory(searchWord);
  }
}
