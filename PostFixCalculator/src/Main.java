public class Main {

    public static void main(String[] args) {
        PostFixCalculator postFixCalculatorFromBook = new PostFixCalculator();
        System.out.println(postFixCalculatorFromBook.evaluate("3 8 1 - * 7 *"));
    }
}
