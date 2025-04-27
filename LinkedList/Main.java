import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {

        LinkedList likedList = new LinkedList();

        int option = 10000;

        while (option != 0) {

            option = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1.Show linkedList\n" +
                            "2.Show inverse linkedList\n" +
                            "3.Add element in first position\n" +
                            "4.Add element in last position\n" +
                            "5.Add element after the element\n" +
                            "6.Add element before the element\n" +
                            "7.Delete first element\n" +
                            "8.Delete last element\n" +
                            "9.Delete element\n" +
                            "10.change an element\n" +
                            "0.exit\n"));

            switch (option) {
                case 1:
                    likedList.showLinkedList();
                    break;
                case 2:
                    likedList.showInverseLinkedList();
                    break;
                case 3:
                    int valueFirst = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the value"));
                    likedList.addFirstPosition(valueFirst);
                    break;
                case 4:
                    int valueLast = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the value"));
                    likedList.addLastPosition(valueLast);
                    break;
                case 5:
                    int valueAfter = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the value"));
                    int targetAfter = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the target"));
                    likedList.addElementAfter(valueAfter, targetAfter);
                    break;
                case 6:
                    int valueBefore = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the value"));
                    int targetBefore = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the target"));
                    likedList.addElementBefore(valueBefore, targetBefore);
                    break;
                case 7:
                    likedList.deleteFirstElement();
                    break;
                case 8:
                    likedList.deleteLastElement();
                    break;
                case 9:
                    int targetDelete = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Write the target"));
                    likedList.deleteElement(targetDelete);
                    break;
                case 10:
                    break;
                case 0:
                    break;
            }
        }
    }
}