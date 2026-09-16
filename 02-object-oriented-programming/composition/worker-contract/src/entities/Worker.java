package entities;

import enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private String name;
    private Double baseSalary;

    private WorkerLevel level;
    private Department department;

    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, Double baseSalary, WorkerLevel level, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addContract (HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract (HourContract contract) {
        contracts.remove(contract);
    }

    public Double income (Integer year, Integer month) {

        Double total = baseSalary;

        for (HourContract contract : contracts) {
            if(contract.getDate().getMonthValue() == month && contract.getDate().getYear() == year) {
                total += contract.totalValue();
            }
        }
        return total;
    }

}
