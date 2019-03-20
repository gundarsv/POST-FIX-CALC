import java.security.InvalidKeyException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PostFixCalculatorBook {
    private final char ADD = '+';
    private final char SUBSTRACT = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final int DEFAULT_SIZE = 100;
    private StackADT<Integer> numberStack;
    public PostFixCalculatorBook()
    {
        numberStack = new Stack<>(DEFAULT_SIZE);
    }
    public int evaluate(String expr) {
        int n1, n2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);
        try {
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                if (isOperator(token))
                {
                    n1 = (numberStack.pop()).intValue();
                    n2 = (numberStack.pop()).intValue();
                    result = evaluateSingleOperation(token.charAt(0),n1,n2);
                    numberStack.push(result);
                }
                else {
                    numberStack.push(Integer.parseInt(token));
                }
            }
            return result;
        }
        catch (Exception e)
        {
            System.out.println("Invalid expresion please type them with spaces");
        }
        return result;
    }
    private boolean isOperator(String token)
    {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    private int evaluateSingleOperation (char operation, int n1, int n2)
    {
        int result = 0;
        switch (operation) {
            case ADD:
                result = n1 + n2;
                break;
            case SUBSTRACT:
                result = n1 - n2;
                break;
            case MULTIPLY:
                result = n1 * n2;
                break;
            case DIVIDE:
                result = n1 / n2;
        }
        return result;

    }

}


