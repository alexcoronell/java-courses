public class WhileLoop {

    static boolean isTurnOnLight = false;

    public static void main(String[] args) {
        var on = turnOnOffLight();
        int i = 1;
        while(on && (i <= 10)) {
            printSOS();
            i++;
        }
    }

    public static void printSOS(){
        System.out.println("... ___ ...");
    }

    public static boolean turnOnOffLight(){
        // Operador ternario
        //isTurnOnLight = (isTurnOnLight) ? false : true;
        isTurnOnLight = !isTurnOnLight;
        return isTurnOnLight;
    }
}
