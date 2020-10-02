package com.example.corso.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corso.flow.entity.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {

}
