import java.util.StringTokenizer;

public class PostFixCalculatorVersion2 {
    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPLY = '*';
    private static final char DIVIDE = '/';
    private static final int DEFAULT_SIZE = 100;
    private StackADT<Integer> numberStack;
    public PostFixCalculatorVersion2()
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
                    n2 = (numberStack.pop()).intValue();
                    n1 = (numberStack.pop()).intValue();
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
            case SUBTRACT:
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


