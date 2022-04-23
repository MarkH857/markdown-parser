import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.net.FileNameMap;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contentOfTest), 
            List.of("https://something.com","some-thing.html"));
    }
}
