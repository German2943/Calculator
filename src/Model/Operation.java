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

    public float getResult(){

        String[] splited=this.input.split("");
        int lastOperator=-1;
        for (int charac=0; charac< splited.length; charac++){
            if (Arrays.asList(operations).contains(splited[charac])){
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
        float result=0;
        for (int g=0; g<=1; g++){

            for (int k=0; k<operators.size(); k++){

                //(g==0 & (operators.get(k).equals("*")) || operators.get(k).equals("/") ) || (g==1 & (operators.get(k).equals("+")) || operators.get(k).equals("-") )
                if ( (g==0 & (operators.get(k).equals("*")) || operators.get(k).equals("/") ) || (g==1 & (operators.get(k).equals("+")) || operators.get(k).equals("-") ) ){
                    result=operate(numbers.get(k), numbers.get(k+1), operators.get(k));
                    System.out.println("result="+result);
                    if(g==0){
                        operators.remove(k);
                        numbers.remove(k);
                        numbers.set(k, result);


                    }else {
                        numbers.set(k+1, result);
                    }



                }

            }
        }

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
