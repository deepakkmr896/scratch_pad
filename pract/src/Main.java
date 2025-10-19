import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrieExercise.Node root = new TrieExercise.Node();
        TrieExercise.insertTrieWord(root, "apple");
        TrieExercise.insertTrieWord(root, "cat");
        TrieExercise.insertTrieWord(root, "ball");
        TrieExercise.insertTrieWord(root, "zebra");
        TrieExercise.insertTrieWord(root, "elephant");
        TrieExercise.insertTrieWord(root, "dog");

        List<String> res = new ArrayList<>();

        // print, it will print in sorted form, time complexity - O(L), L = length of all words
        TrieExercise.printWords(root, -1, new StringBuilder(), res);
        System.out.println(res);

        // Searching, time complexity - O(L), L = length of input word
        System.out.println(TrieExercise.searchWord(root, "hello"));
        System.out.println(TrieExercise.searchWord(root, "apple"));

    }
}