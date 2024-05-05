package com.example.QuanLyTruongHoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne()
    @JoinColumn(name="LopID")
    private Lop lop;

    @ManyToOne()
    @JoinColumn(name="PhuHuynhID")
    private PhuHuynh phuHuynh;

    @JsonIgnore
    @OneToMany(mappedBy = "hocSinh",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<SoHocBa> soHocBaList;

    @JsonIgnore
    @OneToMany(mappedBy = "hocSinh",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<PhieuDiem> phieuDiemList;

    @JsonIgnore
    @OneToMany(mappedBy = "hocSinh",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<TheHocSinh> theHocSinhList;

    @JsonIgnore
    @OneToMany(mappedBy = "hocSinh",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},orphanRemoval = true)
    List<BangDiem> bangDiemList;

}
