package com.example.QuanLyTruongHoc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name="TheHocSinh")
public class TheHocSinh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TheHocSinhID")
    private int theHocSinhId;

    @ManyToOne
    @JoinColumn(name="HocSinhID")
    private HocSinh hocSinh;

    @Column(name="HoTen")
    private String hoTen;

    @Column(name="AnhDaiDien")
    private String anhDaiDien;

    @Column(name="ThongTinLienLac")
    private String thongTinLienLac;
}

