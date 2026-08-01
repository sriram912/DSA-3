import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        String searchText = "file";
        int frequency = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                frequency += countOccurrences(line, searchText);
            }

            System.out.println("Text: " + searchText);
            System.out.println("Frequency of the word: " + frequency);
        } catch (IOException e) {
            System.out.println("File not found please check the spelling");
        } catch (Exception e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private static int countOccurrences(String line, String searchText) {
        int count = 0;
        int fromIndex = 0;

        while (true) {
            int index = line.indexOf(searchText, fromIndex);
            if (index == -1) {
                break;
            }
            count++;
            fromIndex = index + searchText.length();
        }

        return count;
    }
}
