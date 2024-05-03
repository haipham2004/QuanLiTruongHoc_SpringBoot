CREATE DATABASE Spring_QuanLyTruongHoc
go
use Spring_QuanLyTruongHoc
go
--Date:02-05-2024 lúc 00g16p
--Trường THPT YKA 2019-2022
-- Thanh xuân mãi đẹp của tôi: Hải Phạm YKA
-- Tạo bảng Truong
CREATE TABLE Truong (
    TruongID INT identity(1,1) PRIMARY KEY,
    TenTruong NVARCHAR(100),
    DiaChi NVARCHAR(200),
    SoDienThoai NVARCHAR(15)
);

-- Tạo bảng Lớp
CREATE TABLE Lop (
    LopID INT identity(1,1) PRIMARY KEY,
    TenLop NVARCHAR(50),
    KhoiHoc NVARCHAR(20),
    NienKhoa NVARCHAR(10),
    GiaoVienChuNhiem NVARCHAR(100),
    TruongID INT,
    CONSTRAINT FK_Truong_Lop FOREIGN KEY (TruongID) REFERENCES Truong(TruongID)
);

-- Tạo bảng Nhân viên
CREATE TABLE NhanVien (
    NhanVienID INT identity(1,1) PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
    VaiTro NVARCHAR(50),
    LopID INT,
    CONSTRAINT FK_Lop_NhanVien FOREIGN KEY (LopID) REFERENCES Lop(LopID)
);

-- Tạo bảng Phụ huynh
CREATE TABLE PhuHuynh (
    PhuHuynhID INT identity(1,1) PRIMARY KEY,
    TenPhuHuynh NVARCHAR(100),
    ThongTinLienLac NVARCHAR(200)
);

-- Tạo bảng Học sinh
CREATE TABLE HocSinh (
    HocSinhID INT identity(1,1) PRIMARY KEY,
    TenHocSinh NVARCHAR(100),
    LopID INT,
    PhuHuynhID INT,
    CONSTRAINT FK_Lop_HocSinh FOREIGN KEY (LopID) REFERENCES Lop(LopID),
	CONSTRAINT FK_Lop_PhuHuynh FOREIGN KEY (PhuHuynhID) REFERENCES PhuHuynh(PhuHuynhID)
);

-- Tạo bảng Môn học
CREATE TABLE MonHoc (
    MonHocID INT identity(1,1) PRIMARY KEY,
    TenMonHoc NVARCHAR(100),
    GiaoVienPhuTrach NVARCHAR(100)
);

-- Tạo bảng Bảng điểm
CREATE TABLE BangDiem (
    BangDiemID INT identity(1,1) PRIMARY KEY,
    HocSinhID INT,
    MonHocID INT,
    KyHoc NVARCHAR(20),
    Diem FLOAT,
    CONSTRAINT FK_HocSinh_BangDiem FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID),
    CONSTRAINT FK_MonHoc_BangDiem FOREIGN KEY (MonHocID) REFERENCES MonHoc(MonHocID)
);

-- Tạo bảng Sổ đầu bài
CREATE TABLE SoDauBai (
    SoDauBaiID INT identity(1,1)  PRIMARY KEY,
    LopID INT,
    NhanVienID INT,
    NgayGiangDay DATE,
    NoiDungBaiGiang NVARCHAR(100),
    CONSTRAINT FK_Lop_SoDauBai FOREIGN KEY (LopID) REFERENCES Lop(LopID),
    CONSTRAINT FK_NhanVien_SoDauBai FOREIGN KEY (NhanVienID) REFERENCES NhanVien(NhanVienID)
);

-- Tạo bảng Sổ học bạ
CREATE TABLE SoHocBa  (
    SoHocBaID INT identity(1,1)  PRIMARY KEY,
    HocSinhID INT,
    HocLuc NVARCHAR(50),
    HanhKiem NVARCHAR(50),
    NhanXet NVARCHAR(100),
    CONSTRAINT FK_HocSinh_SoHocBa FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID)
);

-- Tạo bảng Phiếu điểm
CREATE TABLE PhieuDiem (
    PhieuDiemID INT identity(1,1)  PRIMARY KEY,
    HocSinhID INT,
    MonHocID INT,
    NgayKiemTra DATE,
    Diem FLOAT,
    CONSTRAINT FK_HocSinh_PhuongDiem FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID),
    CONSTRAINT FK_MonHoc_PhuongDiem FOREIGN KEY (MonHocID) REFERENCES MonHoc(MonHocID)
);

