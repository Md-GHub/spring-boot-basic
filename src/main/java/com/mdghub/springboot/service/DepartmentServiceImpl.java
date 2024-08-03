package com.mdghub.springboot.service;


import com.mdghub.springboot.entity.Department;
import com.mdghub.springboot.error.DepartmentNotFoundException;
import com.mdghub.springboot.repositary.DepartmentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepositary departmentRepositary;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepositary.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepositary.findAll();
    }

    @Override
    public Department getDepartmentById(long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepositary.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("No department founded");
        }
        return department.get();
    }

    @Override
    public void deleteById(long id) {
        departmentRepositary.deleteById(id);
    }

    public Department updateById(long id, Department department) {
        Department oldDepartment = departmentRepositary.findById(id).get();

        if(department.getDepartmentName() != null && !department.getDepartmentName().equals(oldDepartment.getDepartmentName())){
            oldDepartment.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentAddress() != null && !department.getDepartmentAddress().equals(oldDepartment.getDepartmentAddress())){
            oldDepartment.setDepartmentAddress(department.getDepartmentAddress());

        }
        if(department.getDepartmentCode() != null && !department.getDepartmentCode().equals(oldDepartment.getDepartmentCode())){
            oldDepartment.setDepartmentCode(department.getDepartmentCode());
        }
     return departmentRepositary.save(oldDepartment);

    }

    @Override
    public List<Department> getDepartmentByName(String departmentName){
        return departmentRepositary.findAllByDepartmentName(departmentName);
    }
}
