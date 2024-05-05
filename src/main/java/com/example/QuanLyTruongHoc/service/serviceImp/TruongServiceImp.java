package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.entity.Truong;
import com.example.QuanLyTruongHoc.repository.PhuHuynhRepository;
import com.example.QuanLyTruongHoc.repository.TruongRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TruongServiceImp implements TruongHocService<Truong, Integer> {

    private TruongRepository truongRepository;

    private PhuHuynhRepository phuHuynhRepository;


    @Autowired
    public TruongServiceImp(TruongRepository truongRepository, PhuHuynhRepository phuHuynhRepository) {
        this.truongRepository = truongRepository;
        this.phuHuynhRepository = phuHuynhRepository;
    }

    @Override
    public List<Truong> getAll() {
        return truongRepository.findAll();
    }

    @Override
    public Optional<Truong> getOne(Integer id) {
        return truongRepository.findById(id);
    }

    @Override
    public Truong save(Truong truong) {
        return truongRepository.save(truong);
    }

    @Override
    public Truong update(Truong truong) {
        return truongRepository.saveAndFlush(truong);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        truongRepository.deleteById(id);
    }

    @Override
    public List<Truong> getList(Integer integer) {
        return null;
    }

    @Override
    public List<Truong> getAllLazy() {
        return truongRepository.getAllLazy();
    }

    @Override
    public Truong getOneLazy(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void softDeleteById(int id) {
        Optional<Truong> truongOptional = truongRepository.findById(id);
        if(truongOptional.isPresent()){
            Truong truongTonTai=truongOptional.get();
            truongTonTai.setDeleted(true);
            truongRepository.save(truongTonTai);
        }
    }

}
