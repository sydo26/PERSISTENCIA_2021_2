
public class App {
    public static void main(String[] args) throws Exception {
        PropertiesManager p = new PropertiesManager("config.properties");

        String fileName = args.length == 1 ? args[0] : "resources/file.txt";

        p.load();

        int linha_inicial = Integer.valueOf(p.get("linha_inicial"));
        int linha_final = Integer.valueOf(p.get("linha_final"));

        System.out.println("Linha inicial: " + linha_inicial);
        System.out.println("Linha final: " + linha_final);

        FileScanner fs = new FileScanner(fileName);

        fs.open();

        String line;
        while ((line = fs.readLine()) != null) {
            if (fs.getCurrentLine() > linha_final)
                break;

            if (fs.getCurrentLine() >= linha_inicial) {
                System.out.println(line);
            }
        }

        fs.close();
    }
}
