package Model;

import java.util.Objects;

public class Token {
    private String argument;
    private tokenType type;

    public Token(tokenType t, String argument){
        this.type =t;
        this.argument=argument;
    }
    public Token(){

    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public tokenType getToken() {
        return type;
    }

    public void setToken(tokenType tokenType) {
        this.type = tokenType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;

        Token token = (Token) o;

        return type == token.type &&
                Objects.equals(argument, token.argument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, argument);
    }
}
