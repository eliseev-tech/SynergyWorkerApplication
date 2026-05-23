package ru.eliseevtech.synergyworkerapplication.service;

import org.junit.jupiter.api.Test;
import ru.eliseevtech.synergyworkerapplication.model.Worker;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkerServiceTest {

    @Test
    void findWorkersWithExperienceMoreThanReturnsOnlyMatchingWorkers() {
        WorkerService workerService = new WorkerService();

        int currentYear = Year.now().getValue();

        Worker experiencedWorker = new Worker(
                "Иванов И.И.",
                "Преподаватель",
                80000,
                currentYear - 10
        );

        Worker newWorker = new Worker(
                "Петров П.П.",
                "Методист",
                60000,
                currentYear - 1
        );

        workerService.addWorker(experiencedWorker);
        workerService.addWorker(newWorker);

        List<Worker> result = workerService.findWorkersWithExperienceMoreThan(5);

        assertEquals(1, result.size());
        assertEquals("Иванов И.И.", result.get(0).getFullName());
    }

    @Test
    void findWorkersWithExperienceMoreThanReturnsEmptyListWhenNoMatches() {
        WorkerService workerService = new WorkerService();

        int currentYear = Year.now().getValue();

        Worker worker = new Worker(
                "Сидоров С.С.",
                "Специалист учебного отдела",
                55000,
                currentYear - 2
        );

        workerService.addWorker(worker);

        List<Worker> result = workerService.findWorkersWithExperienceMoreThan(5);

        assertEquals(0, result.size());
    }
}
