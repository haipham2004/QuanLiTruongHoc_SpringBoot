package com.example.QuanLyTruongHoc.repository;

import com.example.QuanLyTruongHoc.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LopRepository extends JpaRepository<Lop,Integer> {

    @Query("SELECT DISTINCT l FROM Lop l JOIN FETCH l.truong where l.truong.deleted=false")
    public List<Lop> getAllLazy();

    @Query("SELECT DISTINCT l FROM Lop l LEFT JOIN FETCH l.truong WHERE l.lopId = ?1 and l.deleted=false and l.truong.deleted=false ")
    public Lop getOneLazy(int id);

    @Transactional
    @Modifying
    @Query("UPDATE Lop l SET l.deleted=true where l.lopId=?1")
    void softDeleteById(int id);

}
