import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileConcat {

    private String fileName1, fileName2;

    private PrintStream stream = null;

    private InputStream file1 = null, file2 = null;

    private Scanner scanner1 = null, scanner2 = null;

    private Long timeTaken;

    public FileConcat(String fileName1, String fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        this.timeTaken = 0L;
    }

    public String getFileName1() {
        return fileName1;
    }

    public String getFileName2() {
        return fileName2;
    }

    public Long getTimeTaken() {
        return timeTaken;
    }

    /** Caso seja bem sucedido, ele retorna a cópia */
    public File process(String fileName) throws FileNotFoundException, IOException {

        if (this.file1 == null) {
            throw new IOException("O arquivo (" + this.fileName1 + ") não foi iniciado.");
        }

        if (this.file2 == null) {
            throw new IOException("O arquivo (" + this.fileName2 + ") não foi iniciado.");
        }

        if (this.scanner1 == null || this.scanner2 == null) {
            throw new IOException("Os scanners não foram iniciados!");
        }

        this.stream = new PrintStream(fileName);
        Long startTime = System.currentTimeMillis();

        String line1, line2;

        while (this.scanner1.hasNextLine()) {
            line1 = this.scanner1.nextLine();
            this.stream.println(line1);
        }

        while (this.scanner2.hasNextLine()) {
            line2 = this.scanner2.nextLine();
            this.stream.println(line2);
        }

        this.timeTaken = System.currentTimeMillis() - startTime;

        this.stream.close();

        return new File(fileName);
    }

    public void open() throws FileNotFoundException, IOException {

        this.file1 = new FileInputStream(this.fileName1);
        this.file2 = new FileInputStream(this.fileName2);
        this.scanner1 = new Scanner(this.file1);
        this.scanner2 = new Scanner(this.file2);
    }

    public void close() throws FileNotFoundException, IOException {
        if (this.file1 != null) {
            this.file1.close();
            this.file1 = null;
        }

        if (this.file2 != null) {
            this.file2.close();
            this.file2 = null;
        }

        if (this.scanner1 != null) {
            this.scanner1.close();
            this.scanner1 = null;
        }

        if (this.scanner2 != null) {
            this.scanner2.close();
            this.scanner2 = null;
        }
    }

}
