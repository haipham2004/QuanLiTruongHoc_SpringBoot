package com.example.QuanLyTruongHoc.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="Lop")
public class Lop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LopID")
    private int lopId  ;

    @Column(name="TenLop")
    private String tenLop;

    @Column(name="KhoiHoc")
    private String khoiHoc;

    @Column(name="NienKhoa")
    private String nienKhoa;

    @Column(name="GiaoVienChuNhiem")
    private String giaoVienChuNhiem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TruongID")
    private Truong truong;

    @OneToMany(mappedBy = "lop",cascade=CascadeType.ALL)
    List<NhanVien> nhanVienList;


}
