import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileKeywordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();

        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found: " + fileName);
            scanner.close();
            return;
        }

        boolean found = false;
        int lineNumber = 0;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                lineNumber++;
                String line = fileScanner.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                    System.out.println("Keyword found on line " + lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file: " + fileName);
            scanner.close();
            return;
        }

        if (!found) {
            System.out.println("Keyword not found in file.");
        }
        scanner.close();
    }
}
