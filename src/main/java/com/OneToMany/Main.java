
package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Main.ConnectionEstablisher;

public class Main {
    public static void main(String[] args) {

        Department department = new Department();
        department.setDepartmentName("Cardiology");
        department.setLocation("Hyderabad");
        department.setEstablishedYear(2010);

        Doctor doctor1 = new Doctor();
        doctor1.setDoctorName("Rahul");
        doctor1.setSpecilization("Heart Specialist");
        doctor1.setSalary(75000.0);
        doctor1.setDepartment(department);

        Doctor doctor2 = new Doctor();
        doctor2.setDoctorName("Priya");
        doctor2.setSpecilization("Cardiologist");
        doctor2.setSalary(80000.0);
        doctor2.setDepartment(department);

        Doctor doctor3 = new Doctor();
        doctor3.setDoctorName("Amit");
        doctor3.setSpecilization("Surgeon");
        doctor3.setSalary(85000.0);
        doctor3.setDepartment(department);

        List<Doctor> data = new ArrayList<>();
        data.add(doctor1);
        data.add(doctor2);
        data.add(doctor3);

        department.setDoctors(data);

        Session currentSession = ConnectionEstablisher.getConnection().openSession();

        Transaction transaction = currentSession.beginTransaction();

        currentSession.persist(department);
        currentSession.persist(doctor1);
        currentSession.persist(doctor2);
        currentSession.persist(doctor3);

        System.out.println("Fetching the data");

        Department reference = currentSession.getReference(Department.class, department.getDepartmentId());

        System.out.println("Department Name: " + reference.getDepartmentName());
        System.out.println("Location: " + reference.getLocation());
        System.out.println("Established Year: " + reference.getEstablishedYear());

        reference.getDoctors().stream().forEach(System.out::println);

        transaction.commit();

        currentSession.close();
    }
}

