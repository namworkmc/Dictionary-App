package vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/27/2021 - 4:51 PM<br> Description: JDK16<br>
 */
public class OnThisDaySlangWordController {

  final private OnThisDaySlangWordService onThisDaySlangWordService;

  public OnThisDaySlangWordController() {
    this.onThisDaySlangWordService = new OnThisDaySlangWordService();
  }

  /**
   * Doc log tu {@code log.txt} vao de kiem tra thoi gian giu cac ngay
   *
   * @return Collection ngay va slang word. Phan tu dau la ngay, phan tu thu 2 la slang word
   */
  public ArrayList<Serializable> readLog() {
    return onThisDaySlangWordService.readLog();
  }
}
