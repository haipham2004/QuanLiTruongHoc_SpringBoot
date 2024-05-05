package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.SoHocBa;
import com.example.QuanLyTruongHoc.repository.SoHocBaRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoHocBaServiceImp implements TruongHocService<SoHocBa, Integer> {

    private SoHocBaRepository soHocBaRepository;

    @Autowired
    public SoHocBaServiceImp(SoHocBaRepository soHocBaRepository) {
        this.soHocBaRepository = soHocBaRepository;
    }


    @Override
    public List<SoHocBa> getAll() {
        return null;
    }

    @Override
    public Optional<SoHocBa> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public SoHocBa save(SoHocBa soHocBa) {
        return null;
    }

    @Override
    public SoHocBa update(SoHocBa soHocBa) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        soHocBaRepository.deleteById(id);
    }

    @Override
    public List<SoHocBa> getList(Integer id) {
        return null;
    }

    @Override
    public List<SoHocBa> getAllLazy() {
        return null;
    }

    @Override
    public SoHocBa getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }
}
