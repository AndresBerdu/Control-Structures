import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {

        int opcion = 9;
        int flag = 1;

        Queue queue = new Queue();

        while (flag != 0) {
            while (opcion != 0) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Show queue \n" +
                                "2.Add element to queue \n" +
                                "3.Delete element of the form lifo \n" +
                                "4.Search element for its positon \n" +
                                "5.Get The first element \n" +
                                "6.Get the last element \n" +
                                "0.Exit"));

                switch (opcion) {
                    case 1:
                        queue.showQueue();
                        break;
                    case 2:
                        int element = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Add the element:"));
                        queue.addElement(element);
                        break;
                    case 3:
                        queue.deleteLifo();
                        break;
                    case 4:
                        int index = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Write the index:"));
                        queue.searchByIndex(index);
                        break;
                    case 5:
                        queue.getFirstElement();
                        break;
                    case 6:
                        queue.getLastElement();
                        break;
                    case 0:
                        opcion = 0;
                        flag = 0;
                        break;
                }
            }
        }
    }
}