package hw6;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AnagramsTest {

    private final String filePath = "words_alpha.txt";
    private Anagrams t = new Anagrams();

    @Test
    public void anagramsTest() throws IOException {
    	//Tests Max Entries
        t.processFile(filePath);
        String test = "[alerts, alters, artels, estral, laster, lastre, rastle, ratels, relast, resalt, salter, slater, staler, stelar, talers]";
        assertEquals(test, t.getMaxEntries().get(0).getValue().toString());
        assertEquals(15, t.getMaxEntries().get(0).getValue().size());
    }

}
