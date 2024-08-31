/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cat_app;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import okio.ByteString;

/**
 *
 * @author alexcoronell
 */
public class CatService {

    public static void seeCat() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            // Delete "[" "]"
            responseString = responseString.substring(1, responseString.length());
            responseString = responseString.substring(0, responseString.length() - 1);
            // Create json
            Gson gson = new Gson();
            Cat cat = gson.fromJson(responseString, Cat.class);

            //Resize the  image
            Image image = null;
            try {
                URL url = new URL(cat.getUrl());
                image = ImageIO.read(url);
                ImageIcon backgroundCat = new ImageIcon(image);
                if (backgroundCat.getIconWidth() > 800) {
                    Image background = backgroundCat.getImage();
                    Image resizedImage = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                    backgroundCat = new ImageIcon(resizedImage);
                }

                String menu = "Options: \n"
                        + "1. See other images\n"
                        + "2. Favorite\n"
                        + "3. Back \n";

                String[] buttons = {"See the image", "Favorite", "Back"};
                String id = cat.getId();
                String option = (String) JOptionPane.showInputDialog(null, menu, id, JOptionPane.INFORMATION_MESSAGE, backgroundCat, buttons, buttons[0]);

                int selectOption = -1;

                for (int i = 0; i < buttons.length; i++) {
                    if (option.equals(buttons[i])) {
                        selectOption = i;
                    }
                    //selectOption = i;
                }

                switch (selectOption) {
                    case 0:
                        seeCat();
                        break;
                    case 1:
                        System.out.println("Call favorite");
                        favoriteCat(cat);
                    default:
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void seeFavorites() {
        String url = "https://api.thecatapi.com/v1/favourites";
        try {
            OkHttpClient client = new OkHttpClient();
            Cat cat = new Cat();
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .get()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            Gson gson = new Gson();
            System.out.println(responseString);
            FavoriteCat[] favoriteCats = gson.fromJson(responseString, FavoriteCat[].class);
            if (favoriteCats.length > 0) {
                int min = 1;
                int max = favoriteCats.length;
                int randomCat = (int) Math.random() * ((max - min) - 1) + min;
                int index = randomCat - 1;
                FavoriteCat favoriteCat = favoriteCats[index];
                System.out.println("Favorite: " + favoriteCat);
                
                //Resize the  image
                Image image = null;
                try {
                    URL imageCat = new URL(favoriteCat.imageCat.getUrl());
                    image = ImageIO.read(imageCat);
                    ImageIcon backgroundCat = new ImageIcon(image);
                    if (backgroundCat.getIconWidth() > 800) {
                        Image background = backgroundCat.getImage();
                        Image resizedImage = background.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                        backgroundCat = new ImageIcon(resizedImage);
                    }

                    String menu = "Options: \n"
                            + "1. See other image\n"
                            + "2. Delete Favorite\n"
                            + "3. Back \n";

                    String[] buttons = {"See the image", "Favorite", "Back"};
                    String id = favoriteCat.getId();
                    String option = (String) JOptionPane.showInputDialog(null, menu, id, JOptionPane.INFORMATION_MESSAGE, backgroundCat, buttons, buttons[0]);

                    int selectOption = -1;

                    for (int i = 0; i < buttons.length; i++) {
                        if (option.equals(buttons[i])) {
                            selectOption = i;
                        }
                        //selectOption = i;
                    }

                    switch (selectOption) {
                        case 0:
                            seeFavorites();
                            break;
                        case 1:
                            deleteFavorite(favoriteCat);
                        default:
                            break;
                    }
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                }

            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static void favoriteCat(Cat cat) {
        System.out.println("Save favorite");
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\"" + cat.getId() + "\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();

            Response response = client.newCall(request).execute();

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
    
    public static void deleteFavorite(FavoriteCat favoriteCat){
        System.out.println("Delete favorite");
        try {
            Cat cat = new Cat();
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\"" + cat.getId() + "\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites" + favoriteCat.getId())
                    .delete(null)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", cat.getApiKey())
                    .build();

            Response response = client.newCall(request).execute();

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}
