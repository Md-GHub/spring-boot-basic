package com.mdghub.springboot.controller;


import com.mdghub.springboot.entity.Department;
import com.mdghub.springboot.error.DepartmentNotFoundException;
import com.mdghub.springboot.service.DepartmentService;
import com.mdghub.springboot.service.DepartmentServiceImpl;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("/department")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable long id) {
        departmentService.deleteById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable long id, @RequestBody Department department) {
        return departmentService.updateById(id,department);
    }

    @GetMapping("/department/name/{ch}")
    public List<Department> getDepartmentByName(@PathVariable String ch) {
        return departmentService.getDepartmentByName(ch);
    }




}
