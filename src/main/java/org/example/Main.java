package org.example;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // TODO : plus propre via ressource ?
        String inFileName = "C:\\Users\\DAM_004\\IdeaProjects\\IOSpliter\\src\\main\\resources\\ProductData.csv";

//        InputStream f = Main.class.getResourceAsStream("ProductData.csv");
        ArrayList<Product> productList = new ArrayList<>();
        String l;

        BufferedReader inFile=null;
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
            // TODO inFile = new BufferedReader(f);

            while ((l = inFile.readLine()) != null) {
                String t[] = l.split(";");
                int id = Integer.parseInt(t[0]);
                String name = t[1];
                int price = Integer.parseInt(t[2]);
                productList.add(new Product(id, name, price));
            }
            for(Product p:productList){
                System.out.println("ID = " + p.getId() + "/"
                        + "NOM = " + p.getName() + "/"
                        + "PRIX = " + p.getPrice()
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

}

//C:\Users\DAM_004\IdeaProjects\IOSpliter\src\main\resources\ProductData.csv
//        String inFileName = "~/IdeaProjects/IOSpliter/src/main/resources/ProductData.csv";
//        BufferedReader in = new BufferedReader(new FileReader(inFileName.replace("\\", "/")));
