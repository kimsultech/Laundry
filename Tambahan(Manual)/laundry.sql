-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Bulan Mei 2019 pada 05.52
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenis_cucian`
--

CREATE TABLE `jenis_cucian` (
  `kd_jenis` int(11) NOT NULL,
  `jenis_cucian` varchar(30) NOT NULL,
  `harga` int(110) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `jenis_cucian`
--

INSERT INTO `jenis_cucian` (`kd_jenis`, `jenis_cucian`, `harga`) VALUES
(2, 'Cuci Kering + Cuci Basah', 8000),
(3, 'Cuci Basah + Parfum', 7500),
(4, 'Jenis', 2000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(30) NOT NULL,
  `nama_pelanggan` varchar(40) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `telp`) VALUES
(1, 'Sultan', 'Cisarua', '08876322'),
(2, 'KimSul', 'Cisarua', '81765411'),
(5, 'Ryujin', 'Seoul', '817655625452'),
(6, 'NC.A', 'Seoul', '81752675672'),
(8, 'Fair Xing', 'Hulunbuir,Republik Rakyat Tiongkok', '16923874235');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penerimaan`
--

CREATE TABLE `penerimaan` (
  `no_order` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `nama_pelanggan` varchar(40) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `tgl_keluar` date NOT NULL,
  `t_bayar` int(20) NOT NULL,
  `bayar` int(20) NOT NULL,
  `sisa` int(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `kd_jenis` int(11) NOT NULL,
  `jenis_cucian` varchar(40) NOT NULL,
  `harga` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `pengerjaan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penerimaan`
--

INSERT INTO `penerimaan` (`no_order`, `id_pelanggan`, `nama_pelanggan`, `tgl_masuk`, `tgl_keluar`, `t_bayar`, `bayar`, `sisa`, `status`, `kd_jenis`, `jenis_cucian`, `harga`, `berat`, `keterangan`, `pengerjaan`) VALUES
(2, 1, 'Sultan', '2019-04-08', '2019-04-10', 40000, 50000, 10000, 'Lunas', 2, 'Cuci Kering + Cuci Basah', 8000, 5, 'Tets keterangan', 'Diambil'),
(3, 6, 'Park Min Young', '2019-04-10', '2019-04-19', 37500, 30000, -7500, 'Belum Lunas', 3, 'Cuci Basah + Parfum', 7500, 5, 'Baju,Celana', 'Diambil'),
(4, 6, 'Kim', '2019-04-10', '2019-04-18', 40000, 40000, 0, 'Lunas', 2, 'Cuci Kering + Cuci Basah', 8000, 5, 'Jaket', 'Diberikan'),
(5, 6, 'KimSul', '2019-04-25', '2019-04-27', 120000, 100000, -20000, 'Lunas', 2, 'Cuci Kering + Cuci Basah', 8000, 15, 'Selimut,Baju', 'Diambil');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` int(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `hakakses` enum('admin','user','','') NOT NULL,
  `nama_pengguna` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `username`, `password`, `hakakses`, `nama_pengguna`) VALUES
(3, 'kim', 'kim', 'admin', 'Kim Sultan'),
(4, 'xing_fair', 'fair', 'admin', 'Fair Xing'),
(5, 'admin', 'admin', 'admin', 'Ini Admin'),
(8, 'user', 'user', 'user', 'Ini User');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `no_transaksi` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `no_order` int(11) NOT NULL,
  `dibayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`no_transaksi`, `tgl_transaksi`, `no_order`, `dibayar`, `kembalian`) VALUES
(1, '2019-04-22', 4, 0, 0),
(2, '2019-04-22', 3, 10000, 2500),
(3, '2019-04-22', 2, 0, 0),
(4, '2019-04-22', 3, 0, 0),
(5, '2019-04-22', 3, 777, -6723),
(6, '2019-04-25', 5, 20000, 0);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenis_cucian`
--
ALTER TABLE `jenis_cucian`
  ADD PRIMARY KEY (`kd_jenis`),
  ADD KEY `kd_jenis` (`kd_jenis`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `penerimaan`
--
ALTER TABLE `penerimaan`
  ADD PRIMARY KEY (`no_order`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `kd_jenis` (`kd_jenis`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_transaksi`),
  ADD KEY `no_order` (`no_order`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenis_cucian`
--
ALTER TABLE `jenis_cucian`
  MODIFY `kd_jenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `penerimaan`
--
ALTER TABLE `penerimaan`
  MODIFY `no_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id_pengguna` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `no_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `penerimaan`
--
ALTER TABLE `penerimaan`
  ADD CONSTRAINT `penerimaan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `penerimaan_ibfk_2` FOREIGN KEY (`kd_jenis`) REFERENCES `jenis_cucian` (`kd_jenis`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`no_order`) REFERENCES `penerimaan` (`no_order`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
