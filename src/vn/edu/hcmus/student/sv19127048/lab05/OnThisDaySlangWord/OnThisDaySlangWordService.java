package vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import vn.edu.hcmus.student.sv19127048.lab05.Dictionary.DictionaryService;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/27/2021 - 4:52 PM<br> Description: JDK16<br>
 */
public class OnThisDaySlangWordService {
  final private OnThisDaySlangWordDAO onThisDaySlangWordDAO;
  final private DictionaryService dictionaryService;

  public OnThisDaySlangWordService() {
    this.onThisDaySlangWordDAO = new OnThisDaySlangWordDAO();
    this.dictionaryService = new DictionaryService();
  }

  /**
   * Doc log tu {@code log.txt} vao de kiem tra thoi gian giu cac ngay
   *
   * @return Collection ngay va slang word. Phan tu dau la ngay, phan tu thu 2 la slang word
   */
  public ArrayList<Serializable> readLog() {
    String log = onThisDaySlangWordDAO.readLog();

    String[] data = log.split(" - ");

    LocalDate dateInLog = LocalDate.parse(data[0]);
    String slangInLog = data[1];

    LocalDate now = LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh"));

    ArrayList<Serializable> arrayList = new ArrayList<>();
    if (dateInLog.isBefore(now)) {
      String slangWord = dictionaryService.getRandomSlangWord();
      String definition = dictionaryService.getRandomDefinitionOfSlangWord(slangWord);

      arrayList.add(now);
      arrayList.add(String.format("%s: %s", slangWord, definition));

      String newSlang = String.format("%s: %s", slangWord, definition);
      String newLog = String.format("%s - %s", now, newSlang);
      writeLog(newLog);
    } else {
      arrayList.add(dateInLog);
      arrayList.add(slangInLog);
    }

    return arrayList;
  }

  private void writeLog(String log) {
    onThisDaySlangWordDAO.writeLog(log);
  }
}