-- Tạo bảng Thẻ học sinh
CREATE TABLE TheHocSinh (
    TheHocSinhID INT identity(1,1)  PRIMARY KEY,
    HocSinhID INT,
    HoTen NVARCHAR(100),
    AnhDaiDien NVARCHAR(100),
    ThongTinLienLac NVARCHAR(200),
    CONSTRAINT FK_HocSinh_TheHocSinh FOREIGN KEY (HocSinhID) REFERENCES HocSinh(HocSinhID)
);

-- Chèn dữ liệu vào bảng Truong
INSERT INTO Truong (TenTruong, DiaChi, SoDienThoai) VALUES
(N'Trường THPT Yên Khánh A', N'Khánh Hội, Yên Khánh, Ninh Bình', '0334294889'),
(N'Trường A', N'Địa chỉ A', '1234567890'),
(N'Trường B', N'Địa chỉ B', '0987654321'),
(N'Trường C', N'Địa chỉ C', '0123456789'),
(N'Trường D', N'Địa chỉ D', '9876543210'),
(N'Trường E', N'Địa chỉ E', '5555555555'),
(N'Trường F', N'Địa chỉ F', '6666666666'),
(N'Trường G', N'Địa chỉ G', '7777777777'),
(N'Trường H', N'Địa chỉ H', '8888888888'),
(N'Trường I', N'Địa chỉ I', '9999999999')

-- Chèn dữ liệu vào bảng Lop
INSERT INTO Lop (TenLop, KhoiHoc, NienKhoa, GiaoVienChuNhiem, TruongID) VALUES
(N'Lớp 1', N'10', N'2019-2022', N'GV A', 1),
(N'Lớp 2', N'10', N'2019-2022', N'GV B', 2),
(N'Lớp 3', N'11', N'2019-2022', N'GV C', 3),
(N'Lớp 4', N'11', N'2019-2022', N'GV D', 4),
(N'Lớp 5', N'12', N'2019-2022', N'GV E', 5),
(N'Lớp 6', N'12', N'2019-2022', N'GV F', 6),
(N'Lớp 7', N'10', N'2019-2022', N'GV G', 7),
(N'Lớp 8', N'11', N'2019-2022', N'GV H', 8),
(N'Lớp 9', N'12', N'2019-2022', N'GV I', 9),
(N'Lớp 12D', N'12', N'2019-2022', N'GV Phạm Ngọc Lan', 10)
-- Chèn dữ liệu vào bảng Nhân viên
INSERT INTO NhanVien (TenNhanVien, VaiTro, LopID) VALUES
(N'Nhân viên A', N'Giao viên', 1),
(N'Nhân viên B', N'Giao viên', 2),
(N'Nhân viên C', N'Giao viên', 3),
(N'Nhân viên D', N'Giao viên', 4),
(N'Nhân viên E', N'Giao viên', 5),
(N'Nhân viên F', N'Giao viên', 6),
(N'Nhân viên G', N'Giao viên', 7),
(N'Nhân viên H', N'Giao viên', 8),
(N'Nhân viên I', N'Giao viên', 9),
(N'Nhân viên J', N'Giao viên', 10);
SELECT*FROM Lop
-- Chèn dữ liệu vào bảng Phụ huynh
INSERT INTO PhuHuynh (TenPhuHuynh, ThongTinLienLac) VALUES
(N'Phụ huynh A', N'Địa chỉ A - SĐT A'),
(N'Phụ huynh B', N'Địa chỉ B - SĐT B'),
(N'Phụ huynh C', N'Địa chỉ C - SĐT C'),
(N'Phụ huynh D', N'Địa chỉ D - SĐT D'),
(N'Phụ huynh E', N'Địa chỉ E - SĐT E'),
(N'Phụ huynh F', N'Địa chỉ F - SĐT F'),
(N'Phụ huynh G', N'Địa chỉ G - SĐT G'),
(N'Phụ huynh H', N'Địa chỉ H - SĐT H'),
(N'Phụ huynh I', N'Địa chỉ I - SĐT I'),
(N'Phụ huynh J', N'Địa chỉ J - SĐT J');

-- Chèn dữ liệu vào bảng Học sinh
INSERT INTO HocSinh (TenHocSinh, LopID, PhuHuynhID) VALUES
(N'Học sinh A', 1, 1),
(N'Học sinh B', 1, 2),
(N'Học sinh C', 2, 3),
(N'Học sinh D', 2, 4),
(N'Học sinh E', 3, 5),
(N'Học sinh F', 3, 6),
(N'Học sinh G', 4, 7),
(N'Học sinh H', 5, 8),
(N'Học sinh I', 6, 9),
(N'Học sinh J', 7, 10);

