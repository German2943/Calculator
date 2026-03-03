package Model;

abstract class Expr{}

class Binary extends Expr{
    Expr left;
    String operator;
    Expr rigth;

    Binary(Expr left, String operator, Expr rigth){
        this.left=left;
        this.operator=operator;
        this.rigth=rigth;
    }


}

class Literal extends Expr{
    double value;

    Literal(double value){
        this.value=value;
    }
}

class Unary extends Expr{
    String operator;
    Expr right;

    Unary(String operator, Expr right){
        this.operator=operator;
        this.right=right;
    }
}
