package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruongRepository extends JpaRepository<Truong,Integer> {

    @Query("SELECT DISTINCT t FROM Truong t JOIN FETCH t.lop")
    public List<Truong> getAllLazy();


}
