/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cat_app;

import javax.swing.JOptionPane;

/**
 *
 * @author alexcoronell
 */
public class Cat_app {

    public static void main(String[] args) {
        int optionMenu = -1;
        String[] buttons = {
            "1. - See cat",
            "2. - See Favorites",
            "3. - Exit"
        };

        do {
            //Main Menu
            String option = (String) JOptionPane.showInputDialog(null, "Little Java Cats", "Menu", JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
            for (int i = 0; i < buttons.length; i++) {
                if (option.equals(buttons[i])) {
                    optionMenu = i;
                }
            }
            switch (optionMenu) {
                case 0:
                    CatService.seeCat();
                    break;
                case 1:
                    CatService.seeFavorites();
                    break;
                default:
                    break;
            }
        } while (optionMenu != 1);
    }
}
