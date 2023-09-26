package parser;

import lexer.Lexer;
import syntax.SyntaxKind;
import syntax.SyntaxToken;

import java.util.ArrayList;

public class Parser {
    private ArrayList<SyntaxToken> _tokens;
    private int _position;
    public Parser(String text){
        ArrayList<SyntaxToken> tokens = new ArrayList<SyntaxToken>();
        Lexer lexer = new Lexer(text);
        SyntaxToken token;
        do {
            token = lexer.NextToken();
            if(token.getKind() != SyntaxKind.WhiteSpaceToken && token.getKind() != SyntaxKind.BadToken){
                tokens.add(token);
            }
        }while (token.getKind() != SyntaxKind.EndOfFileToken);
        _tokens = tokens;
    }

    private SyntaxToken Peek(int offset){
        int index = _position - offset;
        if(index >= _tokens.size()){
            return _tokens.get(_tokens.size() - 1);
        }
        return _tokens.get(index);
    }

    private SyntaxToken Current(){
        return Peek(0);
    }
}
