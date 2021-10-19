import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo de origem: ");
        String originFileName = scanner.nextLine();

        System.out.print("Digite o caminho do arquivo de destino: ");
        String destinationFileName = scanner.nextLine();

        scanner.close();

        FileBinaryCopy binaryCopy = new FileBinaryCopy(originFileName);

        try {
            binaryCopy.open();

            binaryCopy.process(destinationFileName);
            System.out.println("Tempo necessário para concatenar os 2 arquivos e gerar o terceiro: "
                    + binaryCopy.getTimeTaken() + " milliseconds");

            binaryCopy.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
