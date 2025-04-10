import javax.swing.JOptionPane;

public class Stack {

    private int size = 0;
    private Node top;
    private Node bottom;

    //Method for show all elements in the stack
    public void showStack() {

        Node currentNode = bottom;
        String stack = ""; //variable to show stack in the panel

        if (!voidStack()) {
            if (top == bottom) {
                JOptionPane.showMessageDialog(null, 
                    bottom.getValue()
                );
            } else {
                System.out.println(bottom.getValue());
                stack = String.valueOf(bottom.getValue()); //Method for convert int to string
                while (currentNode.getTarget() != null) {
                    currentNode = currentNode.getTarget();
                    String currentNodeString = String.valueOf(currentNode.getValue());
                    stack+= "\n" + currentNodeString;
                } 
                JOptionPane.showMessageDialog(null, stack);
            }

        } else {
            JOptionPane.showMessageDialog(null, "The stack is void");
        }
    }

    //Method for delete the top of stack
    public void deleteTop() {

        Node currentNode = bottom;

        if(voidStack()) {
            JOptionPane.showMessageDialog(null, "The stack is void");
        } else {
            if(top == bottom) {
                top = null;
                bottom = null;
                decreaseSize();
                JOptionPane.showMessageDialog(null, "The top has been delete successfully");
            } else {
                while (currentNode.getTarget() != null) {
                    if(currentNode.getTarget() == top) {
                        currentNode.setTarget(null);
                        decreaseSize();
                    } else {
                        currentNode = currentNode.getTarget();
                    }
                }
                JOptionPane.showMessageDialog(null, "The top has been delete successfully");
            }
        }
    }

    //Method for show the top of stack
    public int showTop() {
        return top.getValue();
    }

    //Method for show the bottom of stack
    public int showBottom() {
        return bottom.getValue();
    }

    //Method if the stack that is void
    private boolean voidStack() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Method for increment size
    private void increaseSize() {
        size++;
    }

    //Method for decrease size
    private void decreaseSize() {
        size--;
    }

    //Method for add element in the stack
    public void addNode(int value) {
        Node node = new Node(value);

        if (voidStack()) {
            top = node;
            bottom = node;
        } else {
            if(bottom.getTarget() == null) {
                bottom.setTarget(node);
                top = node;
            } else {
                top.setTarget(node);
                top = node;
            }
        }

        increaseSize();
    }
}
