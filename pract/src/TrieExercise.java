import java.util.List;

public class TrieExercise {
    public static int CHAR_LENGTH = 26;

    public static class Node {
        private boolean isEndOfWord = false;
        private Node[] children = new Node[CHAR_LENGTH];
        public void setEndOfWord() {
            this.isEndOfWord = true;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public Node[] getChildren() {
            return children;
        }

        public void setChildren(int i) {
            this.children[i] = new Node();
        }

        @Override
        public String toString() {
            StringBuilder strBuilder = new StringBuilder("isEndOfWord=" + isEndOfWord + " || Children: ");

            for (int i = 0; i < this.children.length; i++) {
                strBuilder.append(children[i] != null ? " [" + (i + 1) + ": " + (char) ('a' + i) + "] " : " NULL ");
            }

            return strBuilder.toString();
        }
    }

    public static void insertTrieWord(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root.getChildren()[index] == null) {
                root.setChildren(index);
            }

            root = root.getChildren()[index];

            if (i == word.length() - 1) {
                root.setEndOfWord();
            }
        }
    }

    public static boolean searchWord(Node root, String word) {
        for (int  i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root.getChildren()[index] == null) {
                return false;
            }

            if (i == word.length() - 1 && !root.getChildren()[index].isEndOfWord()) {
                return false;
            }

            root = root.getChildren()[index];
        }

        return true;
    }

    public static List<String> printWords(Node root, int pos, StringBuilder str, List<String> res) {
        if (root == null) {
            return res;
        }

        if (root.isEndOfWord()) {
            char charRes = (char) ('a' + pos);
            str.append(charRes);
            res.add(str.toString());
            str.setLength(0);
            pos = -1;
        }
        if (pos >= 0) {
            str.append((char) ('a' + pos));
        }

        for (int i = 0; i < root.getChildren().length; i++) {
            if (root.getChildren()[i] != null) {
                res = printWords(root.getChildren()[i], i, str, res);
            }
        }

        return res;
    }
}
