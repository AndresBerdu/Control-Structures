import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int opcion = 9;
        int flag = 1;

        Stack stack = new Stack();

        while (flag != 0) {
            while (opcion != 0) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Show Stack\n" +
                        "2.Add element to stack\n" +
                        "3.Delete top element to stack\n" +
                        "4.Show the top element of stack\n" +
                        "5.Show the bottom element of stack\n" +
                        "0.Exit\n"));

                switch (opcion) {
                    case 1:
                        stack.showStack();
                        break;
                    case 2:
                        int value = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el valor del nodo"));
                        stack.addNode(value);
                        break;
                    case 3: 
                        stack.deleteTop();
                        break;
                    case 4: 
                        stack.showTop();
                        break;
                    case 5: 
                        stack.showBottom();
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
