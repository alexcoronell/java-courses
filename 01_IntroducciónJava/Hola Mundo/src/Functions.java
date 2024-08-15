public class Functions {
    public static void main(String[] args) {
        double y = 6;

        double area = circleArea(y);
        double aSphere = sphereArea(y);
        double vSphere = sphereVolume(y);
        System.out.println("The circle area is: " + area);
        System.out.println("The sphere area is: " + aSphere);
        System.out.println("The sphere volume is: " + vSphere);

        System.out.println("COP " + convertToPesos(920, "COP"));
        System.out.println("MXN " + convertToPesos(920, "MXN"));
        System.out.println("COP => Dollar " + convertToDolar(1000000, "COP"));
        System.out.println("MXN => Dollar " + convertToDolar(1000000, "MXN"));
    }

    // Static solo cuando se comparte el método main
    public static double circleArea(double r) {
        return Math.PI * Math.pow(r, 2);
    }

    public static double sphereArea(double r) {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    public  static double sphereVolume(double r){
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    public static double convertToPesos(double quantity, String currency){
        switch (currency) {
            case "MXN":
                quantity *= 18.83;
                break;
            case "COP":
                quantity *= 4016;
                break;
        }
        return quantity;
    }

    /**
     * Descripción: Función que especificando su moneda convierte una cantidad de moneda a dolares
     * @param quantity Cantidad de dinero
     * @param currency Tipo de Moneda: Sólo acepta MXN o COP
     * @return quantity Devuelve la cantidad actualizada en dólares
     */
    public static double convertToDolar(double quantity, String currency){
        switch (currency) {
            case "MXN":
                quantity /= 18.83;
                break;
            case "COP":
                quantity /= 4016;
                break;
        }
        return quantity;
    }

}
