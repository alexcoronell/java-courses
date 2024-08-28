package org.example.platzi;

import org.example.platzi.entity.Employee;
import org.example.platzi.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println();
        EntityManager entityManager = UtilEntity.getEntityManager();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("----- SHOW ALL EMPLOYEES -----");
        employees.forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----- FIND ONE -----");
        int employeeId = 3;
        Employee employee = entityManager.find(Employee.class, employeeId);
        System.out.println("Employee found: " + employee);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----- CREATE ONE -----");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("John");
        newEmployee.setPaSurname("Doe");
        newEmployee.setMaSurname("");
        newEmployee.setEmail("jdoe@email.com");
        newEmployee.setSalary(100000F);

//        entityManager.getTransaction().begin();
//        entityManager.persist(newEmployee);
//        entityManager.getTransaction().commit();
//        System.out.println("Employee created");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----- UPDATE -----");
        int employeeToUpdateId = 17;
        Employee employeeToUpdate = entityManager.find(Employee.class, employeeToUpdateId);
        System.out.println("Employee to update" + employeeToUpdate);
        employeeToUpdate.setMaSurname("Doe2 edited");
        employeeToUpdate.setSalary((float) 150000.50);

        entityManager.getTransaction().begin();
        entityManager.merge(employeeToUpdate);
        entityManager.getTransaction().commit();
        System.out.println("Employee updated" + employeeToUpdate);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----- DELETE -----");
        int employeeToDeleteId = 17;
        Employee employeeToDelete = entityManager.find(Employee.class, employeeToDeleteId);
        System.out.println("Employee to delete: " + employeeToDelete);
        entityManager.getTransaction().begin();
        entityManager.remove(employeeToDelete);
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}