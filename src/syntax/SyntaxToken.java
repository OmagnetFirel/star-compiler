package syntax;


public class SyntaxToken {
    public SyntaxKind Kind;
    public int Position ;
    public String Text;
    public Object Value;
    public SyntaxToken(SyntaxKind kind, int position, String text, Object value){
        Kind = kind;
        Position = position;
        Text = text;
        Value = value;
    }
    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public SyntaxKind getKind() {
        return Kind;
    }

    public void setKind(SyntaxKind kind) {
        Kind = kind;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
    public Object getValue() {
        return Value;
    }

    public void setValue(Object value) {
        Value = value;
    }

}
