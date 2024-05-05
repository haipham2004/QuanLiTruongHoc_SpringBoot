package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.MonHoc;
import com.example.QuanLyTruongHoc.repository.MonHocRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MonHocServiceImp implements TruongHocService<MonHoc, Integer> {

    private MonHocRepository monHocRepository;

    @Autowired
    public MonHocServiceImp(MonHocRepository monHocRepository) {
        this.monHocRepository = monHocRepository;
    }

    @Override
    public List<MonHoc> getAll() {
        return null;
    }

    @Override
    public Optional<MonHoc> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public MonHoc save(MonHoc monHoc) {
        return null;
    }

    @Override
    public MonHoc update(MonHoc monHoc) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        monHocRepository.deleteById(id);
    }

    @Override
    public List<MonHoc> getList(Integer id) {
        return null;
    }

    @Override
    public List<MonHoc> getAllLazy() {
        return null;
    }

    @Override
    public MonHoc getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }
}
