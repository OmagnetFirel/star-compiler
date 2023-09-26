package syntax;

public final class NumberSyntax extends ExpressionSyntax {
    public SyntaxToken NumberToken;

    public NumberSyntax(SyntaxToken numberToken){
        NumberToken = numberToken;
    }

    public SyntaxToken getNumberToken() {
        return NumberToken;
    }

    @Override
    public SyntaxKind Kind(){
        return SyntaxKind.NumberExpression;
    };
}
