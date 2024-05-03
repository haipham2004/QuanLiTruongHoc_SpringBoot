package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc,Integer> {
}
