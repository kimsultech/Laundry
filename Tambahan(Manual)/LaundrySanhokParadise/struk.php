<?php 
include "config/koneksi.php";
?>
<form method="post">
<table border="1" align="center">
  <tr>
    <td>
      <div class="utama">
		<table align="center">
      		<tr>
        		<td width="7%" rowspan="3" align="center" valign="top"><img src="img/struk.png" style="width:75px; height:70px;"></td>
        		<td width="93%" valign="top">&nbsp;<b>LAUNDRY SANHOK PARADISE</b></td>
      		</tr>
      		<tr>
       			<td valign="top">&nbsp;Jl.Kolonel Military Base , Bandung 40511 , Cisarua</td>
      		</tr>
    	</table>
    	<table width="100%">
      	<tr><td><hr></td></tr>
    	</table>
  		<table cellspacing="0" align="center">  
  		<?php @$sql = "SELECT * FROM transaksi INNER JOIN penerimaan USING(no_order) where no_transaksi = '$_GET[id]'";
		      $query = mysqli_query($con,$sql);
		      $row = mysqli_fetch_array($query)	
		 ?>
		<tr>
			<td>Nama      </td><td>: </td><td> &nbsp;<?php echo $row['nama_pelanggan']?></td>
		</tr>
		<tr>
      		<td>Tanggal     </td><td>: </td><td> &nbsp;<?php echo $row['tgl_masuk']; ?></td>
     	</tr>
      	<tr>
      		<td>Total </td><td>: </td><td> &nbsp;Rp.<?php echo $row['t_bayar']; ?></td>
      	</tr>
        <tr>
          <td>Bayar </td><td>: </td><td> &nbsp;Rp.<?php $a = $row['bayar']; $b = $row['dibayar']; echo $a + $b; ?></td>
        </tr>
        <tr>
          <td>Kembalian </td><td>: </td><td> &nbsp;Rp.<?php echo $row['kembalian']; ?></td>
        </tr>
    	<table  width="100%">
      		<tr><td><hr></td></tr>
      		<tr><td><center> SELAMAT DATANG KEMBALI </center><hr></td></tr>
    	</table>
    	<table align="center">
      		<tr>
        		<td>&copy; <?php echo date('Y'); ?> LSP</td>
      		</tr>
    	</table>
	</div>
    </td>
  </tr>
</table>
</form>


<script type="text/javascript">
  window.onload=function(){
  window.print();
}
</script> 