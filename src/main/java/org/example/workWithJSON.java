package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class workWithJSON {
    private static final String FILE_NAME = "src/main/resources/myJSON.json";
    private ObjectMapper objectMapper;

    public workWithJSON() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Pet> loadPetData() {
        List<Pet> petList = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                petList = objectMapper.readValue(file, new TypeReference<List<Pet>>() {});
                System.out.println("Дані про тварини завантажено успішно.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return petList;
    }

    public void savePetData(List<Pet> petList) {
        try {
            objectMapper.writeValue(new File(FILE_NAME), petList);
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
    public void createJSON(){
        try {
            objectMapper.writeValue(new File(FILE_NAME), "JSON was created");
        } catch (IOException e) {
            System.err.println("Помилка при записі файлу: " + e.getMessage());
        }
    }

//    public static void loadInfoFromJson(){
//
//        JSONParser jsonP=new JSONParser();
//        try (FileReader reader = new FileReader(FILE_NAME)){
//            Object obj =jsonP.parse(reader);
//            JSONArray emptyList =(JSONArray) obj;
//            System.out.println(emptyList);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void saveInfoToJson(List<Pet> petList) {
//
//        try{
//            objectMapper.writeValue(new File(FILE_NAME),petList);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
