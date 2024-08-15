public class LogicOperations {
    public static void main(String[] args) {
        int a = 8;
        int b = 5;

        System.out.println("Operadores de equidad");
        System.out.println("a == b => " + (a == b));
        System.out.println("a != b => " + (a != b));

        System.out.println("Operadores relacionales");
        System.out.println("a > b => " + (a > b));
        System.out.println("a < b => " + (a < b));
        System.out.println("a >= b => " + (a >= b));
        System.out.println("a <= b => " + (a <= b));

        if(a == b) {
            System.out.println("A es igual a B");
        } else if (a != b) {
            System.out.println("A es diferente a B");
        } else if (a > b) {
            System.out.println("A es mayor a B");
        } else if (a < b) {
            System.out.println("A es menor a B");
        } else if (a >= b) {
            System.out.println("A es mayor o igual a B");
        } else if (a <= b) {
            System.out.println("A es menor o igual a B");
        }

        if(a == b) {
            System.out.println("A es igual a B");
        } else if ((a != b && (a > b))) {
            System.out.println("A es diferente y mayor a B");
        }else if ((a != b && (a < b))) {
            System.out.println("A es diferente y menor a B");
        }

    }
}
