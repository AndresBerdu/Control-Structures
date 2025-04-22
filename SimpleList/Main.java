import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int option = 9;
        int flag = 1;

        SimpleList simpleList = new SimpleList();

        while (flag != 0) {
            while (option != 0) {
                option = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Show simple list\n" +
                                "2.Add element in the last position\n" +
                                "3.Add element in the first position\n" +
                                "4.Add element after the other element\n" +
                                "5.Add element before the other element\n" +
                                "6.Delete first element\n" +
                                "7.Delete last element\n" +
                                "8.Search element and delete\n" +
                                "9.Search element and change\n" +
                                "0.Exit\n"));

                switch (option) {
                    case 1:
                        simpleList.showSimpleList();
                        break;
                    case 2:
                        int valueLast = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of element"));
                        simpleList.addLast(valueLast);
                        break;
                    case 3:
                        int valueFirst = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of element"));
                        simpleList.addFirst(valueFirst);
                        break;
                    case 4:
                        int valueAfter = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of element"));
                        int elementTargetAfter = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of target"));
                        simpleList.addAfterElement(valueAfter, elementTargetAfter);
                        break;
                    case 5:
                        int valueBefore = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of element"));
                        int elementTargetBefore = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of target"));
                        simpleList.addBeforeElement(valueBefore, elementTargetBefore);
                        break;
                    case 6:
                        simpleList.deleteFirstElement();
                        break;
                    case 7:
                        simpleList.deleteLastElement();
                        break;
                    case 8:
                        int elementSearchDelete = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of target"));
                        simpleList.searchElementDelete(elementSearchDelete);
                        break;
                    case 9:
                        int elementChange = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value"));
                        int elementChangeTarget = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the value of target"));
                        simpleList.changeElement(elementChange, elementChangeTarget);
                        break;
                    case 0:
                        option = 0;
                        flag = 0;
                        break;

                }
            }
        }
    }
}
