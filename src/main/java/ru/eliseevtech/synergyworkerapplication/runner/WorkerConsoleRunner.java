package ru.eliseevtech.synergyworkerapplication.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.eliseevtech.synergyworkerapplication.model.Worker;
import ru.eliseevtech.synergyworkerapplication.service.WorkerService;

import java.util.List;
import java.util.Scanner;

/**
 * Компонент консольного интерфейса приложения.
 * <p>
 * Отвечает за ввод данных работников с клавиатуры,
 * добавление работников в список и вывод фамилий работников,
 * чей стаж превышает заданное пользователем значение.
 */
@Component
public class WorkerConsoleRunner implements CommandLineRunner {

    /**
     * Сервис для хранения работников и поиска по стажу.
     */
    private final WorkerService workerService;

    /**
     * Контекст Spring-приложения.
     * <p>
     * Используется для корректного завершения приложения
     * при выборе команды выхода.
     */
    private final ConfigurableApplicationContext applicationContext;

    /**
     * Создает компонент консольного интерфейса.
     *
     * @param workerService      сервис для хранения работников и поиска по стажу
     * @param applicationContext контекст Spring-приложения
     */
    public WorkerConsoleRunner(
            WorkerService workerService,
            ConfigurableApplicationContext applicationContext
    ) {
        this.workerService = workerService;
        this.applicationContext = applicationContext;
    }

    /**
     * Запускает консольное меню после старта Spring Boot-приложения.
     * <p>
     * Пользователь может добавить работника, выполнить поиск работников
     * по стажу или завершить работу приложения.
     *
     * @param args аргументы командной строки
     */
    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            System.out.println("Программа учета сотрудников Университета «Синергия»");

            while (running) {
                System.out.println();
                System.out.println("Выберите действие:");
                System.out.println("1 — Добавить работника");
                System.out.println("2 — Найти работников по стажу");
                System.out.println("0 — Завершить программу");
                System.out.print("Ваш выбор: ");

                int command = Integer.parseInt(scanner.nextLine());

                switch (command) {
                    case 1 -> addWorker(scanner);
                    case 2 -> printWorkersByExperience(scanner);
                    case 0 -> {
                        System.out.println("Работа программы завершена.");
                        running = false;
                        applicationContext.close();
                    }
                    default -> System.out.println("Неизвестная команда.");
                }
            }
        }
    }

    /**
     * Считывает данные работника с клавиатуры и добавляет его в список.
     *
     * @param scanner объект для чтения данных из консоли
     */
    private void addWorker(Scanner scanner) {
        System.out.println();
        System.out.println("Введите данные работника");

        System.out.print("Фамилия и инициалы: ");
        String fullName = scanner.nextLine();

        System.out.print("Должность: ");
        String position = scanner.nextLine();

        System.out.print("Зарплата: ");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("Год поступления на работу: ");
        int employmentYear = Integer.parseInt(scanner.nextLine());

        Worker worker = new Worker(fullName, position, salary, employmentYear);
        workerService.addWorker(worker);

        System.out.println("Работник добавлен.");
    }

    /**
     * Запрашивает минимальный стаж и выводит фамилии работников,
     * чей стаж превышает указанное значение.
     *
     * @param scanner объект для чтения данных из консоли
     */
    private void printWorkersByExperience(Scanner scanner) {
        System.out.println();
        System.out.print("Введите минимальный стаж работы: ");

        int experience = Integer.parseInt(scanner.nextLine());
        List<Worker> result = workerService.findWorkersWithExperienceMoreThan(experience);

        System.out.println();
        System.out.println("Результаты поиска:");

        if (result.isEmpty()) {
            System.out.println("Работников со стажем больше "
                    + experience + " лет не найдено.");
            return;
        }

        for (Worker worker : result) {
            System.out.println(worker.getFullName());
        }
    }
}
