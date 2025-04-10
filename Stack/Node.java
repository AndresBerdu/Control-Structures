public class Node {

    private int value;
    private Node target;

    public Node(int value) {
        this.value = value;
        this.target = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getTarget() {
        return target;
    }

    public void setTarget(Node target) {
        this.target = target;
    }
}