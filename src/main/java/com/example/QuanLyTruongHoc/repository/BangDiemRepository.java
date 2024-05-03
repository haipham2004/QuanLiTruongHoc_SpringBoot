package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.BangDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangDiemRepository extends JpaRepository<BangDiem,Integer> {
}
