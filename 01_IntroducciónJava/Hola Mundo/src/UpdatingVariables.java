public class UpdatingVariables {
    public static void main(String[] args) {
        int salary = 1000;

        //bono = $200
        salary = salary + 200;

        System.out.println(salary);

        // pensión: $50 descuento
        salary = salary - 50;
        System.out.println(salary);

        // 2 horas extras $30 c/u
        // Comida: $45 descuuento

        salary = salary + (30 * 2) - 45;
        System.out.println(salary);

        // Actualizando cadenas de texto
        String employeeName = "John Doe";
        employeeName = employeeName + " Doe";
        System.out.println("Your name is: " +  employeeName);
    }
}
