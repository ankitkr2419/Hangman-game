package API;

import java.io.IOException;

public class WordReader {
    private DataReader reader;
    private String word;

    public WordReader(DataReader reader) {
        this.reader = reader;
    }

    public String getWord() {
        return word;
    }

    public void load() {
        try {
            this.word = this.reader.read();
        } catch (IOException streamReadException) {
            streamReadException.printStackTrace();
        }
    }
}
