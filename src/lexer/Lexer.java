package lexer;

import syntax.SyntaxKind;
import syntax.SyntaxToken;

public class Lexer {
    private String _text;
    private int _position;
    private char Current(){
        if(_position >= _text.length()){
            return '\0';
        }
        return _text.charAt(_position);
    }
    private void Next(){
        _position++;
    }
    public Lexer(String text){
        _text = text;
    }

    /**
     *
     * @return um token com as informações de cada 'palavra'
     */
    public SyntaxToken NextToken(){
        if(_position >= _text.length()){
            return new SyntaxToken(SyntaxKind.EndOfFileToken, _position, "\0", null);
        }
        // <Numbers>
        // + - * ( )symbols
        // <whitespace>
        if(Character.isDigit(Current())){
            int start = _position;
            while (Character.isDigit(Current())){
                Next();
            }
            int endIndex = _position;
            String text = _text.substring(start, endIndex);
            text = text.trim();

            int value = Integer.parseInt(text);
            return new SyntaxToken(SyntaxKind.NumberToken, start, text, value);
        }
        if(Character.isWhitespace(Current())){
            int start = _position;
            while(Character.isWhitespace(Current())){
                Next();
            }
            int length = _position - start;
            String text = _text.substring(start, _position);
            return new SyntaxToken(SyntaxKind.WhiteSpaceToken, start, text, null);
        }
        if(Current() == '+' ) {
            return new SyntaxToken(SyntaxKind.PlusToken, _position++, "+", null);
        } else if (Current() == '-') {
            return new SyntaxToken(SyntaxKind.MinusToken, _position++, "-", null);
        } else if (Current() == '*') {
            return new SyntaxToken(SyntaxKind.StarToken, _position++, "*", null);
        } else if (Current() == '/') {
            return new SyntaxToken(SyntaxKind.SlashToken, _position++, "/", null);
        } else if (Current() == '(') {
            return new SyntaxToken(SyntaxKind.OpenParenthesisToken, _position++, "(", null);
        } else if (Current() == ')') {
            return new SyntaxToken(SyntaxKind.CloseParenthesisMinusToken, _position++, ")", null);
        }
        return new SyntaxToken(SyntaxKind.BadToken, _position++, _text.substring(_position - 1, 1), null);

    }
}
