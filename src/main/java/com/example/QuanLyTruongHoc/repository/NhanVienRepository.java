package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
}
