package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UtilBoissons implements iListUtils {

    public void display(ArrayList<Boisson> plList){
        for(Boisson p:plList){
            System.out.println("ID = " + p.getId() + "/"
                    + "NOM = " + p.getName() + "/"
                    + "PRIX = " + p.getPrice()
            );
        }

    }

    public ArrayList<Boisson> loadFromFile(String resName) {
        ArrayList<Boisson> plList = new ArrayList<>(); // objet que l'on renverra apres construction
        String l;
        BufferedReader inFile=null; // handle du fichier (ressource)

        try {

            // Ouvrir le fichier ressource -> inFile (Voir la doc des méthodes pour le detail)
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(resName);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            inFile = new BufferedReader(streamReader);

            // on boucle sur les lignes du fichiers et on ajoute les boissons à l'ArrayList
            while ((l = inFile.readLine()) != null) {
                String t[] = l.split(";");
                int id = Integer.parseInt(t[0]);
                String name = t[1];
                int price = Integer.parseInt(t[2]);
                plList.add(new Boisson(id, name, price));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (inFile != null) {
                // try imbriqué, car on passe toujours ici (finally), or çà peut aussi planter
                try {
                    inFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return plList;
        }


    }
    public List<String> getNameListSortedByName(ArrayList<Boisson> plList){
//        List<String> productListeName;
        List<String> productListeSortedByName;
        // compareTo est définit dans Boisson
        productListeSortedByName = plList.stream().sorted(Boisson::compareTo).map(Boisson::getName).toList();
        return productListeSortedByName;
/*
        // ancienne version contournant la difficulté du sorted(...) mais fonctionnant dans ce cas
        productListeName = plList.stream().map(Product::getName).toList();
        productListeSortedByName = productListeName.stream().sorted().toList();
*/
    }

}



//            inFile = new BufferedReader(new FileReader(inFileName));
//            inFile = new BufferedReader(new FileReader(String.valueOf(this.getClass().getResource("BoissonData.csv"))));
/*
            URL resource = getClass().getClassLoader().getResource(resName);
            inFile = new BufferedReader(new FileReader(String.valueOf(resource)));
*/
/*
        URL resource = getClass().getClassLoader().getResource(resName);
        InputStream  toto = InputStreamReader streamReader =
                new InputStreamReader(is, StandardCharsets.UTF_8);
        inFile = new BufferedReader(new InputStreamReader(toto));
        System.out.println(String.valueOf(resource));
*/