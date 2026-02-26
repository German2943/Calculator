package Model;


public class Operator {

    private int precedence;
    Associativity associativity;

    public Operator(int precedence, int associativity){
        this.precedence=precedence;
        switch (associativity){
            case 0:
                this.associativity=Associativity.RIGHT;
            case 1:
                this.associativity=Associativity.LEFT;
        }
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public Associativity getAssociativity() {
        return associativity;
    }

    public void setAssociativity(Associativity associativity) {
        this.associativity = associativity;
    }
}
