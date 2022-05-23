//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseReview{

    public static boolean isValidLink(String link){
        return link.indexOf(".") != -1;
    }
    public static String getLinks(String markdown) {
        String toReturn = "";
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int exclamation = markdown.indexOf("!");
            int openBracket = markdown.indexOf("[", currentIndex);
            if(exclamation < openBracket && exclamation != -1){
                break;
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            if(openBracket == closeBracket - 1){
                break;
            }
            int openParen = markdown.indexOf("(", closeBracket);
            if(openParen - closeBracket != 1){
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }
            toReturn = markdown.substring(openParen + 1, closeParen);
            currentIndex = closeParen + 1;
        }
        if(toReturn.length() > 0){
            return toReturn;
        }else{
            return null;
        }
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        String[] split = content.split("\n");
        ArrayList<String> links = new ArrayList<String>();
        for(String s: split){
            String link = getLinks(s);
            if(link != null && isValidLink(link)){
                links.add(getLinks(s));
            }
        }
	    System.out.println(links);
    }
}