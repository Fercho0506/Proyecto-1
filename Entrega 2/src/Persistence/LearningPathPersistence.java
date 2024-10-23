package Persistence;

import LearningPaths.LearningPath;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LearningPathPersistence {
    private static final String PATH = "data/learningPaths.json";
    private final Gson gson;

    public LearningPathPersistence() {
        // Registrar el adaptador de LocalDate para manejar fechas en JSON
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
    }

    // Método para cargar todos los LearningPaths desde el archivo
    private List<LearningPath> loadAllLearningPaths() {
        List<LearningPath> learningPaths = new ArrayList<>();
        try (FileReader reader = new FileReader(PATH)) {
            LearningPath[] learningPathsArray = gson.fromJson(reader, LearningPath[].class);
            if (learningPathsArray != null) {
                Collections.addAll(learningPaths, learningPathsArray);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando nuevo archivo...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return learningPaths;
    }

    // Método para guardar todos los LearningPaths en el archivo
    private void saveAllLearningPaths(List<LearningPath> learningPaths) {
        try (FileWriter writer = new FileWriter(PATH)) {
            gson.toJson(learningPaths, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar un nuevo LearningPath
    public void saveLearningPath(LearningPath learningPath) {
        List<LearningPath> learningPaths = loadAllLearningPaths();

        // Verificar si el LearningPath ya existe (por título u otro criterio único)
        for (LearningPath lp : learningPaths) {
            if (Objects.equals(lp.getTitle(), learningPath.getTitle())) {
                System.out.println("El Learning Path con el título '" + learningPath.getTitle() + "' ya existe.");
                return;
            }
        }

        learningPaths.add(learningPath);  // Agregar el nuevo LearningPath
        saveAllLearningPaths(learningPaths);
        System.out.println("Learning Path guardado correctamente.");
    }

    // Método para cargar un LearningPath por su título (puedes cambiar el criterio de búsqueda si prefieres usar un ID)
    public LearningPath loadLearningPath(String title) {
        List<LearningPath> learningPaths = loadAllLearningPaths();
        for (LearningPath lp : learningPaths) {
            if (Objects.equals(lp.getTitle(), title)) {
                return lp;
            }
        }
        System.out.println("Learning Path con el título '" + title + "' no encontrado.");
        return null;
    }

    // Método para eliminar un LearningPath por su título
    public void deleteLearningPath(String title) {
        List<LearningPath> learningPaths = loadAllLearningPaths();
        boolean found = false;

        // Crear una nueva lista excluyendo el LearningPath con el título proporcionado
        List<LearningPath> updatedLearningPaths = new ArrayList<>();
        for (LearningPath lp : learningPaths) {
            if (!Objects.equals(lp.getTitle(), title)) {
                updatedLearningPaths.add(lp);
            } else {
                found = true;
            }
        }

        if (found) {
            saveAllLearningPaths(updatedLearningPaths);
            System.out.println("Learning Path eliminado correctamente.");
        } else {
            System.out.println("Learning Path con el título '" + title + "' no encontrado.");
        }
    }
}
