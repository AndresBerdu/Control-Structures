import javax.swing.JOptionPane;

public class LinkedList {

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public void showLinkedList() {

        Node currentNode = firstNode;
        String stringLinkedList = "";

        if (!isVoid()) {
            while (currentNode.getTargetFront() != null) {
                String number = String.valueOf(currentNode.getValue());
                stringLinkedList = stringLinkedList + number + " ";
                currentNode = currentNode.getTargetFront();
            }

            stringLinkedList = stringLinkedList + String.valueOf(lastNode.getValue());
            JOptionPane.showMessageDialog(null, stringLinkedList);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The linkedList has been void");
        }
    }

    public void showInverseLinkedList() {
        Node currentNode = lastNode;
        String stringLinkedList = "";

        if (!isVoid()) {
            while (currentNode.getTargetBehind() != null) {
                String number = String.valueOf(currentNode.getValue());
                stringLinkedList = stringLinkedList + number + " ";
                currentNode = currentNode.getTargetBehind();
            }

            stringLinkedList = stringLinkedList + String.valueOf(firstNode.getValue());
            JOptionPane.showMessageDialog(null, stringLinkedList);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The linkedList has been void");
        }
    }

    public void addFirstPosition(int value) {

        Node node = new Node(value);

        if (isVoid()) {
            firstNode = node;
            lastNode = node;
            increaseSize();
        } else {
            firstNode.setTargetBehind(node);
            node.setTargetFront(firstNode);
            firstNode = node;
            increaseSize();
        }
    }

    public void addLastPosition(int value) {

        Node node = new Node(value);

        if (isVoid()) {
            firstNode = node;
            lastNode = node;
            increaseSize();
        } else {
            node.setTargetBehind(lastNode);
            lastNode.setTargetFront(node);
            lastNode = node;
            increaseSize();
        }
    }

    public void addElementAfter(int value, int target) {

        Node node = new Node(value);
        Node currentNode = firstNode;
        Node nextNode = firstNode.getTargetFront();

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "The linkendList has been void, you need minimus one number in the list");

            return;
        }

        if (firstNode == lastNode) {
            currentNode.setTargetFront(node);
            node.setTargetBehind(currentNode);
            lastNode = node;
            increaseSize();

            return;
        }

        if (target == lastNode.getValue()) {
            lastNode.setTargetFront(node);
            node.setTargetBehind(lastNode);
            lastNode = node;

            increaseSize();
            return;
        }

        while (nextNode.getTargetFront() != null) {
            if (currentNode.getValue() == target) {
                currentNode.setTargetFront(node);
                node.setTargetBehind(currentNode);
                nextNode.setTargetBehind(node);
                node.setTargetFront(nextNode);

                increaseSize();
                break;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.getTargetFront();
            }

        }
    }

    public void addElementBefore(int value, int target) {

        Node node = new Node(value);
        Node currentNode = firstNode;
        Node nextNode = firstNode.getTargetFront();

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "The linkendList has been void, you need minimus one number in the list");

            return;
        }

        if (firstNode == lastNode || target == firstNode.getValue()) {
            currentNode.setTargetBehind(node);
            node.setTargetFront(currentNode);
            firstNode = node;
            increaseSize();

            return;
        }

        while (currentNode != lastNode) {
            if (nextNode.getValue() == target) {
                node.setTargetFront(nextNode);
                nextNode.setTargetBehind(node);
                node.setTargetBehind(currentNode);
                currentNode.setTargetFront(node);
                increaseSize();

                break;
            } else {
                currentNode = nextNode;
                nextNode = nextNode.getTargetFront();
            }
        }

    }

    public void deleteFirstElement() {

        Node nextNode = firstNode.getTargetFront();

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "The linkendList has been void");
        }

        if (firstNode == lastNode) {
            firstNode.setTargetFront(null);
            firstNode.setTargetBehind(null);
            lastNode.setTargetFront(null);
            lastNode.setTargetBehind(null);
            decreaseSize();
        } else {
            firstNode.setTargetFront(null);
            nextNode.setTargetBehind(null);
            firstNode = nextNode;
            decreaseSize();
        }
    }

    public void deleteLastElement() {

        Node pastNode = lastNode.getTargetBehind();

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "The linkendList has been void");

            return;
        }

        if (firstNode == lastNode) {
            firstNode.setTargetFront(null);
            firstNode.setTargetBehind(null);
            lastNode.setTargetFront(null);
            lastNode.setTargetBehind(null);
            decreaseSize();
        } else {
            lastNode.setTargetBehind(null);
            pastNode.setTargetFront(null);
            lastNode = pastNode;
            decreaseSize();
        }
    }

    public void deleteElement(int target) {

        Node currentNode = firstNode;

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "The linkendList has been void");

            return;
        }

        if (firstNode == lastNode) {
            firstNode.setTargetFront(null);
            firstNode.setTargetBehind(null);
            lastNode.setTargetFront(null);
            lastNode.setTargetBehind(null);
            decreaseSize();

            return;
        }

        if (target == firstNode.getValue()) {

            Node nextNode = firstNode.getTargetFront();

            firstNode.setTargetFront(null);
            firstNode = nextNode;
            firstNode.setTargetBehind(null);
            decreaseSize();

            return;
        }

        if (target == lastNode.getValue()) {

            Node pasNode = lastNode.getTargetBehind();

            lastNode.setTargetBehind(null);
            lastNode = pasNode;
            lastNode.setTargetFront(null);
            decreaseSize();
            
            return;
        }

        while (currentNode != null) {
            if (target == currentNode.getValue()) {
                Node nextNode = currentNode.getTargetFront();
                Node pastNode = currentNode.getTargetBehind();

                currentNode.setTargetFront(null);
                currentNode.setTargetBehind(null);

                pastNode.setTargetFront(nextNode);
                nextNode.setTargetBehind(pastNode);
                decreaseSize();

                break;
            } else {
                currentNode = currentNode.getTargetFront();
            }
        }
    }

    private boolean isVoid() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void increaseSize() {
        size++;
    }

    private void decreaseSize() {
        size--;
    }
}
