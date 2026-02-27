package Model;

import java.util.*;

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






    public String collisions(String e1, String e2){
        String c=e1+e2;
        return switch (c) {

            case "+", "++", "--" -> "+";
            case "-", "+-", "-+" -> "-";


            default -> "";

        };
    }





}
