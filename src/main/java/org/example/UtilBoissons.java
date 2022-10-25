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
        ArrayList<Boisson> plList = new ArrayList<>();
        String l;
        BufferedReader inFile=null;

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(resName);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            inFile = new BufferedReader(streamReader);

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
        productListeSortedByName = plList.stream().sorted(Boisson::compareTo).map(Boisson::getName).toList();
        return productListeSortedByName;
/*
        productListeName = plList.stream().map(Product::getName).toList();
        productListeSortedByName = productListeName.stream().sorted().toList();
*/
    }

}



//            inFile = new BufferedReader(new FileReader(inFileName));
//            inFile = new BufferedReader(new FileReader(String.valueOf(this.getClass().getResource("ProductData.csv"))));
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