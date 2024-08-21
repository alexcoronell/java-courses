package com.platzi.functional._14_optionals;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        List<String > names = getNames();
        if(names != null) {
            return;
        }

        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){
            return;
        }

        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));
        Optional<String> valuablePlayer = optionalValuablePlayer();

        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No player");
    }

    static List<String> getNames(){
        List<String> list = new LinkedList<>();

        return Collections.emptyList();
    }

    static String mostValuablePlayer(){
        // return "";
        return null;
    }

    static int mostExpensiveItem(){
        return -1;
    }

    //Mismas funciones con Optionals
    static Optional<List<String>> getOptionalNames(){
        List<String> namesList = new LinkedList<>();
        return Optional.of(namesList);
    }

    static Optional<String> optionalValuablePlayer(){
        //return Optional.ofNullable()
        try {
            // Example Access Database
            return Optional.of("Data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
