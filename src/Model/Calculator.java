package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private String input;
    private String[] operations={"*","/","+","-"};

    double result;

    public Calculator(String input){
        this.input=input;
    }

    public double operate(double n1, double n2, String op){
        return switch (op) {
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            case "+", "++", "--" -> n1 + n2;
            case "-", "+-", "-+" -> n1 - n2;
            case "*-" -> -1*n1 * n2;
            case "/-" -> -1*n1 / n2;

            default -> 0;

        };
    }
    public double operation(String input){
        Deque<String> expression1=new ArrayDeque<>();
        Deque<String> expression2=new ArrayDeque<>();
        String[] characters=input.split("(?=[-+*/])|(?<=[-+*/])");

        for(String c:characters){
            expression1.addLast(c);

        }

        return 0;
    }


    public void parenthesisGrouping(String input){
        String[] splitted=input.split("(?=[(),])|(?<=[(),])");
        String output;
        int first=0;
        int last=0;





    }




    public String subcollisions(String e1, String e2){
        String c=e1+e2;
        return switch (c) {

            case "+", "++", "--" -> "+";
            case "-", "+-", "-+" -> "-";


            default -> "";

        };
    }
    public Deque<String> collisionManagement(String input){
        Deque<String> expression1=new ArrayDeque<>();
        Deque<String> expression2=new ArrayDeque<>();
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



        }
        System.out.println(expression1);
        return expression2;
    }


}
