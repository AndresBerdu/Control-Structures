import java.util.Currency;

import javax.swing.JOptionPane;

public class SimpleList {

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    // Methode for show list
    public void showSimpleList() {

        Node currentNode = firstNode;
        String simpleListString = "";

        if (!isVoid()) {
            while (currentNode.getTarget() != null) {
                String transform = String.valueOf(currentNode.getValue());
                simpleListString = simpleListString + transform + " ";
                currentNode = currentNode.getTarget();
            }

            simpleListString = simpleListString + String.valueOf(lastNode.getValue());
            JOptionPane.showMessageDialog(null, simpleListString);
        } else {
            JOptionPane.showMessageDialog(null, "The simple list is void");
        }
    }

    // Methode for add element in the last node
    public void addLast(int value) {

        Node node = new Node(value);

        if (isVoid()) {
            firstNode = node;
            lastNode = node;
            increaseSize();
        } else {
            lastNode.setTarget(node);
            lastNode = node;
            increaseSize();
        }
    }

    // Methode for add element in the first node
    public void addFirst(int value) {

        Node node = new Node(value);

        if (isVoid()) {
            firstNode = node;
            lastNode = node;
            increaseSize();
        } else {
            node.setTarget(firstNode);
            firstNode = node;
            increaseSize();
        }
    }

    // Methode for Add after the element
    public void addAfterElement(int value, int elementTarget) {

        Node currentNode = firstNode;
        Node node = new Node(value);

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "Be can't add the element, the list is void");
        } else {
            if (elementTarget == lastNode.getValue()) {
                lastNode.setTarget(node);
                lastNode = node;
                increaseSize();
            } else {
                while (currentNode.getTarget() != null) {
                    if (currentNode.getValue() == elementTarget) {
                        node.setTarget(currentNode.getTarget());
                        currentNode.setTarget(node);
                        currentNode = currentNode.getTarget();
                        increaseSize();
                    } else {
                        currentNode = currentNode.getTarget();
                    }
                }
            }
        }
    }

    // Methode for Add before the element
    public void addBeforeElement(int value, int elementTarget) {

        Node currentNode = firstNode;
        Node nextNode = firstNode.getTarget();
        Node node = new Node(value);

        if (isVoid()) {
            JOptionPane.showMessageDialog(null,
                    "Be can't add the element, the list is void");
        } else {
            if (elementTarget == firstNode.getValue()) { // Check if target is equals to firts node
                node.setTarget(firstNode);
                firstNode = node;
                increaseSize();
            } else if (elementTarget == lastNode.getValue()) { // Check if target is equals to last node
                while (currentNode != lastNode) {
                    if (currentNode.getTarget() == lastNode) {
                        node.setTarget(lastNode);
                        currentNode.setTarget(node);
                        increaseSize();
                        break;
                    } else {
                        currentNode = currentNode.getTarget();
                    }
                }
            } else {
                while (nextNode.getTarget() != null) {
                    if (nextNode.getValue() == elementTarget) {
                        node.setTarget(nextNode);
                        currentNode.setTarget(node);
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                        increaseSize();
                        break;
                    } else {
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            }
        }
    }

    // Methode for delete first element
    public void deleteFirstElement() {

        Node nextNode = firstNode.getTarget();

        if (!isVoid()) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
                decreaseSize();
            } else {
                firstNode = null;
                firstNode = nextNode;
                decreaseSize();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Be can't delete the element, the list is void");
        }
    }

    // Methode for delete first element
    public void deleteLastElement() {

        Node currNode = firstNode;
        Node nextNode = firstNode.getTarget();

        if (!isVoid()) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
                decreaseSize();
            } else {
                while (currNode != lastNode) {
                    if (nextNode == lastNode) {
                        currNode.setTarget(null);
                        lastNode = currNode;
                        decreaseSize();
                    } else {
                        currNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Be can't delete the element, the list is void");
        }
    }

    public void searchElementDelete(int value) {

        Node currentNode = firstNode;
        Node nextNode = firstNode.getTarget();

        if (!isVoid()) {
            if (value == firstNode.getValue()) {
                currentNode.setTarget(null);
                firstNode = nextNode;
                decreaseSize();
            } else if (value == lastNode.getValue()) {
                while (currentNode != lastNode) {
                    if (value == nextNode.getValue()) {
                        currentNode.setTarget(null);
                        lastNode = currentNode;
                        decreaseSize();
                        break;
                    } else {
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            } else {
                while (currentNode != lastNode) {
                    if (value == nextNode.getValue()) {
                        currentNode.setTarget(nextNode.getTarget());
                        nextNode.setTarget(null);
                        decreaseSize();
                        break;
                    } else {
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Be can't delete the element, the list is void");
        }
    }

    public void changeElement(int value, int target) {

        Node currentNode = firstNode;
        Node nextNode = firstNode.getTarget();

        if (!isVoid()) {
            if (target == firstNode.getValue()) {
                currentNode.setValue(value);
            } else if (target == lastNode.getValue()) {
                while (currentNode != lastNode) {
                    if(target == nextNode.getValue()) {
                        nextNode.setValue(value);
                        break;
                    } else {
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            } else {
                while (currentNode.getTarget() != null) {
                    if(target == currentNode.getValue()) {
                        currentNode.setValue(value);
                        break;
                    } else {
                        currentNode = nextNode;
                        nextNode = nextNode.getTarget();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Be can't delete the element, the list is void");
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
