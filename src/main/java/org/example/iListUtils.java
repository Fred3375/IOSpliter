package org.example;

import java.util.ArrayList;
import java.util.List;

public interface iListUtils {

    public  ArrayList<Boisson>  loadFromFile(String fileName);
    public void display(ArrayList<Boisson> pList);
    public List<String> getNameListSortedByName(ArrayList<Boisson> plList);

}
