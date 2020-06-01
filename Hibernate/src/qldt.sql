CREATE TABLE GiaoVien
(
    MaGiaoVien CHAR(5),
    HoTen VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    Luong FLOAT,
    Phai CHAR(3) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    NgaySinh DATETIME,
    DiaChi VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    Gvqlcm CHAR(5),
    MaBoMon CHAR(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci,

    CONSTRAINT PK_GV PRIMARY KEY (MaGiaoVien)
);
CREATE TABLE GiaoVienDeTai
(
    MaGiaoVien CHAR(5),
    DienThoai CHAR(12),

    CONSTRAINT PK_GVDT PRIMARY KEY (MaGiaoVien,DienThoai)
);

CREATE TABLE BoMon
(
    MaBoMon CHAR(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    TenBoMon VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    Phong CHAR(5),
    DienThoai CHAR(12),
    TruongBoMon CHAR(5),
    MaKhoa CHAR(4),
    NgayNhanChuc DATETIME,

    CONSTRAINT PK_BM PRIMARY KEY (MaBoMon)

);
CREATE TABLE Khoa
(
    MaKhoa CHAR(4),
    TenKhoa VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    NamThanhLap INT,
    Phong CHAR(5),
    DienThoai CHAR(12),
    TruongKhoa CHAR(5),
    NgayNhanChuc DATETIME,

    CONSTRAINT PK_K PRIMARY KEY (MaKhoa)

);
CREATE TABLE DeTai
(
    MaDeTai CHAR(3),
    TenDeTai VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    CapQuanLy VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    KinhPhi FLOAT,
    NgayBatDau DATETIME,
    NgayKetThuc DATETIME,
    MaChuDe CHAR(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    GiaoVienChuNhiemDeTai CHAR(5),

    CONSTRAINT PK_DT PRIMARY KEY (MaDeTai)
);
CREATE TABLE ChuDe
(
    MaChuDe CHAR(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    TenChuDe VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,

    CONSTRAINT PK_CD PRIMARY KEY (MaChuDe)
);
CREATE TABLE CongViec
(
    MaDeTai CHAR(3),
    SoThuTu INT,
    TenCongViec VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    NgayBatDau DATETIME,
    NgayKetThuc DATETIME,

    CONSTRAINT PK_CV PRIMARY KEY (MaDeTai,SOThuTu)
);

CREATE TABLE ThamGiaDeTai
(
    MaGiaoVien CHAR(5),
    MaDeTai CHAR(3),
    SoThuTu INT,
    PhuCap FLOAT ,
    KetQua VARCHAR(40),

    CONSTRAINT PK_TGDT PRIMARY KEY (MaGiaoVien,MaDeTai,SoThuTu)
);
CREATE TABLE NguoiThan
(
    MaGiaoVien CHAR(5),
    Ten VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    NgaySinh DATETIME,
    Phai CHAR(3) CHARACTER SET utf8 COLLATE utf8_unicode_ci,

    CONSTRAINT PK_NT PRIMARY KEY (MaGiaoVien,Ten)
);
-- Tạo các khóa ngoại
ALTER TABLE GiaoVien ADD CONSTRAINT FK_GV_GV FOREIGN KEY (Gvqlcm) REFERENCES GiaoVien(MaGiaoVien);
ALTER TABLE GiaoVien ADD CONSTRAINT FK_GV_BM FOREIGN KEY (MaBoMon) REFERENCES BoMon(MaBoMon);

ALTER TABLE GiaoVienDeTai ADD CONSTRAINT FK_GVDT_GV FOREIGN KEY (MaGiaoVien) REFERENCES GiaoVien(MaGiaoVien);

ALTER TABLE BoMon ADD CONSTRAINT FK_BM_K FOREIGN KEY (MAKhoa) REFERENCES Khoa(MAKhoa);
ALTER TABLE BoMon ADD CONSTRAINT FK_BM_GV FOREIGN KEY (TruongBoMon) REFERENCES GiaoVien(MaGiaoVien);

ALTER TABLE Khoa ADD CONSTRAINT FK_K_GV FOREIGN KEY (TruongKhoa) REFERENCES GiaoVien(MaGiaoVien);

ALTER TABLE DeTai ADD CONSTRAINT FK_DT_GV FOREIGN KEY (GiaoVienChuNhiemDeTai) REFERENCES GiaoVien(MaGiaoVien);
ALTER TABLE DeTai ADD CONSTRAINT FK_DT_CD FOREIGN KEY (MaChuDe) REFERENCES ChuDe(MaChuDe);

ALTER TABLE CongViec ADD CONSTRAINT FK_CV_DT FOREIGN KEY (MaDeTai) REFERENCES DeTai(MaDeTai);

ALTER TABLE ThamGiaDeTai ADD CONSTRAINT FK_TGDT_GV FOREIGN KEY (MaGiaoVien) REFERENCES GiaoVien(MaGiaoVien);
ALTER TABLE ThamGiaDeTai ADD CONSTRAINT FK_TGDT_CONGVIEC FOREIGN KEY (MaDeTai, SoThuTu) REFERENCES CongViec(MaDeTai, SoThuTu);

ALTER TABLE NguoiThan ADD CONSTRAINT FK_NT_GV FOREIGN KEY (MaGiaoVien) REFERENCES GiaoVien(MaGiaoVien);

-- Nhập dữ liệu
INSERT GiaoVien
VALUES ('001',N'Nguyễn Hoài An',2000,N'Nam','19730215',N'25/3 Lạc Long Quân, Q.10, TP HCM',NULL,NULL),
       ('002',N'Trần Trà Hương',2500,N'Nữ','19600620',N'125 Trần Hưng Đạo, Q.1, TP HCM',NULL,NULL),
       ('003',N'Nguyễn Ngọc Ánh',2200,N'Nữ','19750511',N'12/21 Võ Văn Ngân Thủ Đức, TP HCM',NULL,NULL),
       ('004',N'Trương Nam Sơn',2300,N'Nam','19590620',N'215 Lý Thường Kiệt, TP Biên Hòa',NULL,NULL),
       ('005',N'Lý Hoàng Hà',2500,N'Nam','19541023',N'2/5 Nguyễn Xí, Q. Bình Thạnh, TP HCM',NULL,NULL),
       ('006',N'Trần Bạch Tuyết',1500,N'Nữ','19800520',N'127 Hùng Vương, TP Mỹ Tho',NULL,NULL),
       ('007',N'Nguyễn An Trung',2100,N'Nam','19760605',N'234 3/2 TP Biên Hòa',NULL,NULL),
       ('008',N'Trần Trung Hiếu',1800,N'Nam','19770806',N'22/11 Lý Thường Kiệt, TP Mỹ Tho',NULL,NULL),
       ('009',N'Trần Hoàng Nam',2000,N'Nam','19751122',N'234 Trần Não, An Phú, TP HCM',NULL,NULL),
       ('010',N'Phạm Nam Thanh',1500,N'Nam','19801212',N'221 Hùng Vương, Q.5, TP HCM',NULL,NULL);

UPDATE GiaoVien	SET Gvqlcm = '002' WHERE MaGiaoVien = '003';
UPDATE GiaoVien	SET Gvqlcm = '004' WHERE MaGiaoVien = '006';
UPDATE GiaoVien	SET Gvqlcm = '007' WHERE MaGiaoVien = '008';
UPDATE GiaoVien	SET Gvqlcm = '001' WHERE MaGiaoVien = '009';
UPDATE GiaoVien	SET Gvqlcm = '007' WHERE MaGiaoVien = '010';

INSERT GiaoVienDeTai
VALUES	('001','0838912112'),
          ('001','0903123123'),
          ('002','0913454545'),
          ('003','0838121212'),
          ('003','0903656565'),
          ('003','0937125125'),
          ('006','0937888888'),
          ('008','0653717171'),
          ('008','0913232323');

INSERT Khoa
VALUES ('CNTT',N'Công nghệ thông tin',1995,'B11','0838123456','002','20050220'),
       ('HH',N'Hóa học',1980,'B41','0838456456','007','20011015'),
       ('SH',N'Sinh học',1980,'B31','0834545454','004','20001011'),
       ('VL',N'Vật lý',1976,'B21','0838223223','005','20030918');

INSERT BoMon
VALUES  ('CNTT',N'Công nghệ tri thức','B15','0838126126',NULL,'CNTT',NULL),
        ('HHC',N'Hóa hữu cơ','B44','0832222222',NULL,'HH',NULL),
        ('HL',N'Hóa lý','B42','0838878787',NULL,'HH',NULL),
        ('HPT',N'Hóa phân tích','B43','0838777777','007','HH','20071015'),
        ('HTTT',N'Hệ thống thông tin','B13','0838125125','002','CNTT','20040920'),
        ('MMT',N'Mạng máy tính','B16','0838676767','001','CNTT','20050515'),
        ('SH',N'Sinh hóa','B33','0838898989',NULL,'SH',NULL),
        ('VLĐT',N'Vật lý điện tử','B23','0838234234',NULL,'VL',NULL),
        ('VLƯD',N'Vật lý ứng dụng','B24','0838454545','005','VL','20060218'),
        ('VS',N'Vi sinh','B32','0838909090','004','SH','20070101');

UPDATE GiaoVien	SET MaBoMon = 'MMT' WHERE MaGiaoVien = '001';
UPDATE GiaoVien	SET MaBoMon = 'HTTT' WHERE MaGiaoVien = '002';
UPDATE GiaoVien	SET MaBoMon = 'HTTT' WHERE MaGiaoVien = '003';
UPDATE GiaoVien	SET MaBoMon = 'VS' WHERE MaGiaoVien = '004';
UPDATE GiaoVien	SET MaBoMon = 'VLĐT' WHERE MaGiaoVien = '005';
UPDATE GiaoVien	SET MaBoMon = 'VS' WHERE MaGiaoVien = '006';
UPDATE GiaoVien	SET MaBoMon = 'HPT' WHERE MaGiaoVien = '007';
UPDATE GiaoVien	SET MaBoMon = 'HPT' WHERE MaGiaoVien = '008';
UPDATE GiaoVien	SET MaBoMon = 'MMT' WHERE MaGiaoVien = '009';
UPDATE GiaoVien	SET MaBoMon = 'HPT' WHERE MaGiaoVien = '010';

INSERT INTO ChuDe( MaChuDe, TenChuDe )
VALUES  (N'NCPT',N'Nghiên cứu phát triển'),
        (N'QLGD',N'Quản lý giáo dục'),
        (N'ƯDCN',N'Ứng dụng công nghệ');
INSERT DeTai
VALUES  ('001', N'HTTT quản lý các trường ĐH', N'ĐHQG', 20.0 ,'20071020','20081020', N'QLGD','002'),
        ('002', N'HTTT quản lý giáo vụ cho một Khoa', N'Trường', 20.0 ,'20001012','20011012', N'QLGD','002'),
        ('003', N'Nghiên cứu chế tạo sợ Nanô Platin', N'Nhà nước', 300.0 ,'20080515','20100515', N'NCPT','005'),
        ('004', N'Tạo vật liệu sinh học bằng màng ối người', N'ĐHQG', 100.0 ,'20070101','20091231', N'NCPT','004'),
        ('005', N'Ứng dụng hóa học xanh', N'Trường', 200.0 ,'20031010','20041210', N'ƯDCN','007'),
        ('006', N'Nghiên cứu tế bào gốc', N'Nhà nước', 4000.0 ,'20061020','20091020', N'NCPT','004'),
        ('007', N'HTTT quản lý thư viện ở các trường ĐH', N'Trường', 20.0 ,'20090510','20100510', N'QLGD','001');

INSERT CongViec
VALUES  ('001',1,N'Khởi tạo và lập kế hoạch','20071020','20081220'),
        ('001',2,N'Xác định yêu cầu','20081221','20080321'),
        ('001',3,N'Phân tích hệ thống','20080322','20080522'),
        ('001',4,N'Thiết kế hệ thống','20080523','20080623'),
        ('001',5,N'Cài đặt thử nghiệm','20080624','20081020'),
        ('002',1,N'Khởi tạo và Lập kế hoạch','20090510','20090710'),
        ('002',2,N'Xác định yêu cầu','20090711','20091011'),
        ('002',3,N'Phân tích hệ thống','20001012','20091220'),
        ('002',4,N'Thiết kế hệ thống','20091221','20100322'),
        ('002',5,N'Cài đặt thử nghiệm','20100323','20100510'),
        ('006',1,N'Lấy mẫu','20061020','20070220'),
        ('006',2,N'Nuôi cấy','20070221','20080821');

INSERT INTO ThamGiaDeTai
( MaGiaoVien, MaDeTai, SoThuTu, PHUCAP, KETQUA )
VALUES  ('001','002',1,0.0,NULL),
        ('001','002',2,2.0,NULL),
        ('002','001',4,2.0,N'Đạt'),
        ('003','001',1,1.0,N'Đạt'),
        ('003','001',2,0.0,N'Đạt'),
        ('003','001',4,1.0,N'Đạt'),
        ('003','002',2,0.0,NULL),
        ('004','006',1,0.0,N'Đạt'),
        ('004','006',2,1.0,N'Đạt'),
        ('006','006',2,1.5,N'Đạt'),
        ('009','002',3,0.5,NULL),
        ('009','002',4,1.5,NULL);

INSERT INTO NguoiThan
( MaGiaoVien, TEN, NgaySinh, PHAI )
VALUES  ('001',N'Hùng','19900114',N'Nam'),
        ('001',N'Thủy','19941208',N'Nữ'),
        ('003',N'Hà','19980903',N'Nữ'),
        ('003',N'Thu','19980903',N'Nữ'),
        ('007',N'Mai','20030326',N'Nữ'),
        ('007',N'Vy','20000214',N'Nữ'),
        ('008',N'Nam','19910506',N'Nam'),
        ('009',N'An','19960819',N'Nam'),
        ('010',N'Nguyệt','20060114',N'Nữ');