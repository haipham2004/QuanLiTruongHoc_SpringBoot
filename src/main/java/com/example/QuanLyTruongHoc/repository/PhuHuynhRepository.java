package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.PhuHuynh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhuHuynhRepository extends JpaRepository<PhuHuynh,Integer> {
}
