public class PopFixCalculator {
    public double CalculatingResult(String elements)
    {
        Stack stackOfElements = new Stack(100);
        char lastPeeked;
        for (int i = 0; i <elements.length(); i++) {
            stackOfElements.push(elements.charAt(i));
        }
        Stack stackOfNumbers = new Stack(100);
        for (int i = 0; i < stackOfElements.size(); i++) {
            lastPeeked = (Character) stackOfElements.peek();
            if (Character.isDigit(lastPeeked)) {
                stackOfNumbers.push(stackOfElements.pop());

            }
            if (lastPeeked == '%' || lastPeeked == '/' || lastPeeked == '*' || lastPeeked == '+' || lastPeeked == '-') {
                

            }
        }
            return 2;
    }




    }


