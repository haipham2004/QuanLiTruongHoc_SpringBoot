package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.SoDauBai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoDauBaiRepository extends JpaRepository<SoDauBai,Integer> {
}
