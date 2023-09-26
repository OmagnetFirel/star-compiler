import lexer.Lexer;
import syntax.SyntaxKind;
import syntax.SyntaxToken;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            print("> ");
            String line = scanner.nextLine();
            Lexer lexer = new Lexer(line);

            while(true){
                SyntaxToken token = lexer.NextToken();
                if(token.getKind().equals(SyntaxKind.EndOfFileToken)){
                    break;
                }
                String mensagem = String.format("%s : %s ", token.getKind(), token.getText());
                print(mensagem);
                if(token.getValue() != null){
                    print("value: " + token.getValue().toString());
                }
                printLn("");
            }
        }
    }

    public static void print(String text){
        System.out.print(text);
    }
    public static void printLn(String text){
        System.out.println(text);
    }
}