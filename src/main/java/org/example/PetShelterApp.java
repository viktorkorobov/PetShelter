package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetShelterApp extends workWithJSON {

    private static List<Pet> petList;
    private static workWithJSON workWithJSON;
    public PetShelterApp() {
        this.petList = new ArrayList<>();
        this.workWithJSON = new workWithJSON();
        loadData();
    }
    private void loadData() {
        petList = workWithJSON.loadPetData();
    }

    private static void addPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pet information:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        Pet newPet = new Pet(name, breed, age);
        petList.add(newPet);

        System.out.println("Pet '" + name + "’ successfully added to the list.");
    }

    private static void showAllPets() {

        if (petList.isEmpty()) {
            System.out.println("No animals in the shelter.");
        } else {
            System.out.println("List of all animals in the shelter:");
            for (Pet pet : petList) {
                System.out.println("Name: " + pet.getName());
                System.out.println("Breed: " + pet.getBreed());
                System.out.println("Age: " + pet.getAge());
                System.out.println("--------------------------");
            }
        }
    }

    private static void takePetFromShelter() {
        if (petList.isEmpty()) {
            System.out.println("No animals in the shelter.");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("List of all animals in the shelter: ");
            int index = scanner.nextInt();

            if (index >= 1 && index <= petList.size()) {
                Pet removedPet = petList.remove(index - 1);
                System.out.println("Pet '" + removedPet.getName() + "’ delete from shelter.");
            } else {
                System.out.println("Incorrect number of chosen animal.");
            }
        }
    }
    public void run(){

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("PetShelterApp");
            System.out.println("1. Add animal");
            System.out.println("2. Show all animals");
            System.out.println("3. Delete animal");
            System.out.println("4. Exit");
            System.out.println("----------------");
            System.out.println("Choose option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    showAllPets();
                    break;
                case 3:
                    takePetFromShelter();
                    break;
                case 4:
                    workWithJSON.savePetData(petList);
                    System.out.println("Thank you for using the program!");
                    break;
                default:
                    System.out.println("You entered an incorrect option. Please try again.");
            }
        } while (choice != 4);
    }
}
