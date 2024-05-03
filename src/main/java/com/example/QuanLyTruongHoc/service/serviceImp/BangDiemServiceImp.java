package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.BangDiem;
import com.example.QuanLyTruongHoc.repository.BangDiemRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BangDiemServiceImp implements TruongHocService<BangDiem,Integer> {

    private BangDiemRepository bangDiemRepository;

    @Autowired
    public BangDiemServiceImp(BangDiemRepository bangDiemRepository) {
        this.bangDiemRepository = bangDiemRepository;
    }

    @Override
    public List<BangDiem> getAll() {
        return null;
    }

    @Override
    public Optional<BangDiem> getOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public BangDiem save(BangDiem bangDiem) {
        return null;
    }

    @Override
    public BangDiem update(BangDiem bangDiem) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    bangDiemRepository.deleteById(id);
    }

    @Override
    public List<BangDiem> getList(Integer id) {
        return null;
    }

    @Override
    public List<BangDiem> getAllLazy() {
        return null;
    }

    @Override
    public BangDiem getOneLazy(Integer id) {
        return null;
    }
}
