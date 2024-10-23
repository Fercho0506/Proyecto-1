package Persistence;

import Users.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserPersistence {
    private static final String PATH = "data/users.json";
    private final Gson gson;

    public UserPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())  // Registrar el adaptador
                .setPrettyPrinting()
                .create();
    }

    private List<User> loadAllUsers() {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(PATH)) {
            User[] usersArray = gson.fromJson(reader, User[].class);
            if (usersArray != null) {  // Verificar si el archivo no está vacío
                for (User user : usersArray) {
                    users.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, creando nuevo archivo...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Método para guardar todos los usuarios en el archivo
    private void saveAllUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(PATH)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar un nuevo usuario
    public void saveUser(User user) {
        List<User> users = loadAllUsers();

        // Verificar si el usuario ya existe
        for (User u : users) {
            if (Objects.equals(u.getId(), user.getId())) {
                System.out.println("El usuario con ID " + user.getId() + " ya existe.");
                return;
            }
        }

        users.add(user);  // Agregar el nuevo usuario
        saveAllUsers(users);
        System.out.println("Usuario guardado correctamente.");
    }

    // Método para cargar un usuario por su ID
    public User loadUser(String id) {
        List<User> users = loadAllUsers();
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        System.out.println("Usuario con ID " + id + " no encontrado.");
        return null;
    }

    // Método para eliminar un usuario por su ID
    public void deleteUser(String id) {
        List<User> users = loadAllUsers();
        boolean found = false;

        // Crear una nueva lista excluyendo el usuario con el ID proporcionado
        List<User> updatedUsers = new ArrayList<>();
        for (User user : users) {
            if (!Objects.equals(user.getId(), id)) {
                updatedUsers.add(user);
            } else {
                found = true;
            }
        }

        if (found) {
            saveAllUsers(updatedUsers);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Usuario con ID " + id + " no encontrado.");
        }
    }

    public User login(String email, String password) {
        try (FileReader reader = new FileReader(PATH)) {
            User[] users = gson.fromJson(reader, User[].class);
            List<User> userList = Arrays.asList(users);

            // Buscar el usuario por email y contraseña
            for (User user : userList) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return user;  // Retorna el usuario si coincide
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Retorna null si no se encuentra el usuario
    }
}