-- Chèn dữ liệu vào bảng Môn học
INSERT INTO MonHoc (TenMonHoc, GiaoVienPhuTrach) VALUES
(N'Môn học A', N'GV A'),
(N'Môn học B', N'GV B'),
(N'Môn học C', N'GV C'),
(N'Môn học D', N'GV D'),
(N'Môn học E', N'GV E'),
(N'Môn học F', N'GV F'),
(N'Môn học G', N'GV G'),
(N'Môn học H', N'GV H'),
(N'Môn học I', N'GV I'),
(N'Môn học J', N'GV J');


-- Chèn dữ liệu vào bảng BangDiem
INSERT INTO BangDiem (HocSinhID, MonHocID, KyHoc, Diem) VALUES
(1, 1, N'Kỳ 1', 8.5),
(2, 1, N'Kỳ 1', 9.0),
(3, 2, N'Kỳ 1', 7.5),
(4, 2, N'Kỳ 1', 8.0),
(5, 3, N'Kỳ 1', 6.5),
(6, 3, N'Kỳ 1', 7.0),
(7, 4, N'Kỳ 1', 5.5),
(8, 4, N'Kỳ 1', 6.0),
(9, 5, N'Kỳ 1', 9.5),
(10, 5, N'Kỳ 1', 10.0);

-- Chèn dữ liệu vào bảng Sổ đầu bài
INSERT INTO SoDauBai (LopID, NhanVienID, NgayGiangDay, NoiDungBaiGiang) VALUES
(1, 1, '2024-01-01', N'Bài giảng A'),
(2, 2, '2024-01-01', N'Bài giảng B'),
(3, 3, '2024-01-01', N'Bài giảng C'),
(4, 4, '2024-01-01', N'Bài giảng D'),
(5, 5, '2024-01-01', N'Bài giảng E'),
(6, 6, '2024-01-01', N'Bài giảng F'),
(7, 7, '2024-01-01', N'Bài giảng G'),
(8, 8, '2024-01-01', N'Bài giảng H'),
(9, 9, '2024-01-01', N'Bài giảng I'),
(10, 10, '2024-01-01', N'Bài giảng J');

-- Chèn dữ liệu vào bảng Sổ học bạ
INSERT INTO SoHocBa (HocSinhID, HocLuc, HanhKiem, NhanXet) VALUES
(1, N'Tốt', N'Tốt', N'Nhan xet A'),
(2, N'Tốt', N'Tốt', N'Nhan xet B'),
(3, N'Trung bình', N'Trung bình', N'Nhan xet C'),
(4, N'Trung bình', N'Trung bình', N'Nhan xet D'),
(5, N'Yếu', N'Yếu', N'Nhan xet E'),
(6, N'Yếu', N'Yếu', N'Nhan xet F'),
(7, N'Tốt', N'Tốt', N'Nhan xet G'),
(8, N'Tốt', N'Tốt', N'Nhan xet H'),
(9, N'Tốt', N'Tốt', N'Nhan xet I'),
(10, N'Tốt', N'Tốt', N'Nhan xet J');

-- Chèn dữ liệu vào bảng Phiếu điểm
INSERT INTO PhieuDiem (HocSinhID, MonHocID, NgayKiemTra, Diem) VALUES
(1, 1, '2024-01-01', 8.5),
(2, 1, '2024-01-01', 9.0),
(3, 2, '2024-01-01', 7.5),
(4, 2, '2024-01-01', 8.0),
(5, 3, '2024-01-01', 6.5),
(6, 3, '2024-01-01', 7.0),
(7, 4, '2024-01-01', 5.5),
(8, 4, '2024-01-01', 6.0),
(9, 5, '2024-01-01', 9.5),
(10, 5, '2024-01-01', 10.0);

-- Chèn dữ liệu vào bảng Thẻ học sinh
INSERT INTO TheHocSinh (HocSinhID, HoTen, AnhDaiDien, ThongTinLienLac) VALUES
(1, N'Học sinh A', NULL, N'Thông tin liên lạc A'),
(2, N'Học sinh B', NULL, N'Thông tin liên lạc B'),
(3, N'Học sinh C', NULL, N'Thông tin liên lạc C'),
(4, N'Học sinh D', NULL, N'Thông tin liên lạc D'),
(5, N'Học sinh E', NULL, N'Thông tin liên lạc E'),
(6, N'Học sinh F', NULL, N'Thông tin liên lạc F'),
(7, N'Học sinh G', NULL, N'Thông tin liên lạc G'),
(8, N'Học sinh H', NULL, N'Thông tin liên lạc H'),
(9, N'Học sinh I', NULL, N'Thông tin liên lạc I'),
(10, N'Học sinh J', NULL, N'Thông tin liên lạc J');
