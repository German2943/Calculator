package Model;

public class subOperation {
    private float n1, n2;
    private String operator;

    public subOperation(float n1, float n2, String operator){
        this.n1=n1;
        this.n2=n2;
        this.operator=operator;

    }

    public float operate(){
        return switch (operator) {
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            default -> 0;
        };
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
