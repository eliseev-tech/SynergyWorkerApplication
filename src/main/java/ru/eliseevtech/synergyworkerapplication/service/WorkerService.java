package ru.eliseevtech.synergyworkerapplication.service;

import org.springframework.stereotype.Service;
import ru.eliseevtech.synergyworkerapplication.model.Worker;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы со списком работников.
 */
@Service
public class WorkerService {

    /**
     * Список работников организации.
     */
    private final List<Worker> workers = new ArrayList<>();

    /**
     * Добавляет работника в список.
     *
     * @param worker работник
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * Возвращает работников, чей стаж больше заданного значения.
     *
     * @param years заданное значение стажа
     * @return список работников, чей стаж больше заданного значения
     */
    public List<Worker> findWorkersWithExperienceMoreThan(int years) {
        List<Worker> result = new ArrayList<>();

        for (Worker worker : workers) {
            int experience = Year.now().getValue() - worker.getEmploymentYear();

            if (experience > years) {
                result.add(worker);
            }
        }

        return result;
    }
}
