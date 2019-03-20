public class PostFixCalculator {

    public PostFixCalculator(){}

    public double CalculatingResult(String elements)
    {
        //create stackIncomingData
        Stack stackOfElements = new Stack(100);
        char lastPeeked;
        int size;
        double result = 0;

        //load stackIncomingData
        for (int i = elements.length(); i > 0; i--) {
            stackOfElements.push(elements.charAt(i-1));
            System.out.println("Loaded to incoming data: " + stackOfElements.peek());
        }

        //create stack Numbers
        Stack stackOfNumbers = new Stack(100);
        size = stackOfElements.size();
        for (int i = 0; i < size; i++) {

            lastPeeked = (Character) stackOfElements.peek();
            System.out.println("Last Peeked: " + stackOfElements.peek());
            //if the top element is a number, then we pop it from here and push to the number stack
            if (Character.isDigit(lastPeeked)) {
                stackOfNumbers.push(stackOfElements.pop());
                System.out.println("Loaded To Numbers: " + stackOfNumbers.peek());
            }

            //if the top element is an operand, then we determine which operation is that, then take the
            // top two elements of number array and execute the recognised operation
            if (lastPeeked == '-') {
                double tempd1 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                double tempd2 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                result = tempd1 - tempd2;
                stackOfNumbers.push(result);
            }

            if(lastPeeked == '%' )
            {
                double tempd1 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                double tempd2 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                System.out.println(tempd1 + " " + tempd2 + "");
                result = tempd2 % tempd1;
                stackOfNumbers.push(result);
            }

            if(lastPeeked == '/' )
            {
                double tempd1 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                double tempd2 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                result = tempd1 / tempd2;
                stackOfNumbers.push(result);
            }

            if(lastPeeked == '*' )
            {
                double tempd1 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                double tempd2 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                result = tempd1 * tempd2;
                stackOfNumbers.push(result);
            }

            if(lastPeeked == '+' )
            {
                double tempd1 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                double tempd2 = (double) Character.digit((char)stackOfNumbers.pop(), 10);
                result = tempd1 + tempd2;
                stackOfNumbers.push(result);
                System.out.println("Result: " + result);
            }
        }
            return result;
    }


    }


