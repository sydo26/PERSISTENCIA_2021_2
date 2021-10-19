import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class FileScanner {
    private InputStream file = null;
    private Scanner scanner = null;
    private String fileName;
    private int currentLine;

    public FileScanner(String fileName) {
        this.fileName = fileName;
        this.currentLine = 0;
    }

    public int getCurrentLine() {
        return currentLine;
    }

    public String getFileName() {
        return fileName;
    }

    public void open() throws FileNotFoundException, IOException {
        this.file = new FileInputStream(this.fileName);
        this.scanner = new Scanner(this.file);
    }

    public void close() throws FileNotFoundException, IOException {

        if (this.scanner != null) {
            this.scanner.close();
            this.scanner = null;
        }

        if (this.file != null) {
            this.file.close();
            this.file = null;
        }

    }

    public String readLine() throws IOException {

        if (this.scanner == null) {
            throw new IOException("Scanner não iniciado");
        }

        if (!this.scanner.hasNextLine())
            return null;

        this.currentLine++;
        return this.scanner.nextLine();
    }
}
