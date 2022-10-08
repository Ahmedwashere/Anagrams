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
        ArrayList<String> anagrams = find_anagrams(words, random_word);
        int anagrams_count = anagrams.size();
        int anagrams_correctly_guessed_count = 0;
        ArrayList<String> anagrams_correctly_guessed = new ArrayList<String>();
        ArrayList<String> distinct_guesses = new ArrayList<String>();
        int distinct_guesses_count = 0;
        String input_word = "";
        int exit = 0;

        System.out.print("\nPlease enter anagrams for the word " + random_word + ". Type '1' Once Finished typing anagrams.\n");
        while(!(input_word.equals("1"))){

            System.out.print("Your guess: ");
            input_word = sc.nextLine().strip();
            if (words.contains(input_word) == false && !(input_word.equals("1"))) {
                System.out.println("\n" + input_word + " is not a word. Please enter an anagram of " + random_word + ".\n");
            } else if (anagrams.contains(input_word) && anagrams_correctly_guessed.contains(input_word) == false && input_word != random_word) {
                anagrams_correctly_guessed_count++;
                distinct_guesses.add(input_word);
                distinct_guesses_count++;
                if (anagrams_correctly_guessed_count == anagrams_count) {
                    break;
                } else {
                    System.out.println(input_word + " is a correct anagram of " + random_word + "!\n");
                    System.out.println();
                }
            } else if (anagrams.contains(input_word) && anagrams_correctly_guessed.contains(input_word) == true && input_word != random_word) {
                System.out.println(input_word + " has already been guessed correctly. Please enter a new anagram of " + random_word + ".\n");
            } else if (anagrams.contains(input_word) && anagrams_correctly_guessed.contains(input_word) == true && input_word == random_word) {
                System.out.println(input_word + " is the word you are guessing anagrams of. It cannot be guessed. Please enter a new anagram.\n");
            } else if (anagrams.contains(input_word) == false) {
                System.out.println(input_word + " is not an anagram of " + random_word + "! Please try again!\n");
                if (distinct_guesses.contains(input_word) == false) {
                    distinct_guesses.add(input_word);
                    distinct_guesses_count++;
                }
            }
        }

        if(anagrams_correctly_guessed_count < anagrams_count){
            System.out.println("\nYou have guessed " + distinct_guesses_count + " distinct words!");
            System.out.println(anagrams_correctly_guessed_count + " of the distinct words were correct anagrams of " + random_word);
            System.out.println(random_word + " has " + anagrams_count + " anagram(s)!");
        } else {
            System.out.println("\nYou have guessed " + distinct_guesses_count + " distinct words!");
            System.out.println("You guessed all of the anagrams! " + anagrams_correctly_guessed_count + " anagram(s) guessed. " + random_word + " has " + anagrams_count + " anagram(s)!");
        }
    }



    public static ArrayList<String> find_anagrams(ArrayList<String> words, String anagram){
        ArrayList<String> anagrams_of_word = new ArrayList<String>();
        char[] anagram_chars = make_char_array(anagram);
        Arrays.sort(anagram_chars);
        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);
            char[] word_chars = make_char_array(word);
            Arrays.sort(word_chars);
            if(Arrays.equals(word_chars, anagram_chars) && word != anagram){
                anagrams_of_word.add(word);
            }
        }
        return anagrams_of_word;
    }

    public static char[] make_char_array(String word){
        char[] characters = new char[word.length()];
        for(int i =0; i < word.length(); i++){
            characters[i] = word.charAt(i);
        }
        return characters;
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