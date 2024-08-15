public class Casting {
    public static void main(String[] args) {

        // En un año ubiqué en hogares 30 perritos
        // Cuantos perritos ubiqué al mes

        double monthlyDogs = 30.0 / 12.0;
        System.out.println(monthlyDogs);

        // Estimación
        int estimatedMonthlyDogs = (int) monthlyDogs;
        System.out.println(estimatedMonthlyDogs);

        // Exactitud
        int a = 30;
        int b = 12;

        System.out.println((double) a/b);

        double c = (double) a / b;
        System.out.println(c);

        char nChar = '1';
        int nInt = nChar;

        System.out.println(nInt);

        short nS = (short) nChar;
        System.out.println(nS);
    }
}
