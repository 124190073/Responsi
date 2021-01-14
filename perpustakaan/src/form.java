/* Endang Herlina
*124190073
*PBO C
*/

import java.sql.*;

public class form {
    private String query;
    private ResultSet rs;
    private Statement stmt;
    private ResultSet rs_c;
    private Statement stmt_c;
    private int jumBaris;
    
    public String [][]getform(){
        koneksi kon = new koneksi();
        Connection connect = kon.konekDatabase();
        String data [][]= null;
        try{
            stmt = connect.createStatement();
            //ambil data
            query = "SELECT id,judul,genre,penulis,penerbit,lokasi,stok " + " from buku "
                    + " order by id";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jumlahKolom = meta.getColumnCount();
            data = new String [1000][jumlahKolom];
            int a = 0;
            while (rs.next()){
                for(int c=0; c<jumlahKolom; c++){
                    data[a][c]=rs.getString(c+1);
                }
                a++;
            }
            int jumlahBaris = a;
            String [][]tmparray = data;
            data = new String[jumlahBaris][jumlahKolom];
            for(a=0; a<jumlahBaris; a++){
                for(int c=0; c<jumlahKolom; c++){
                   data[a][c] = tmparray [a][c];
                }
            }
            stmt.close();
            connect.close();
        }catch(SQLException ex){
             System.out.println("Error : " + ex.getMessage());
        }
        return data;
    }
    
    public int tambah (String id, String judul, String genre, String penulis, String penerbit, String lokasi, String stok){
        jumBaris = 0;
        koneksi kon = new koneksi();
        Connection connect = kon.konekDatabase();
        try{
            stmt = connect.createStatement();
            query = "insert into buku (id,judul,genre,penulis,penerbit,lokasi,stok)" 
               + " values ('"+id+"','"+judul+"','"+genre+"','"+penulis+"','"+penerbit+"','"+lokasi+"','"+stok+"')";
            stmt.executeUpdate(query);
            stmt_c = connect.createStatement();
            rs_c = stmt_c.executeQuery("SELECT COUNT(*) FROM 'buku'");
            while (rs_c.next()){
                jumBaris = rs_c.getInt(1);
            }
            stmt.close();
            stmt_c.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return jumBaris;
    }
    
    public void Update(String id, String judul, String genre, String penulis, String penerbit, String lokasi, String stok){
        koneksi kon = new koneksi();
        Connection connect = kon.konekDatabase();
        try{
            stmt = connect.createStatement();
            query = "update buku set judul ='"+judul+"', genre ='"+genre+"', penulis ='"+penulis+"', penerbit='"+penerbit+"', lokasi='"+lokasi+"',stok='"+stok+"'" 
                    +" where id='"+id+"'";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
    
    public void Hapus (String id){
        koneksi kon = new koneksi();
        Connection connect = kon.konekDatabase();
        try{
            stmt = connect.createStatement();
            query = "DELETE FROM buku WHERE id='"+id+"'";
            stmt.executeUpdate(query);
            
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : " + ex.getMessage());
        } 
    }
    
    public String getData(String id){
        koneksi kon = new koneksi();
        Connection connect = kon.konekDatabase();
        String data = null;
        try{
            stmt = connect.createStatement();
            query = "SELECT id,judul,genre,penulis,penerbit,lokasi,stok from buku " + "where id= '"+id+"'";
            rs = stmt.executeQuery(query);
            while (rs.next()){
                data  = rs.getString(1);
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return data;
    }
}

 