package hot100;

public class main {
    public static void main(String[] args) {
        Leetcode394 leetcode394 = new Leetcode394();
        String decodeString = leetcode394.decodeString("3[a]2[bc]");
        System.out.println("res = " + decodeString);

        String string = leetcode394.getString("3", "a");
        System.out.println(string);
    }
}
