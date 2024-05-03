package com.example.QuanLyTruongHoc.service.serviceImp;

import com.example.QuanLyTruongHoc.entity.Lop;
import com.example.QuanLyTruongHoc.repository.LopRepository;
import com.example.QuanLyTruongHoc.service.TruongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LopServiceImp implements TruongHocService<Lop, Integer> {

    private PhuHuynhServiceImp phuHuynhServiceImp;

    private LopRepository lopRepository;

    private BangDiemServiceImp bangDiemServiceImp;

    private PhieuDiemServiceImp phieuDiemServiceImp;

    private MonHocServiceImp monHocServiceImp;

    private SoHocBaServiceImp soHocBaServiceImp;

    private TheHocSinhServiceImp theHocSinhServiceImp;

    private HocSinhServiceImp hocSinhServiceImp;

    private SoDauBaiServiceImp soDauBaiServiceImp;

    private NhanVienServiceImp nhanVienServiceImp;



    @Autowired
    public LopServiceImp(PhuHuynhServiceImp phuHuynhServiceImp,LopRepository lopRepository,
                         BangDiemServiceImp bangDiemServiceImp,MonHocServiceImp monHocServiceImp,
                         PhieuDiemServiceImp phieuDiemServiceImp, SoHocBaServiceImp soHocBaServiceImp,
                         TheHocSinhServiceImp theHocSinhServiceImp, HocSinhServiceImp hocSinhServiceImp,
                         SoDauBaiServiceImp soDauBaiServiceImp, NhanVienServiceImp nhanVienServiceImp) {
        this.phuHuynhServiceImp=phuHuynhServiceImp;
        this.lopRepository = lopRepository;
        this.bangDiemServiceImp = bangDiemServiceImp;
        this.phieuDiemServiceImp = phieuDiemServiceImp;
        this.monHocServiceImp=monHocServiceImp;
        this.soHocBaServiceImp = soHocBaServiceImp;
        this.theHocSinhServiceImp = theHocSinhServiceImp;
        this.hocSinhServiceImp = hocSinhServiceImp;
        this.soDauBaiServiceImp = soDauBaiServiceImp;
        this.nhanVienServiceImp = nhanVienServiceImp;
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
        monHocServiceImp.delete(id);
        phuHuynhServiceImp.delete(id);
        hocSinhServiceImp.delete(id);
        nhanVienServiceImp.delete(id);
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
}
