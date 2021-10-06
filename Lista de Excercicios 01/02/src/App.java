import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho do primeiro arquivo: ");
        String fileName1 = scanner.nextLine();

        System.out.print("Digite o caminho do segundo arquivo: ");
        String fileName2 = scanner.nextLine();

        System.out.print("Digite o caminho do terceiro arquivo (Arquivo a ser gerado): ");
        String fileName3 = scanner.nextLine();

        scanner.close();

        FileConcat fileConcat = new FileConcat(fileName1, fileName2);

        try {

            fileConcat.open();

            File file = fileConcat.process(fileName3);

            System.out.println("Tempo necessário para concatenar os 2 arquivos e gerar o terceiro: "
                    + fileConcat.getTimeTaken() + " milliseconds");
            System.out.println("Tamanho do terceiro arquivo (" + fileName3 + "): " + file.length() + " bytes");

            fileConcat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
