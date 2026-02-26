package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Calculator {
    HashMap<String, Operator> pairs=new HashMap<>();

    public Calculator(){
        pairs.put("+", new Operator(1,0));
        pairs.put("-", new Operator(1,0));
        pairs.put("*", new Operator(2,0));
        pairs.put("/", new Operator(2,0));
        pairs.put("NEG", new Operator(3,1));
        pairs.put("PLUS", new Operator(3,1));
    }





    public String Calculate(String input){
        double result;

            String postCollision=collisionManagement(input);

            result = evaluatePostFix(inFixToPostFix(postCollision));


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





    public Deque<String> inFixToPostFix(String input){
        Deque<String> output= new ArrayDeque<>();
        Deque<String> stack=new ArrayDeque<>();
        String[] split =input.split("");
        for (String c: split){
            if (Character.isDigit(c.charAt(0)) || c.equals(".")){
                output.addLast(c);
                
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && !stack.getLast().equals("(") &&  isOperator(stack.getLast()) &&
                        (pairs.get(stack.getLast()).getPrecedence()>pairs.get(c).getPrecedence()
                || pairs.get(stack.getLast()).getPrecedence()==pairs.get(c).getPrecedence() &&
                                pairs.get(c).associativity==Associativity.LEFT)){



                    output.addLast(stack.getLast());
                    stack.removeLast();

                }
                stack.addLast(c);
            } else if (c.equals("(")) {
                stack.addLast(c);
            } else if (c.equals(")")) {
                while(!stack.isEmpty() && !stack.getLast().equals("(")){
                    output.addLast(stack.getLast());
                    stack.removeLast();
                }
                if (!stack.isEmpty()) stack.removeLast();
            }
        }

        while (!stack.isEmpty()){
            output.addLast(stack.getLast());
            stack.removeLast();
        }




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
        String[] expression=input.split("(?<=[+\\-])|(?=[+\\-])");

        StringBuilder output=new StringBuilder();




        for (int i=0; i<expression.length-1; i++){

            if ((expression[i].equals("+") || expression[i].equals("-")) && (expression[i+1].equals("+") || expression[i+1].equals("-"))){
                expression[i+1]=collisions(expression[i], expression[i+1]);
                continue;

            }

            output.append(expression[i]);
            if (i+1==expression.length-1){
                output.append(expression[i+1]);
            }

        }


        return output.toString();
    }


}
