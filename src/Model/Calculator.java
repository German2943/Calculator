package Model;

import java.util.*;

public class Calculator {
    HashMap<String, Operator> pairs=new HashMap<>();
    private ArrayList<Token> tokens;

    public Calculator(){
        pairs.put("+", new Operator(1,0));
        pairs.put("-", new Operator(1,0));
        pairs.put("*", new Operator(2,0));
        pairs.put("/", new Operator(2,0));
        pairs.put("NEG", new Operator(3,1));
        pairs.put("PLUS", new Operator(3,1));
    }





    public String Calculate(String input){
        double result=0;



        return String.valueOf(result);

    }




    public double operate(double n1, double n2, String op){
        return switch (op) {
            case "*", "*+" -> n1 * n2;
            case "/" , "/+"-> n1 / n2;
            case "+", "++", "--" -> n1 + n2;
            case "-", "+-", "-+" -> n1 - n2;
            case "*-" -> -1*n1 * n2;
            case "/-" -> -1*n1 / n2;

            default -> 0;

        };
    }


    public boolean isOperator(String c){
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") ||  c.equals("++") || c.equals("-+") || c.equals("*+") || c.equals("/+") ||  c.equals("+-") || c.equals("--") || c.equals("*-") || c.equals("/-");
    }

    public ArrayList<Token> tokenizer(String input){

        ArrayList<Token> tokens = new ArrayList<>();

        for (int n = 0; n < input.length(); n++) {

            char currentChar = input.charAt(n);

            switch (currentChar) {
                case '+':
                    tokens.add(new Token(tokenType.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(tokenType.MINUS, "-"));
                    break;
                case '*':
                    tokens.add(new Token(tokenType.STAR, "*"));
                    break;
                case '/':
                    tokens.add(new Token(tokenType.SLASH, "/"));
                    break;
                case '(':
                    tokens.add(new Token(tokenType.LPAREN, "("));
                    break;
                case ')':
                    tokens.add(new Token(tokenType.RPAREN, ")"));
                    break;
                default:

                    if (Character.isDigit(currentChar)) {

                        StringBuilder number = new StringBuilder();

                        while (n < input.length() &&
                                (Character.isDigit(input.charAt(n)) || input.charAt(n) == '.')) {

                            number.append(input.charAt(n));
                            n++;
                        }

                        n--;
                        tokens.add(new Token(tokenType.NUMBER, number.toString()));
                    }
            }
        }
        System.out.println(visual(tokens));

        return tokens;
    }



    public ArrayList<String> visual(ArrayList<Token> tokens){
        ArrayList<String> strings=new ArrayList<>();
        for (Token token : tokens) {
            strings.add(token.getArgument());
        }
        return strings;
    }






    public String collisions(String e1, String e2){
        String c=e1+e2;
        return switch (c) {

            case "+", "++", "--" -> "+";
            case "-", "+-", "-+" -> "-";


            default -> "";

        };
    }





}
