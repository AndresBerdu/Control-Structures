public class Node {
    
    private int value;
    private Node targetBehind;
    private Node targetFront;

    public Node (int value) {
        this.value = value;
        this.targetBehind = null;
        this.targetFront = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getTargetBehind() {
        return targetBehind;
    }

    public void setTargetBehind(Node targetBehind) {
        this.targetBehind = targetBehind;
    }

    public Node getTargetFront() {
        return targetFront;
    }

    public void setTargetFront(Node targetFront) {
        this.targetFront = targetFront;
    }
}
