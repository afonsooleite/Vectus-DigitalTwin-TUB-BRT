package com.brt.brt_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brt.brt_backend.model.Autocarro;

@Repository
public interface AutocarroRepository extends JpaRepository<Autocarro, Long> {
}

