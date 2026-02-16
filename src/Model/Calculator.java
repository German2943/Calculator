package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private String input;
    private double result;


    public Calculator(String input){
        this.input=input;
        String postCollision=collisionManagement(this.input);
        this.result=evaluatePostFix(inFixToPostFix(postCollision));
        System.out.println(result);

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


    public Deque<String> inFixToPostFix(String input){
        Deque<String> output= new ArrayDeque<>();
        Deque<String> stack=new ArrayDeque<>();

        for(int i=0; i<input.length(); i++){
            String c=String.valueOf(input.charAt(i));
            Character c1=input.charAt(i);
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
                output.addLast(currentNumber.toString());


                
            } else if (c.equals("(")) {
                stack.addLast(c);
                
            } else if (c.equals(")")) {
                while (!stack.getLast().equals("(") ){
                    output.addLast(stack.getLast());
                    stack.removeLast();
                }
                stack.removeLast();

            } else if (isOperator(c)) {
                while (!stack.isEmpty()  && precedence(stack.getLast())>=precedence(c)){
                    output.addLast(stack.getLast());
                    stack.removeLast();
                }
                stack.addLast(c);

                
            }

        }
        while (!stack.isEmpty()){
            output.addLast(stack.getLast());
            stack.removeLast();
        }
        System.out.println(output.toString().trim());

        return output;
    }


    public double evaluatePostFix(Deque<String> input){
        Deque<String> stack=new ArrayDeque<>();

        while (!input.isEmpty()){
            if (!isOperator(input.getFirst())){
                stack.addLast(input.getFirst());
                input.removeFirst();
            }else {
                double b=Double.parseDouble(stack.getLast());
                stack.removeLast();
                double a=Double.parseDouble(stack.getLast());
                stack.removeLast();
                double result=operate(a, b, input.getFirst());
                stack.addLast(String.valueOf(result));
                input.removeFirst();
            }
            System.out.println(stack);

        }

        return Double.parseDouble(stack.getFirst());

    }










    public String collisions(String e1, String e2){
        String c=e1+e2;
        return switch (c) {

            case "+", "++", "--" -> "+";
            case "-", "+-", "-+" -> "-";


            default -> "";

        };
    }



    public String collisionManagement(String input){
        input=input.replace("((","(");
        input=input.replace("))",")");


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

                    subOperator= collisions(subOperator, expression1.getFirst());
                    expression1.removeFirst();

                    i++;
                }
                String previous=String.valueOf(output.charAt(output.length()-1));



                if (previous.equals("*") || previous.equals("/")){
                    if (!expression1.getFirst().equals("(")){
                        output.append("(").append(subOperator).append(expression1.getFirst()).append(")");
                        expression1.removeFirst();
                    }else {
                        output.append("(").append(subOperator).append(expression1.getFirst()).append(0).append(")");
                        expression1.removeFirst();
                    }

                    i++;
                    continue;

                }










            }

            output.append(subOperator);



        }
        System.out.println("output1:"+output);

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
                    aux1=((!isOperator(prev) && !prev.equals("(")) || prev.equals(")"))? "*":"";


                }
                subOperator=aux1+subOperator;

            } else if (prev.equals("(") && isOperator(String.valueOf(subOperator.charAt(0))) ) {

                aux2=(operator.equals("+") || operator.equals("-"))? "0":"1";
                subOperator=aux2+subOperator;
            } else if (prev.equals(")")) {

                    aux3=(Character.isDigit(subOperator.charAt(0)) )? "*":"";

                subOperator=aux3+subOperator;
            } else if (i==0 && (operator.equals("+") || operator.equals("-"))) {
                subOperator=0+subOperator;
            }

            prev=String.valueOf(subOperator.charAt(subOperator.length()-1));
            output.append(subOperator);



        }


        System.out.println("output2:"+output);

        return output.toString();
    }


}
