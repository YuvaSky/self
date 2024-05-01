package com.exceldemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exceldemo.entity.Emp;

@Repository
public interface EmpDao extends JpaRepository<Emp, Integer> {

}
