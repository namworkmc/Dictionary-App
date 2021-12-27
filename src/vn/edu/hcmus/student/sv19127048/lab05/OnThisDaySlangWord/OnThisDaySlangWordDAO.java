package vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * vn.edu.hcmus.student.sv19127048.lab05.OnThisDaySlangWord<br> Created by 19127048 - Nguyen Duc
 * Nam<br> Date 12/27/2021 - 4:52 PM<br> Description: JDK16<br>
 */
public class OnThisDaySlangWordDAO {
  final private String filename = "log.txt";

  public OnThisDaySlangWordDAO() {
  }

  /**
   * Doc dong dau tien de lay ngay va tu slang cua ngay do len tu {@code log.txt}
   *
   * @return String ngay va slang word co format "{@code date(yyyy/MM/dd) - slang word}"
   */
  public String readLog() {
    if (Files.notExists(Path.of(filename))) {
      try {
        Files.createFile(Path.of(filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String log = bufferedReader.readLine();
        bufferedReader.close();

        return log;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  /**
   * Viet log gom ngay va slang word vao {@code log.txt}
   *
   * @param log ngay va slang word
   */
  public void writeLog(String log) {
    try {
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.write(log + "\n");
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
