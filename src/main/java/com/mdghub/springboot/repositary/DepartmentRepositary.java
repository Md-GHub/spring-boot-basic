package com.mdghub.springboot.repositary;
import java.util.*;
import com.mdghub.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepositary extends JpaRepository<Department, Long> {

    public List<Department> findAllByDepartmentName(String departmentName);
}
