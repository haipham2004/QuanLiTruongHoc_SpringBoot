package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.PhuHuynh;
import com.example.QuanLyTruongHoc.repository.PhuHuynhRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhuHuynhServiceImp implements TruongHocService<PhuHuynh, Integer> {

    private PhuHuynhRepository phuHuynhRepository;

    @Autowired
    public PhuHuynhServiceImp(PhuHuynhRepository phuHuynhRepository) {
        this.phuHuynhRepository = phuHuynhRepository;
    }

    @Override
    public List<PhuHuynh> getAll() {
        return phuHuynhRepository.findAll();
    }

    @Override
    public Optional<PhuHuynh> getOne(Integer id) {
        return phuHuynhRepository.findById(id);
    }

    @Override
    public PhuHuynh save(PhuHuynh phuHuynh) {
        return phuHuynhRepository.save(phuHuynh);
    }

    @Override
    public PhuHuynh update(PhuHuynh phuHuynh) {
        return phuHuynhRepository.saveAndFlush(phuHuynh);
    }

    @Override
    public void delete(Integer id) {
        phuHuynhRepository.deleteById(id);
    }

    @Override
    public List<PhuHuynh> getList(Integer id) {
        return null;
    }

    @Override
    public List<PhuHuynh> getAllLazy() {
        return null;
    }

    @Override
    public PhuHuynh getOneLazy(Integer id) {
        return null;
    }

    @Override
    public void softDeleteById(int id) {

    }

}
