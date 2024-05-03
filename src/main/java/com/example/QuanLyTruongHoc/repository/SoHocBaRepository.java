package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.SoHocBa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoHocBaRepository extends JpaRepository<SoHocBa,Integer> {
}
