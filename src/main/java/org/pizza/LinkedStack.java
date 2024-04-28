package org.pizza;
import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack < T > implements StackInterface < T > {
    private Node topNode; // References the first node in the chain

    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack() {
        topNode = null;
    } // end default constructor

    /**
     * Adds a new entry to the top of this stack.
     * @param newEntry the object to be added as a new entry
     */
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } // end push

    /**
     * Retrieves this stack's top entry.
     * @return the object at the top of the stack
     * @throws EmptyStackException if this stack is empty
     */
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek

    /**
     * Removes and returns this stack's top entry.
     * @return the object that was removed from the top of the stack
     * @throws EmptyStackException if this stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node oldNode = topNode;
            topNode = oldNode.getNextNode();
            return oldNode.getData();
        } // end if
    } // end pop

    /**
     * Checks whether this stack is empty.
     * @return true if this stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return topNode == null;
    } // end isEmpty

    /**
     * Removes all entries from this stack.
     */
    public void clear() {
        topNode = null;
    } // end clear

    /**
     * Converts the given infix expression to postfix notation.
     * @param infixExpression the infix expression to be converted
     * @return the postfix expression
     */
    public static String convertToPostfix(String infixExpression) {
        // Stack to hold operators
        LinkedStack < Character > operatorStack = new LinkedStack < Character > ();

        // StringBuilder to store the postfix expression
        StringBuilder postfixExpression = new StringBuilder();

        // Iterate through each character 
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            // If character is a letter or a digit, add it to postfix 
            if (Character.isLetterOrDigit(currentChar)) {
                postfixExpression.append(currentChar);
            }
            // If character is a power operator, push it onto the stack
            else if (currentChar == '^') {
                operatorStack.push(currentChar);
            }
            // If character is an opening parenthesis, push it onto the stack
            else if (currentChar == '(') {
                operatorStack.push(currentChar);
            }
            // If character is a closing parenthesis
            else if (currentChar == ')') {
                // Pop operators from stack and append to postfix expression until an opening parenthesis is found
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.append(operatorStack.pop());
                }
                // Pop opening parenthesis from the stack
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                }
            }
            // If character is an operator
            else if (isOperator(currentChar)) {
                // Pop operators from the stack and append to the postfix expression 
                while (!operatorStack.isEmpty() && precedence(currentChar) <= precedence(operatorStack.peek())) {
                    postfixExpression.append(operatorStack.pop());
                }
                // Push  current operator onto the stack
                operatorStack.push(currentChar);
            }
            System.out.println(postfixExpression);
        }

        // Pop any remaining operators from the stack and append to the postfix 
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
        }

        // Return the postfix expression as a string
        return postfixExpression.toString();
    }

    /**
     * Determines the precedence of an operator.
     * @param operator the operator to determine precedence
     * @return the precedence level of the operator
     */
    private static int precedence(char operator) {
        switch (operator) {
        case '^':
            return 3;
        case '*':
        case '/':
            return 2;
        case '+':
        case '-':
            return 1;
        default:
            return 0;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    /**
     * Represents a node in the stack.
     */
    private class Node {
        private T data; // Entry in stack
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
} // end LinkedStack