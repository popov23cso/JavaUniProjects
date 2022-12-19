import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class StringSearch {
  public static void main(String[] args) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("test.txt")));
    Scanner sc = new Scanner(System.in);
    System.out.println("What word are you searching for: ");
    String target = sc.nextLine();
    boolean found = findWord(content, target);
    System.out.println(found == true ? "The word " + target +  " is found!" : "The word " + target + " is not in the text");
    sc.close();
  }


  public static boolean findWord(String text, String word) {
    String buff = "";
    word = word.toLowerCase();
    for (int i = 0; i < text.length(); i++) {
        char tmp = text.charAt(i);
        tmp = Character.toLowerCase(tmp);
        if (tmp == '.' || tmp == ' ' || tmp == ',' || tmp == '!' || tmp == '?') {
            buff = "";
            continue;
        }
        else {
            buff = buff + tmp;
            if (buff.equals(word)) {
                return true;
            }
        }
    }
    return false;
  }
}