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
@Table(name="HocSinh")
public class HocSinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HocSinhID")
    private int hocSinhID;

    @Column(name="TenHocSinh")
    private String tenHocSinh;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="LopID")
    private Lop lop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PhuHuynhID")
    private PhuHuynh phuHuynh;

    @OneToMany(mappedBy = "hocSinh",cascade=CascadeType.ALL)
    List<SoHocBa> soHocBaList;

    @OneToMany(mappedBy = "hocSinh",cascade=CascadeType.ALL)
    List<PhieuDiem> phieuDiemList;

    @OneToMany(mappedBy = "hocSinh",cascade=CascadeType.ALL)
    List<TheHocSinh> theHocSinhList;

    @OneToMany(mappedBy = "hocSinh",cascade=CascadeType.ALL)
    List<BangDiem> bangDiemList;

}
