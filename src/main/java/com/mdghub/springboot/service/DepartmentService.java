package com.mdghub.springboot.service;

import com.mdghub.springboot.entity.Department;
import com.mdghub.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartmentById(long id) throws DepartmentNotFoundException;

    public void deleteById(long id);

    public Department updateById(long id,Department department);

    public List<Department> getDepartmentByName(String name);
}
