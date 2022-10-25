package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // TODO : plus propre via ressource ?

        // String inFileName = "C:\\Users\\DAM_004\\IdeaProjects\\IOSpliter\\src\\main\\resources\\BoissonData.csv";
        String resName = "BoissonData.csv"; // le nom du fichier ressource
        ArrayList<Boisson> boissonListe = new ArrayList<>(); // l'image du fichier
        UtilBoissons util = new UtilBoissons(); // la classe utilitaire

        boissonListe = util.loadFromFile(resName);

        // pour voir ce qu'on a lu
        util.display(boissonListe);

        // construire la liste des noms triée par nom à partir de l'ArrayListe de base
        List<String> sortedList = new ArrayList<>();
        sortedList = util.getNameListSortedByName(boissonListe);
        // afficher cette nouvelle liste
        for(String s:sortedList) {
            System.out.println(s);
        }


    }

}

//C:\Users\DAM_004\IdeaProjects\IOSpliter\src\main\resources\BoissonData.csv
//        String inFileName = "~/IdeaProjects/IOSpliter/src/main/resources/BoissonData.csv";
//        BufferedReader in = new BufferedReader(new FileReader(inFileName.replace("\\", "/")));
//        InputStream f = Main.class.getResourceAsStream("BoissonData.csv");

/*
        Product product = new Product(1,"titi",100);
        TreeSet<String> hs = new TreeSet<>();
        hs.add("toto");
        hs.add("titi");
        hs.add("tutu");
        hs.stream().filter(s -> )
*/

/*
        hs.add(44);
        hs.add(44);
        hs.add(product);
        hs.add(product);
        System.out.println("Exist ? = " + hs.contains("44"));
        System.out.println("Taille = " + hs.size());
*/
