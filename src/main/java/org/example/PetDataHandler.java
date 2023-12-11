package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class PetDataHandler {
    private static final String FILE_PATH = "petData.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static List<Pet> loadPetData() {
        try {
            return objectMapper.readValue(new File(FILE_PATH),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Pet.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePetData(List<Pet> pets) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), pets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
