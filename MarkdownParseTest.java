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
    public void testGetLinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-thing.html"), 
            MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), 
            MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of(), 
            MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of(), 
            MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testGetLinks5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of(), 
            MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testGetLinks6() throws IOException {
        Path fileName = Path.of("test-file6.md");
        String contentOfTest = Files.readString(fileName);
        assertEquals(List.of("page.com"), 
            MarkdownParse.getLinks(contentOfTest));
    }
}
