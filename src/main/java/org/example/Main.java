package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // TODO : plus propre via ressource ?

        // String inFileName = "C:\\Users\\DAM_004\\IdeaProjects\\IOSpliter\\src\\main\\resources\\ProductData.csv";
        String resName = "ProductData.csv";
        ArrayList<Boisson> boissonListe = new ArrayList<>();
        UtilBoissons util = new UtilBoissons();
//        productListe.loadFromFile(inFileName);
        boissonListe = util.loadFromFile(resName);
        util.display(boissonListe);
        List<String> sortedList = new ArrayList<>();
        sortedList = util.getNameListSortedByName(boissonListe);

        for(String s:sortedList) {
            System.out.println(s);
        }


    }

}

//C:\Users\DAM_004\IdeaProjects\IOSpliter\src\main\resources\ProductData.csv
//        String inFileName = "~/IdeaProjects/IOSpliter/src/main/resources/ProductData.csv";
//        BufferedReader in = new BufferedReader(new FileReader(inFileName.replace("\\", "/")));
//        InputStream f = Main.class.getResourceAsStream("ProductData.csv");

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
