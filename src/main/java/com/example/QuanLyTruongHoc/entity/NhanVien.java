package com.example.QuanLyTruongHoc.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NhanVienID")
    private int nhanVienId  ;

    @Column(name="TenNhanVien")
    private String tenNhanVien;

    @Column(name="VaiTro")
    private String vaiTro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="LopID")
    private Lop lop;

    @OneToMany(mappedBy = "nhanVien",cascade=CascadeType.ALL)
    List<SoDauBai> soDauBaiList;
}
