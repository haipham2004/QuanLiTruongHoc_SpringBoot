package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepository extends JpaRepository<HocSinh,Integer> {

}
