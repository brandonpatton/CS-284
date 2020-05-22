package hw6;

//I pledge my honor that I have abided by the Stevens Honor System.
//Brandon Patton

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Anagrams {
    private final Integer[] primes = {2 , 3 , 5 , 7, 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 ,
            67 , 71 , 73 , 79 , 83 , 89 , 97 , 101};

    private final Character[] letters = {'a', 'b', 'c','d','e','f','g','h','i','j','k','l','m','n','o', 'p','q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};

    private Map<Character,Integer> letterTable = new HashMap<>();

    private Map<Long, ArrayList<String>> anagramTable = new HashMap<>();

    /* 
     * Constructs a lettertable
     */
    public Anagrams(){
        buildLetterTable();
    }

    /* 
     * Assigns each prime number in the given list to a letter
     */
    public void buildLetterTable(){
        for(int i=0; i <26; i++){
        letterTable.put(letters[i], primes[i]);
    }
    }
    /*
     * Adds the string put into the anagramTable
     */
    public void addWord(String string){
        Long hash = myHashCode(string);
        if (anagramTable.containsKey(hash)){
            ArrayList current = anagramTable.get(hash);
            current.add(string);
            anagramTable.put(hash,current);
        }
        else{
            ArrayList array = new ArrayList<String>();
            array.add(string);
            anagramTable.put(hash, array);
        }}

        /*
         * Calculates the HashCode of the word
         */
    public Long myHashCode(String s){
        Long curr = 1L;
            for (int i=0; i<s.length(); i++){
            curr *= letterTable.get(s.charAt(i));
        }
        return curr;
        }

    public void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream (s );
        BufferedReader br = new BufferedReader (new InputStreamReader(fstream));
        String strLine ;
        while (( strLine = br.readLine()) != null) {
             this.addWord(strLine);
        }
        br.close();
    }


    /*
     * Returns the hashcode with the most amount of anagrams
     */
    public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries(){
        ArrayList<Map.Entry<Long,ArrayList<String>>> out = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
            if (entry.getValue().size()==max){
                out.add(entry);
            } else if(entry.getValue().size() > max){
                max = entry.getValue().size();
                out.clear();
                out.add(entry);
            }
        }
        return out;
    }

    public static void main ( String [] args ) {
        Anagrams a = new Anagrams ();
        final Long startTime = System . nanoTime ();
        try {
            a.processFile ("words_alpha.txt");
        } catch ( IOException e1 ) {
            e1.printStackTrace ();
        }
        ArrayList < Map . Entry < Long , ArrayList < String > >> maxEntries = a.getMaxEntries();
        final Long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime /1000000000);
        System.out.println ("Time : "+ seconds );
        System.out.println ("List of max anagrams : "+ maxEntries );
        System.out.println(a.myHashCode("hello"));
    }



}
