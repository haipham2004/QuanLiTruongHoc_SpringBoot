package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TruongRepository extends JpaRepository<Truong,Integer> {

    @Query("SELECT DISTINCT t FROM Truong t JOIN FETCH t.lop where t.deleted=false ")
    public List<Truong> getAllLazy();

    @Transactional
    @Modifying
    @Query("UPDATE Truong t SET t.deleted = true WHERE t.truongId=?1")
    void softDeleteById(int id);
}
