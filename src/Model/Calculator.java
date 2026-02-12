package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private String input;


    public Calculator(){
        this.input=input;
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
    private static int precedence(String op) {
        return switch (op) {
            case "+", "-", "++", "--", "+-", "-+" -> 1;
            case "*", "/", "*+", "*-", "/+", "/-" -> 2;
            default -> -1;
        };
    }


    public String inFixToPostFix(String input){
        StringBuilder output= new StringBuilder();
        Deque<Character> stack=new ArrayDeque<>();

        for(int i=0; i<input.length(); i++){
            String c=String.valueOf(input.charAt(i));
            if (c.equals(" ")){
                continue;
            }
            if (Character.isDigit(input.charAt(i)) || input.charAt(i)=='.'){
                StringBuilder currentNumber= new StringBuilder();
                while(i<input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')){
                    currentNumber.append(input.charAt(i));

                    i++;

                }
                i--;
                output.append(currentNumber);


                
            } else if (isOperator(c)) {

            }

        }
        System.out.println(output);

        return "";
    }










    public String subcollisions(String e1, String e2){
        String c=e1+e2;
        return switch (c) {

            case "+", "++", "--" -> "+";
            case "-", "+-", "-+" -> "-";


            default -> "";

        };
    }
    public String collisionManagement(String input){
        Deque<String> expression1=new ArrayDeque<>();

        StringBuilder output=new StringBuilder();
        String[] characters=input.split("(?=[-+*/])|(?<=[-+*/])");

        for(String c:characters){
            expression1.addLast(c);

        }


        int iterations=expression1.size();
        for (int i=0; i< iterations; i++){
            String subOperator=expression1.getFirst();
            expression1.removeFirst();
            if(subOperator.equals("-") || subOperator.equals("+")){

                while (expression1.getFirst().equals("+") || expression1.getFirst().equals("-")){

                    subOperator=subcollisions(subOperator, expression1.getFirst());
                    expression1.removeFirst();

                    i++;
                }

            }
            output.append(subOperator);



        }

        characters=output.toString().split("(?=[()])|(?<=[()])");
        output=new StringBuilder();
        expression1=new ArrayDeque<>();
        for(String c:characters){
            expression1.addLast(c);

        }
        String prev="";
        iterations=expression1.size();
        for (int i=0; i< iterations; i++){

            String subOperator=expression1.getFirst();
            expression1.removeFirst();
            String aux1="";
            String aux2="";
            String aux3="";
            String operator=String.valueOf(subOperator.charAt(0));
            if(subOperator.equals("(") ){
                
                if (i!=0){
                    aux1=(!isOperator(prev) && !prev.equals("(") && !prev.equals(")"))? "*":"";
                }
                subOperator=aux1+subOperator;

            } else if (prev.equals("(") && isOperator(String.valueOf(subOperator.charAt(0)))) {

                aux2=(operator.equals("+") || operator.equals("-"))? "0":"1";
                subOperator=aux2+subOperator;
            } else if (prev.equals(")")) {

                    aux3=(Character.isDigit(subOperator.charAt(0)))? "*":"";

                subOperator=aux3+subOperator;
            }

            prev=String.valueOf(subOperator.charAt(subOperator.length()-1));
            output.append(subOperator);



        }






        return output.toString();
    }


}
