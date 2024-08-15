public class MathematicOperations {
    public static void main(String[] args) {
        double x = 2.1;
        double y = 3;

        System.out.println(Math.PI);
        System.out.println(Math.E);

        //Devuelve el número entero hacia arriba;
        System.out.println(Math.ceil(x)); // Redondeo hacia arriba

        //Devuelve el número entero hacia abajo;
        System.out.println(Math.floor(x));

        // Devuelve un número elevado a otro número;
        System.out.println(Math.pow(x, y));

        // Devuelve el número mayor
        System.out.println(Math.max(x, y));

        // Devuelve la raiz
        System.out.println(Math.sqrt(y));

        // Area de un círculo
        // Pi * radio al cuadrado
        System.out.println(Math.PI * Math.pow(y, 2));

        // Area de una esfera
        // 4 * Pi * radio al cuadrado
        System.out.println(4 * Math.PI * Math.pow(y, 2));

        // Volumen de una esfera
        // (4/3)*PI * radio al cubo
        System.out.println((4 / 3)  * Math.PI * Math.pow(y, 3));
    }
}
