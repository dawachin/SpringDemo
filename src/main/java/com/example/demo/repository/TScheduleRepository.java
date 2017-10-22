package com.example.demo.repository;

import com.example.demo.entity.TSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface TScheduleRepository extends Repository<TSchedule, String>{

    Page<TSchedule> findAll(Pageable pageable);
}
