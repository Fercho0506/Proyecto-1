import Users.User;
import Users.Student;
import Users.Teacher;
import Persistence.UserPersistence;
import LearningPaths.LearningPath;
import LearningPaths.LearningPathSystem;
import Activities.Activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserPersistence userPersistence = new UserPersistence();
        LearningPathSystem learningPathSystem = new LearningPathSystem();
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;  // Almacenar el usuario que hace login

        boolean exit = false;

        while (!exit) {
            if (loggedInUser == null) {
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Captura la nueva línea

                switch (option) {
                    case 1:
                        System.out.println("Ingrese el ID del usuario:");
                        String id = scanner.nextLine();
                        System.out.println("Ingrese el nombre del usuario:");
                        String name = scanner.nextLine();
                        System.out.println("Ingrese el email del usuario:");
                        String email = scanner.nextLine();
                        System.out.println("Ingrese la contraseña del usuario:");
                        String password = scanner.nextLine();
                        System.out.println("Ingrese el rol del usuario (student/teacher):");
                        String role = scanner.nextLine();

                        User newUser;
                        if (role.equalsIgnoreCase(User.TEACHER_ROLE)) {
                            newUser = new Teacher(id, name, email, password);
                        } else {
                            newUser = new Student(id, name, email, password);
                        }

                        userPersistence.saveUser(newUser);
                        System.out.println("Usuario registrado exitosamente.");
                        break;

                    case 2:
                        System.out.println("Ingrese su email:");
                        String loginEmail = scanner.nextLine();
                        System.out.println("Ingrese su contraseña:");
                        String loginPassword = scanner.nextLine();

                        // Comprobar si los datos de login son correctos
                        loggedInUser = userPersistence.login(loginEmail, loginPassword);

                        if (loggedInUser != null) {
                            System.out.println("Login exitoso. Bienvenido " + loggedInUser.getName());
                        } else {
                            System.out.println("Credenciales incorrectas. Inténtelo de nuevo.");
                        }
                        break;

                    case 3:
                        exit = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                // Menú para los usuarios ya autenticados
                System.out.println("Bienvenido al sistema de Learning Paths");
                System.out.println("Seleccione una opción:");
                if (loggedInUser instanceof Teacher) {
                    System.out.println("1. Crear Learning Path");
                }
                if (loggedInUser instanceof Student) {
                    System.out.println("2. Inscribirse en un Learning Path");
                }
                System.out.println("3. Listar Learning Paths disponibles");
                System.out.println("4. Cerrar sesión");
                System.out.println("5. Salir");
                System.out.print("Opción: ");

                int option = scanner.nextInt();
                scanner.nextLine();  // Captura la nueva línea

                switch (option) {
                    case 1:
                        if (loggedInUser instanceof Teacher) {
                            System.out.println("Ingrese el título del Learning Path:");
                            String title = scanner.nextLine();
                            System.out.println("Ingrese la descripción:");
                            String description = scanner.nextLine();
                            System.out.println("Ingrese los objetivos:");
                            String objectives = scanner.nextLine();
                            System.out.println("Ingrese el nivel de dificultad:");
                            String difficulty = scanner.nextLine();
                            System.out.println("Ingrese la duración (minutos):");
                            int duration = scanner.nextInt();
                            scanner.nextLine();  // Captura la nueva línea

                            // Crear Learning Path
                            LearningPath learningPath = learningPathSystem.createLearningPath(
                                    loggedInUser, title, description, objectives, difficulty, duration, 0.0,
                                    LocalDate.now(), LocalDate.now(), 1, new ArrayList<>()
                            );

                            System.out.println("Learning Path creado exitosamente: " + learningPath.getTitle());
                        } else {
                            System.out.println("Solo los profesores pueden crear Learning Paths.");
                        }
                        break;

                    case 2:
                        if (loggedInUser instanceof Student) {
                            System.out.println("Ingrese el título del Learning Path para inscribirse:");
                            String pathTitle = scanner.nextLine();
                            try {
                                learningPathSystem.enrollInLearningPath(loggedInUser, pathTitle);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Solo los estudiantes pueden inscribirse en Learning Paths.");
                        }
                        break;

                    case 3:
                        System.out.println("Learning Paths disponibles:");
                        List<LearningPath> paths = learningPathSystem.listLearningPaths();
                        if (paths.isEmpty()) {
                            System.out.println("No hay Learning Paths disponibles.");
                        } else {
                            for (LearningPath lp : paths) {
                                System.out.println("Título: " + lp.getTitle() + " | Descripción: " + lp.getDescription());
                            }
                        }
                        break;

                    case 4:
                        loggedInUser = null;
                        System.out.println("Sesión cerrada.");
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }

        scanner.close();
    }
}

