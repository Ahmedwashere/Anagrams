import java.util.*;
import java.util.Random;
import java.io.*;



public class Anagram{

    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        ArrayList<String> words = read_words("/C://Users//HP//Documents//Fall 2022 Classes//Software Development Code//anagram_words.txt/");
        int random_word_num = random.nextInt(words.size());
        String random_word = words.get(random_word_num);
        System.out.println("The words are " + words + " \n And the random word is: " + random_word);
        // I need the size for when I loop through the
        String anagram_word;
        String anagram_word = sc.nextLine();
        count = 0;
        while(anagram_word != "STOP"){
            System.out.println("\nPlease enter anagrams for the word " + random_word + ". Type "0" Once Finished typing anagrams.\n");

        }
    }

    public static Boolean assertAnagrams(){

    }



    public static ArrayList<String> read_words(String file_name){
        ArrayList<String> words = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(file_name))){
            while(sc.hasNextLine()) {
                String word = sc.nextLine();
                word = word.strip();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }
}