package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;

        do {
            System.out.println("Sepet işlemini seçiniz-> 0-çıkış | 1-sepete ekle | 2-sepetten çıkar");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }
        while (choice != 0);

        scanner.close();

    }

    public static void removeItems(String itemsToRemove) {
        String[] splitSepet = itemsToRemove.split(",");

        for (String item : splitSepet) {
            item = item.trim();

            if (!checkItemIsInList(item)) {
                System.out.println(item + " listede mevcut değil..");
            } else {
                groceryList.remove(item);
            }
        }

        sortItems();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitSepet = itemsToAdd.split(",");
        for (String item : splitSepet) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                System.out.println(item + " listeye daha önce eklenmiştir..");
            } else {
                groceryList.add(item);
            }
        }

        sortItems();
    }

    public static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Pazar listesi: ");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public static void sortItems(){
        Collections.sort(groceryList);
    }

}
