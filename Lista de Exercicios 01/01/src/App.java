
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo: ");
        String fileName = scanner.nextLine();
        System.out.print("Digite a sua substring: ");
        String subString = scanner.nextLine();

        scanner.close();

        FileScanner fileScanner = new FileScanner(fileName);

        System.out.println("\nResultado:\n");

        try {
            fileScanner.open();

            String line;
            while ((line = fileScanner.readLine()) != null) {
                if (line.contains(subString))
                    System.out.println(line);
            }

            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

    }
}
