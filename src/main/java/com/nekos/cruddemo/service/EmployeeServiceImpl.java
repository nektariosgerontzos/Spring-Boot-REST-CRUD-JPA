package com.nekos.cruddemo.service;

import com.nekos.cruddemo.dao.EmployeeRepository;
import com.nekos.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   private EmployeeRepository employeeRepository;

   @Autowired
   public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
       this.employeeRepository = theEmployeeRepository;
   }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = employeeRepository.save(theEmployee);

        return employee;
    }

    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);

    }


}
