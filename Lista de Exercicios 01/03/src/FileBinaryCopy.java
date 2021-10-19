import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBinaryCopy {

    private String originFileName;
    private InputStream inputOrigin;

    private Long timeTaken;

    public FileBinaryCopy(String originFileName) {
        this.originFileName = originFileName;
        this.timeTaken = 0L;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public Long getTimeTaken() {
        return timeTaken;
    }

    public void open() throws FileNotFoundException {
        this.inputOrigin = new FileInputStream(this.originFileName);
    }

    public void close() throws IOException {
        if (this.inputOrigin != null) {
            this.inputOrigin.close();
            this.inputOrigin = null;
        }
    }

    public File process(String destinationFileName) throws FileNotFoundException, IOException {

        if (this.inputOrigin == null)
            throw new IOException("Arquivo (" + this.originFileName + ") não foi carregado.");

        Long startTime = System.currentTimeMillis();

        OutputStream output = new FileOutputStream(destinationFileName);

        int x;
        while ((x = this.inputOrigin.read()) != -1) {
            output.write(x);
        }

        output.close();

        this.timeTaken = System.currentTimeMillis() - startTime;

        return new File(destinationFileName);
    }

}
