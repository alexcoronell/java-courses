public class Arrays {
    public static void main(String[] args) {
        String[] androidVersions = new String[17]; //Limitado al tamaño indicado al declarar
        String days[] = new String[7];

        /*
         * +------------------------+
         * | Country  | City        |
         * | México   | CDMX        |
         * | México   | Guadalajara |
         * | Colombia | Bogotá      |
         * | Colombia | Medellín    |
         * +------------------------+
         */
        String[][] cities = new String[4][2];

        // Arreglo de 3 dimensiones
        int[][][] numbers = new int[2][2][2];

        // Arreglo de 4 dimensiones
        int[][][][] numbers4 = new int[2][2][2][2];

        androidVersions[0] = "Apple Pie";
        androidVersions[1] = "Banana Bread";
        androidVersions[2] = "Cupcake";
        androidVersions[3] = "Donut";
        System.out.println(androidVersions[0]);
        System.out.println(androidVersions[1]);
        System.out.println(androidVersions[2]);
        System.out.println(androidVersions[3]);
        System.out.println();
        System.out.println();

        cities[0][0] = "Colombia";
        cities[0][1] = "Medellín";
        cities[1][0] = "Colombia";
        cities[1][1] = "Bogotá";
        cities[2][0] = "México";
        cities[2][1] = "Guadalajara";
        cities[3][0] = "México";
        cities[3][1] = "MXCD";

        System.out.println(cities[0][0]);
        System.out.println(cities[0][1]);
        System.out.println(cities[1][0]);
        System.out.println(cities[1][1]);
        System.out.println(cities[2][0]);
        System.out.println(cities[2][1]);
        System.out.println(cities[3][0]);
        System.out.println(cities[3][1]);

        String[][][][] animals = new String[2][3][2][2];
        animals[1][0][0][1] = "Monkey";
        System.out.println();
        System.out.println();
        System.out.println(animals[1][0][0][1]);
        System.out.println();
        System.out.println("***************************************");


        // bucles For
        System.out.println("Bucles For");
        System.out.println("*** Android versions ***");
        for (int i = 0; i < androidVersions.length; i++) {
            if (androidVersions[i] != null) {
                System.out.println(androidVersions[i]);
            }
        }
        for(String[] pair : cities){
            for (String name : pair){
                System.out.println(name);
            }
        }


        System.out.println("*** Cities ***");
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[i].length; j++) {
                System.out.println("Country: " + cities[i][0] + " City: " + cities[i][j]);
            }
        }

        // Arreglo de 4 dimenciones
        for (int i = 0; i < animals.length; i++) {
            for (int j = 0; j < animals[i].length; j++) {
                for (int k = 0; k < animals[i][j].length; k++) {
                    for (int l = 0; l < animals[i][j][k].length; l++) {
                        System.out.println(animals[i][j][k][l]);
                    }
                }
            }
        }

        // FOREACH
        for(String androidVersion : androidVersions){
            System.out.println(androidVersion);
        }

    }
}
