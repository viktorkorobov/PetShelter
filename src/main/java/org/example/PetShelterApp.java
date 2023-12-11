package org.example;

import java.util.List;
import java.util.Scanner;

public class PetShelterApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Pet> petList;

    public static void main(String[] args) {
        petList = PetDataHandler.loadPetData();

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
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
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            PetDataHandler.savePetData(petList);
        }
    }

    private static void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add a pet");
        System.out.println("2. View all pets");
        System.out.println("3. Remove a pet");
        System.out.println("4. Exit");
    }

    private static void addPet() {
        System.out.println("Enter the pet's name:");
        String name = scanner.nextLine();

        System.out.println("Enter the pet's breed:");
        String breed = scanner.nextLine();

        System.out.println("Enter the pet's age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        Pet newPet = new Pet(name, breed, age);
        petList.add(newPet);

        System.out.println("Pet added successfully!");

        PetDataHandler.savePetData(petList);
    }

    private static void showAllPets() {
        if (petList.isEmpty()) {
            System.out.println("There are no pets in the shelter.");
        } else {
            System.out.println("List of all pets in the shelter:");
            for (Pet pet : petList) {
                System.out.println(pet);
            }
        }
    }

    private static void takePetFromShelter() {
        if (petList.isEmpty()) {
            System.out.println("There are no pets in the shelter to remove.");
        } else {
            System.out.println("Enter the name of the pet you want to remove:");
            String nameToRemove = scanner.nextLine();

            boolean removed = petList.removeIf(pet -> pet.getName().equalsIgnoreCase(nameToRemove));

            if (removed) {
                System.out.println("Pet removed successfully!");
            } else {
                System.out.println("Pet with the name " + nameToRemove + " not found in the shelter.");
            }

            PetDataHandler.savePetData(petList);
        }
    }

    private static void exit() {
        System.out.println("Thank you for using the application!");
        System.exit(0);
    }
}
