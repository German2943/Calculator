package Model;

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
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            default -> 0;
        };
    }


    public void parenthesisGrouping(String input){
        String[] splitted;
    }
}
