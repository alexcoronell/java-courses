public class IncrementDecrement {
    public static void main(String[] args) {

        int lives = 5;
        lives = lives -1;
        System.out.println(lives);

        // Decrement
        lives--;
        System.out.println(lives);

        // Incremento
        lives++;
        System.out.println(lives);

        //Prefija
        // Gana un regalo por ganar una vida;
        int gift = 100 + lives++; // Se accede al dato anterior de la variable lives;
        System.out.println(gift);
        System.out.println(lives); // Ya incrementó

        int gift2 = 100 + ++lives; // Se accede al dato ya incrementado
        System.out.println(gift2);
        System.out.println(lives);

    }
}
