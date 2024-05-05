package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.repository.LopRepository;
import com.example.QuanLyTruongHoc.repository.PhuHuynhRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LopServiceImp implements TruongHocService<Lop, Integer> {

    private LopRepository lopRepository;


    @Autowired
    public LopServiceImp( LopRepository lopRepository) {
        this.lopRepository = lopRepository;
    }

    @Override
    @Transactional
    public List<Lop> getAll() {
        return lopRepository.findAll();
    }

    @Override
    public Optional<Lop> getOne(Integer id) {
        return lopRepository.findById(id);
    }

    @Override
    public Lop save(Lop lop) {
        return lopRepository.save(lop);
    }

    @Override
    public Lop update(Lop lop) {
        return lopRepository.saveAndFlush(lop);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //ok done haha
//        phuHuynhRepository.deleteById(id);
        lopRepository.deleteById(id);
    }

    @Override
    public List<Lop> getList(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public List<Lop> getAllLazy() {
        return lopRepository.getAllLazy();
    }

    @Override
    public Lop getOneLazy(Integer id) {
        return lopRepository.getOneLazy(id);
    }

    @Override
    public void softDeleteById(int id) {

    }
}
