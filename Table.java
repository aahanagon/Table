// William Johnson and Aahana Gondalia
// 11-04-25
import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Table {
    // Create a constructor adding an ArrayList in each index of our array
    // because apparently it's empty
    public static ArrayList[] words = new ArrayList[10];
    public static String line = "";
    public static Word word = new Word(line);
    
    public Table() {
        for (int i = 0; i < words.length; i++) {
            words[i] = new ArrayList<Word>();
        }
    }
    // Reads each line in a file, then processes each line using the Word class.
    public static void main(String[] args) {
        Table table = new Table();
        try {
            Scanner reader = new Scanner(new FileReader("words.dat"));
            do {
                line = reader.nextLine().toLowerCase();
                word = new Word(line);
                table.add(word);
            } while (reader.hasNext());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        // } catch (Exception e) {
        //     System.out.println("Something went wrong");
        // }
        System.out.println(table);
    }

    public void add(Word word) {
        int index = word.hashCode(); // the hash index for this word
        boolean isDuplicate = false;

    // loop through all words in the array at that index
        for (int i = 0; i < words[index].size(); i++) {
            if (word.equals(words[index].get(i))) { 
                isDuplicate = true;
                break; 
            }
        }

        if (!isDuplicate) {
            words[index].add(word); // only add if not a duplicate
        }
    }



    // Returns the string of the string (the string itself).
    public String toString() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += i + ": ";
            for (Object w : words[i]) {
                result += w + " ";
            }
            result += "\n";
        }
        return result;
    }
}
