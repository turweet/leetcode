package beginer.lunwen;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class H {
    static String src = "/Users/wangling/Desktop";

    public static void main(String[] args) throws IOException {
        List<String> alllines = Files.readAllLines(Paths.get(src + "/a.txt"));
        for (String s :
                alllines) {
            System.out.println(s);
        }
        FileWriter fw = new FileWriter(src + "/b.txt");
        for (int i = 0; i < alllines.size(); i++) {
            fw.write(putAuthorAtFirst(formatTimeInTheEnd(alllines.get(i))) + "\n");
        }
        fw.close();
    }

    public static String formatTimeInTheEnd(String s) {
        for (int i = 0; i < s.length() - 4; i++) {
            if (Character.isDigit(s.charAt(i))
                    && Character.isDigit(s.charAt(i + 1))
                    && Character.isDigit(s.charAt(i + 2))
                    && Character.isDigit(s.charAt(i + 3))) {
                return s.substring(0, i + 4);
            }
        }
        return "";
    }

    public static String putAuthorAtFirst(String s) {
        String[] strings = s.split(Pattern.quote("."));
        String result = "";
        if (strings.length >= 2) {
            result = strings[1] + "." + strings[0] + ".";
        } else {
            return s;
        }
        for (int i = 2; i < strings.length; i++) {
            result += strings[i];
        }

        for (int i = 0; i < result.length() - 2; i++) {
            if (Character.isDigit(result.charAt(i))
                    && result.charAt(i + 1) == ' ') {
                return String.valueOf(result.charAt(i)) + " " +
                        result.substring(0, i) +
                        result.substring(i + 2);
            } else if (Character.isDigit(result.charAt(i))
                    && Character.isDigit(result.charAt(i + 1))
                    && result.charAt(i + 2) == ' ') {
                return String.valueOf(result.charAt(i)) + String.valueOf(result.charAt(i + 1)) + " " +
                        result.substring(0, i) +
                        result.substring(i + 3);
            }
        }
        return result;

    }

}
