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
        assertEquals(List.of(), MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contentOfTest = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("`google.com");
        expectedLinks.add("google.com");
        expectedLinks.add("ucsd.edu");
        assertEquals(expectedLinks, MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contentOfTest = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("a.com");
        expectedLinks.add("a.com(())");
        expectedLinks.add("example.com");
        assertEquals(expectedLinks, MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contentOfTest = Files.readString(fileName);
        ArrayList<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://www.twitter.com");
        expectedLinks.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        expectedLinks.add("https://cse.ucsd.edu/");
        assertEquals(expectedLinks, MarkdownParse.getLinks(contentOfTest));
    }

    @Test
    public void testSnippet1Reviewed() throws IOException{
        Path fileName = Path.of("snippet1.md"); 
        String content = Files.readString(fileName);
        String[] split = content.split("\n");
        ArrayList<String> links = new ArrayList<String>();
        for(String s: split){
            String link = MarkdownParseReview.getLinks(s);
            if(link != null && MarkdownParseReview.isValidLink(link)){
                links.add(MarkdownParseReview.getLinks(s));
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        res.add("'google.com");
        res.add("google.com");
        res.add("ucsd.edu");
        assertEquals(res, links);
    }

    @Test
    public void testSnippet2Reviewed() throws IOException{
        Path fileName = Path.of("snippet2.md"); 
        String content = Files.readString(fileName);
        String[] split = content.split("\n");
        ArrayList<String> links = new ArrayList<String>();
        for(String s: split){
            String link = MarkdownParseReview.getLinks(s);
            if(link != null && MarkdownParseReview.isValidLink(link)){
                links.add(MarkdownParseReview.getLinks(s));
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        res.add("a.com");
        res.add("a.com((");
        res.add("example.com");
        assertEquals(res, links);
    }

    @Test
    public void testSnippet3Reviewed() throws Exception{
        Path fileName = Path.of("snippet3.md"); 
        String content = Files.readString(fileName);
        String[] split = content.split("\n");
        ArrayList<String> links = new ArrayList<String>();
        for(String s: split){
            String link = MarkdownParseReview.getLinks(s);
            if(link != null && MarkdownParseReview.isValidLink(link)){
                links.add(MarkdownParseReview.getLinks(s));
            }
        }

        ArrayList<String> res = new ArrayList<String>();
        res.add("https://www.twitter.com");
        res.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        res.add("https://cse.ucsd.edu/");
        assertEquals(res, links);

    }


}
