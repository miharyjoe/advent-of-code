import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class event1 {
  public event1() {
  }

  /* Code to read file in java */
  public void readFile() {
    try {
      File file = new File("src/input.txt");
      Scanner sc = new Scanner(file);

      File outputFile = new File("src/output.txt");
      FileWriter writer = new FileWriter(outputFile);


      while (sc.hasNextLine()) {
       String result = calibration(sc.nextLine());
       int intValue = 0;

        if(result.length() == 1){
          result = result + result;
          intValue = Integer.parseInt(result);
        } else if (result.length() == 2) {
          intValue = Integer.parseInt(result);
        }else {
          int sum = 0;
          for (int i = 0; i < result.length(); i++) {
            int digit = Character.getNumericValue(result.charAt(i));
            sum += digit;
          }
          intValue = sum;
        }
        writer.write(intValue + "\n");
        System.out.println(intValue);
      }
      sc.close();
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String calibration(String line){
    // Use regular expression to match digits
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(line);

    // Use a StringBuilder to concatenate matched digits
    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      result.append(matcher.group());
    }

    return result.toString();
  }
}
