package API;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import java.io.IOException;

public interface DataReader {
    public String read() throws StreamReadException, DatabindException, IOException;
}
