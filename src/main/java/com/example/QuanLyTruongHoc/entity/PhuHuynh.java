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
@Table(name="PhuHuynh")
public class PhuHuynh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PhuHuynhID")
    private int phuHuynhId  ;

    @Column(name="TenPhuHuynh")
    private String tenPhuHuynh;

    @Column(name="ThongTinLienLac")
    private String thongTinLienLac;

    @JsonIgnore
    @OneToMany(mappedBy = "phuHuynh",cascade= CascadeType.ALL,orphanRemoval = true)
    List<HocSinh> hocSinhList;
}
