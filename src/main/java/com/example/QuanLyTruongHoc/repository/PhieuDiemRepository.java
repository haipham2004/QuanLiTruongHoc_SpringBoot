package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.PhieuDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDiemRepository extends JpaRepository<PhieuDiem,Integer> {
}
