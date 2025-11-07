// William Johnson and Aahana Gondalia
// 11-04-25
import java.util.*;

public class Word {
    public String line = "";

    public Word(String line) {
        this.line = line;
    }

    // Returns the string of the string (the string itself).
    @Override
    public String toString() {
        return line;
    }


    public boolean equals(Object newWord) {
        if (newWord instanceof Word) {
            Word other = (Word) newWord;
            return this.line.equals(other.line);
        }
        return false;

    }

    // Returns an int
    public int hashCode() {
        int vowelCount = 0;
        int lineLength = 0;
        int product = 0;
        int productLast = 0;

        lineLength = line.length();
        for (int i = 0; i < line.length(); i++) {
            if (line.substring(i, i + 1).equals("a")) {
                vowelCount++;
            }
            if (line.substring(i, i + 1).equals("o")) {
                vowelCount++;
            }
            if (line.substring(i, i + 1).equals("i")) {
                vowelCount++;
            }
            if (line.substring(i, i + 1).equals("e")) {
                vowelCount++;
            }
            if (line.substring(i, i + 1).equals("u")) {
                vowelCount++;
            }
        }

        product = lineLength * vowelCount;
        productLast = product % 10;
        return productLast;
    }
}
