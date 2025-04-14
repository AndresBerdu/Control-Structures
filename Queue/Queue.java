import javax.swing.JOptionPane;

public class Queue {

    private Node firstNode;
    private Node LastNode;
    private int size = 0;

    // Methode for show values in the queue
    public void showQueue() {

        Node currentNode = firstNode;
        String nodesString = "";

        if (!queueIsVoid()) {
            while (currentNode.getTarget() != null) {
                String transform = String.valueOf(currentNode.getValue());
                nodesString = nodesString + transform + " ";
                currentNode = currentNode.getTarget();
            }
            nodesString = nodesString + String.valueOf(LastNode.getValue());
            JOptionPane.showMessageDialog(null, nodesString);

        } else {
            JOptionPane.showMessageDialog(null, "The queue is void");
        }
    }

    // Methode if the queue is void
    private boolean queueIsVoid() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Method for add element to queue
    public void addElement(int value) {

        Node node = new Node(value);

        if (queueIsVoid()) {
            firstNode = node;
            LastNode = node;
            increaseSize();
        } else {
            if (firstNode.getTarget() == null) {
                firstNode.setTarget(node);
                LastNode = node;
                increaseSize();
            } else {
                LastNode.setTarget(node);
                LastNode = node;
                increaseSize();
            }
        }
    }

    // Methode for delete of form lifo
    public void deleteLifo() {

        Node currentNode = firstNode;
        Node nextNode = firstNode.getTarget();

        if (firstNode == LastNode) {
            firstNode = null;
            LastNode = null;

            JOptionPane.showMessageDialog(null,
                    "The element has been delete successfully");
            decreaseSize();
        } else {
            while (currentNode.getTarget() != null) {
                if (nextNode.getTarget() == null) {
                    LastNode = currentNode;
                    currentNode.setTarget(null);
                    JOptionPane.showMessageDialog(null,
                            "The element has been delete successfully");
                    decreaseSize();
                } else {
                    currentNode = nextNode;
                    nextNode = nextNode.getTarget();
                }
            }
        }
    }

    // Methode for search element for the position in the queue
    public void searchByIndex(int position) {

        Node currentNode = firstNode;
        int count = 0;

        if (!queueIsVoid()) {
            if (position > size) {
                JOptionPane.showMessageDialog(null,
                        "The position is greater than the queue");
            } else {
                while (count < size) {

                    count++;

                    if (count == position) {
                        int element = currentNode.getValue();
                        JOptionPane.showMessageDialog(null,
                                "The value of position is " + element);
                    } else {
                        currentNode = currentNode.getTarget();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "The queue is void");
        }
    }

    // Methode for show the first element
    public void getFirstElement() {
        if (queueIsVoid()) {
            JOptionPane.showMessageDialog(null, "The queue is void");
        } else {
            JOptionPane.showMessageDialog(null, "The first element of the queue is: " +
                    firstNode.getValue());
        }
    }

    // Methode for show the last element
    public void getLastElement() {
        if (queueIsVoid()) {
            JOptionPane.showMessageDialog(null, "The queue is void");
        } else {
            JOptionPane.showMessageDialog(null, "The last element of the queue is: " +
                    LastNode.getValue());
        }
    }

    // Methode for increase the size of queue
    private void increaseSize() {
        size++;
    }

    // Methode for decrease the size of queue
    private void decreaseSize() {
        size--;
    }
}
