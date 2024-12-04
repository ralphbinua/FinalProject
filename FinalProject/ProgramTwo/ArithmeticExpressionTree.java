package ProgramTwo;

import java.util.Scanner;
import java.util.Stack;

class Node {
    String data;
    Node leftChild, rightChild;

    Node(String data) {
        this.data = data;
        leftChild = rightChild = null;
    }
}

public class ArithmeticExpressionTree {

    // Method to construct the expression tree
    public static Node constructTree(String expression) {
        Stack<Node> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Skip spaces
            if (currentChar == ' ') continue;

            if (currentChar == '(') {
                operatorStack.push(currentChar); // Push opening parenthesis
            } else if (currentChar == ')') {
                // Process until the corresponding '(' is found
                while (operatorStack.peek() != '(') {
                    char op = operatorStack.pop();
                    Node rightOperand = operandStack.pop();
                    Node leftOperand = operandStack.pop();
                    Node operatorNode = new Node(String.valueOf(op));
                    operatorNode.leftChild = leftOperand;
                    operatorNode.rightChild = rightOperand;
                    operandStack.push(operatorNode);
                }
                operatorStack.pop(); // Remove '('
            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                // Push operator to the stack
                operatorStack.push(currentChar);
            } else if (Character.isDigit(currentChar)) {
                // Create a node for the number and push it
                operandStack.push(new Node(String.valueOf(currentChar)));
            }
        }

        // Return the final node in the stack (root of the tree)
        return operandStack.pop();
    }

    // Method to display the tree structure
    public static void displayTree(Node root, String indent) {
        if (root != null) {
            System.out.println(indent + " " + root.data);

            if (root.leftChild != null || root.rightChild != null) {
                if (root.leftChild != null && root.rightChild != null) {
                    System.out.println(indent + " / \\");
                    System.out.println(indent + " " + root.leftChild.data + " " + root.rightChild.data);
                } else if (root.leftChild != null) {
                    System.out.println(indent + " /");
                    System.out.println(indent + " " + root.leftChild.data);
                } else if (root.rightChild != null) {
                    System.out.println(indent + " \\");
                    System.out.println(indent + " " + root.rightChild.data);
                }
            }
        }
    }

    // Pre-order traversal
    public static void displayPrefix(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            displayPrefix(root.leftChild);
            displayPrefix(root.rightChild);
        }
    }

    // Post-order traversal
    public static void displayPostfix(Node root) {
        if (root != null) {
            displayPostfix(root.leftChild);
            displayPostfix(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User prompt
        System.out.print("Input a valid arithmetic expression (fully parenthesized): ");
        String userExpression = input.nextLine();

        // Remove unnecessary spaces
        userExpression = userExpression.replaceAll("\\s+", "");

        // Build the tree
        Node treeRoot = constructTree(userExpression);

        // Display tree and traversals
        System.out.println("\nGenerated Expression Tree:");
        displayTree(treeRoot, "");

        System.out.print("\nPrefix Notation: ");
        displayPrefix(treeRoot);

        System.out.print("\n\nPostfix Notation: ");
        displayPostfix(treeRoot);
    }
}
