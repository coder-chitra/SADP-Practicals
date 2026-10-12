
import java.io.*;

class LowercaseReader extends FilterReader {
    protected LowercaseReader(Reader in) {
        super(in);
    }

    public int read() throws IOException {
        int ch = super.read();

        if (ch == -1)
            return -1;

        return Character.toLowerCase((char) ch);
    }

    public int read(char[] cbuf, int off, int len)
            throws IOException {
        int count = super.read(cbuf, off, len);

        if (count == -1)
            return -1;

        for (int i = off; i < off + count; i++) {
            cbuf[i] = Character.toLowerCase(cbuf[i]);
        }

        return count;
    }
}

public class LowercaseDecoratorDemo {
    public static void main(String[] args) throws IOException {
        String text = "HELLO JAVA DESIGN PATTERNS";

        try (LowercaseReader reader = new LowercaseReader(new StringReader(text))) {
            int ch;

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        }
    }
}
