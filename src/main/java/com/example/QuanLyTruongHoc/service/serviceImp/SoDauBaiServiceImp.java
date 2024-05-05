package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.SoDauBai;
import com.example.QuanLyTruongHoc.repository.SoDauBaiRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class SoDauBaiServiceImp implements TruongHocService<SoDauBai, Integer> {

    private SoDauBaiRepository soDauBaiRepository;

    @Autowired
    public SoDauBaiServiceImp(SoDauBaiRepository soDauBaiRepository) {
        this.soDauBaiRepository = soDauBaiRepository;
    }


    @Override
    public List<SoDauBai> getAll() {
        return null;
    }

    @Override
    public Optional<SoDauBai> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public SoDauBai save(SoDauBai soDauBai) {
        return null;
    }

    @Override
    public SoDauBai update(SoDauBai soDauBai) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        soDauBaiRepository.deleteById(id);
    }

    @Override
    public List<SoDauBai> getList(Integer id) {
        return null;
    }

    @Override
    public List<SoDauBai> getAllLazy() {
        return null;
    }

    @Override
    public SoDauBai getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }
}
