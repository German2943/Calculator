package Model;


import java.util.Arrays;
import java.util.ArrayList;

public class Operation {
    private String input;
    private String[] operations={"*","/","+","-"};
    private ArrayList<Float> numbers=new ArrayList<>();
    private ArrayList<String> operators=new ArrayList<>();

    public Operation(String input){
        this.input=input;
    }

    public float getResult(String input){
        ArrayList<String> expression=spliter(input, operations);

        float result=0;
        for (int m=0; m<expression.size(); m++){
            if (expression.get(m).equals("*") || expression.get(m).equals("/")){
                result=operate(Float.parseFloat(expression.get(m-1)), Float.parseFloat(expression.get(m+1)), expression.get(m));
                expression.remove(m-1);
                expression.remove(m-1);
                expression.set(m-1, String.valueOf(result));
                m=0;
            }
        }
        System.out.println(expression);
        for (int n=0; n<expression.size(); n++){
            if (expression.get(n).equals("+") || expression.get(n).equals("-")){
                result=operate(Float.parseFloat(expression.get(n-1)), Float.parseFloat(expression.get(n+1)), expression.get(n));
                expression.remove(n-1);
                expression.remove(n-1);
                expression.set(n-1, String.valueOf(result));
                n=0;
            }
        }

        System.out.println(expression);


        return result;

    }

    public float operate(float n1, float n2, String op){
        return switch (op) {
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            default -> 0;
        };
    }

    public ArrayList<String> spliter(String input, String[] characters){
        String[] splited=input.split("");
        ArrayList<String> operators=new ArrayList<>();
        ArrayList<Float> numbers=new ArrayList<>();
        int lastOperator=-1;
        for (int charac=0; charac< splited.length; charac++){
            if (Arrays.asList(characters).contains(splited[charac])){
                if (charac==0){

                }else {
                    numbers.add(Float.parseFloat(input.substring(lastOperator+1, charac)));
                    operators.add(splited[charac]);
                    lastOperator=charac;
                }
            }
        }
        numbers.add(Float.parseFloat(input.substring(lastOperator+1)));
        System.out.println(numbers);
        System.out.println(operators);

        //result=operate(numbers.get(k), numbers.get(k+1), operators.get(k));
        //numbers.set(k+1, result);
        ArrayList<String> expression=new ArrayList<>();
        int num=0;
        int op=0;
        for(int t=1; t<operators.size()+numbers.size()+1; t++){
            if(t%2!=0){
                expression.add(String.valueOf(numbers.get(num)));
                num++;
            }else {
                expression.add(operators.get(op));
                op++;
            }

        }
        return expression;
    }

    public ArrayList<String> parenthesisGroups(){

        ArrayList<String> expression=new ArrayList<>();
        String[] neutral1={"/","*"};
        String[] neutral2={"+","-"};
        String[] splited=input.split("");
        int lastOpen=0;

        for (int charac=0; charac< splited.length; charac++){
            if (splited[charac].equals("(")){
                lastOpen=charac;
            } else if (splited[charac].equals(")")) {

                expression.add(input.substring(lastOpen+1, charac));
                expression.add(String.valueOf(getResult(input.substring(lastOpen+1, charac))));
                if(lastOpen!=0){
                    if (!Arrays.asList(operations).contains(splited[lastOpen-1]) || splited[charac].equals("(")){

                    }
                }
            }

        }
        return expression;
    }

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<String> operators) {
        this.operators = operators;
    }
}
