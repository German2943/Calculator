package Model;


import java.util.Arrays;
import java.util.ArrayList;

public class Operation {
    private String input;
    private String[] operations={"*","/","+","-"};
    private ArrayList<Float> numbers=new ArrayList<>();
    private ArrayList<String> operators=new ArrayList<>();
    private float result;

    public Operation(String input){
        this.input=input;

        parenthesisGroups();
        this.result=getResult(this.input);
        System.out.println("RESULTADO FINAL: "+ result);

    }

    public float getResult(String input){
        ArrayList<String> expression=spliter(input, operations);
        if(expression.size()==1){
            return Float.parseFloat(expression.getFirst());
        }
        if (input.replaceAll("\\s+", "").isEmpty()){
            return (float) 0;
        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        System.out.println("GET RESULT METHOD");
        System.out.println("Expression before */: "+expression);
        float result=0;
        for (int m=0; m<expression.size(); m++){
            if (expression.get(m).equals("*") || expression.get(m).equals("/")){
                result=operate(Float.parseFloat(expression.get(m-1)), Float.parseFloat(expression.get(m+1)), expression.get(m));

                expression.remove(m-1);
                expression.remove(m-1);
                expression.set(m-1, String.valueOf(result));
                m=0;
                System.out.println("Expression after */: "+expression);
            }
        }

        for (int n=0; n<expression.size(); n++){
            if (expression.get(n).equals("+") || expression.get(n).equals("-")){
                result=operate(Float.parseFloat(expression.get(n-1)), Float.parseFloat(expression.get(n+1)), expression.get(n));

                expression.remove(n-1);
                expression.remove(n-1);
                expression.set(n-1, String.valueOf(result));
                n=0;
                System.out.println("Expression after +-: "+expression);
            }
        }

        System.out.println("Result="+result);
        System.out.println();
        System.out.println("-----------------");
        System.out.println();


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

        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        System.out.println("SPLITER METHOD");
        System.out.println("input="+input);
        if (input.replaceAll("\\s+", "").isEmpty()){

            return new ArrayList<>();
        }
        String[] splited=input.split("");
        ArrayList<String> operators=new ArrayList<>();
        ArrayList<Float> numbers=new ArrayList<>();
        int lastOperator=-1;
        for (int charac=0; charac< splited.length; charac++){
            if (Arrays.asList(characters).contains(splited[charac])){
                float neutral=0;
                if (charac==0){
                    if(splited[charac].equals("-") || splited[charac].equals("+")){
                        numbers.add((float)0);
                        operators.add(splited[charac]);
                        lastOperator=charac;
                    }

                }else {


                    if(Arrays.asList(operations).contains(splited[charac+1])){


                        String op1=splited[charac];
                        String op2=splited[charac+1];
                        neutral=(op1.equals("*") || op1.equals("/") || op2.equals("*") || op2.equals("/"))? 1:0;
                        if (neutral==0){

                            numbers.add(Float.parseFloat(input.substring(lastOperator+1, charac)));

                            operators.add(splited[charac]);
                            numbers.add((float)0);
                            operators.add(op2);

                        } else if (op2.equals("-")) {
                            numbers.add((float)0);
                            String subOperator="-";
                            if(!operators.isEmpty()){
                                subOperator=(operators.getLast().equals("-"))? "+":"-";
                            }

                            operators.add(subOperator);
                            numbers.add((float)1);
                            operators.add("*");
                            numbers.add(Float.parseFloat(input.substring(lastOperator+1, charac)));
                            operators.add(splited[charac]);

                        }else {
                            numbers.add((float)0);
                            operators.add("+");
                            numbers.add((float)1);
                            operators.add("*");
                            numbers.add(Float.parseFloat(input.substring(lastOperator+1, charac)));
                            operators.add(splited[charac]);

                        }


                        lastOperator=charac+1;
                        charac=lastOperator;




                    }else {
                        float number=Float.parseFloat(input.substring(lastOperator+1, charac));
                        numbers.add(number);
                        operators.add(splited[charac]);
                        lastOperator=charac;
                    }
                    System.out.println();
                    System.out.println("after dealing with collisions: "+numbers);
                    System.out.println("after dealing with collisions: "+operators);
                    System.out.println();

                }

            }
            System.out.println();
            System.out.println("iteration result:"+numbers);
            System.out.println("iteration result:"+operators);
            System.out.println();
        }

        numbers.add(Float.parseFloat(input.substring(lastOperator+1)));
        System.out.println();
        System.out.println("final array:"+numbers);
        System.out.println("final array:"+operators);
        System.out.println();

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
        System.out.println("Expression="+expression);
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        return expression;
    }

    public void parenthesisGroups(){
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        System.out.println("PARENTHESIS RECOGNITION");

        String[] splited=input.split("");
        int lastOpen;

        for(int charac=splited.length-1; charac>=0; charac--){
            splited=input.split("");
            if (splited[charac].equals("(")){
                String operator="";
                String neutral="";
                if (charac>0){
                    operator= (!Arrays.asList(operations).contains(splited[charac-1]) && (!splited[charac-1].equals("(") ))? "*":"";

                    neutral=((splited[charac-1].equals("+") || splited[charac-1].equals("-")) && !splited[charac-1].equals("("))? "0":"";


                }

                lastOpen=charac;
                while (!splited[charac].equals(")")){

                    charac++;



                }
                if(splited[charac].equals(")")){
                    System.out.println("input before: "+input);
                    operator=(getResult(neutral+input.substring(lastOpen+1, charac))<(float) 0)? "0"+operator:operator;

                    input=input.substring(0,lastOpen)+operator+(getResult(neutral+input.substring(lastOpen+1, charac)))+input.substring(charac+1, input.length());

                    charac=input.length()-1;
                    System.out.println("input after: "+input);

                }



            }

        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println();



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
