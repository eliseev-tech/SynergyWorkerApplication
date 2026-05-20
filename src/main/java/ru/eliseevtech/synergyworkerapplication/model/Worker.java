package ru.eliseevtech.synergyworkerapplication.model;

/**
 * Класс Worker описывает сотрудника организации.
 * <p>
 * Класс содержит информацию о работнике:
 * ФИО, должность, заработную плату и год поступления на работу.
 * Также предоставляет методы для изменения и получения данных объекта.
 */
public class Worker {

    /**
     * Фамилия и инициалы работника.
     */
    private String fullName;

    /**
     * Должность работника.
     */
    private String position;

    /**
     * Размер заработной платы работника.
     */
    private double salary;

    /**
     * Год поступления работника на работу.
     */
    private int employmentYear;

    /**
     * Конструктор по умолчанию.
     */
    public Worker() {
    }

    /**
     * Конструктор с параметрами.
     *
     * @param fullName фамилия и инициалы работника
     * @param position должность работника
     */
    public Worker(String fullName, String position) {
        this.fullName = fullName;
        this.position = position;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param fullName фамилия и инициалы работника
     * @param position должность работника
     * @param salary   заработная плата работника
     */
    public Worker(String fullName, String position, double salary) {
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param fullName       фамилия и инициалы работника
     * @param position       должность работника
     * @param salary         заработная плата работника
     * @param employmentYear год поступления на работу
     */
    public Worker(String fullName, String position, double salary, int employmentYear) {
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.employmentYear = employmentYear;
    }

    /**
     * Возвращает ФИО работника.
     *
     * @return ФИО работника
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Устанавливает ФИО работника.
     *
     * @param fullName ФИО работника
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Возвращает должность работника.
     *
     * @return должность работника
     */
    public String getPosition() {
        return position;
    }

    /**
     * Устанавливает должность работника.
     *
     * @param position должность работника
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Возвращает заработную плату работника.
     *
     * @return заработная плата работника
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Устанавливает заработную плату работника.
     *
     * @param salary заработная плата работника
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Возвращает год поступления на работу.
     *
     * @return год поступления на работу
     */
    public int getEmploymentYear() {
        return employmentYear;
    }

    /**
     * Устанавливает год поступления на работу.
     *
     * @param employmentYear год поступления на работу
     */
    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    /**
     * Возвращает строковое представление объекта Worker.
     *
     * @return информация о работнике
     */
    @Override
    public String toString() {
        return """
                ФИО: %s
                Должность: %s
                Зарплата: %.2f
                Год поступления на работу: %d
                """.formatted(
                fullName,
                position,
                salary,
                employmentYear
        );
    }

    /**
     * Учебный аналог деструктора.
     * <p>
     * В Java явный деструктор отсутствует, так как управление памятью
     * выполняется автоматически с помощью сборщика мусора JVM.
     * Метод добавлен для соответствия требованиям учебного задания.
     */
    public void destroy() {
        System.out.println("Завершение работы с объектом сотрудника: " + fullName);
    }
}
