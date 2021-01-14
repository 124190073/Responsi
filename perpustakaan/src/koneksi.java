/* Endang Herlina
*124190073
*PBO C
*/

import java.sql.*;

public class koneksi{
    public Connection konek = null;
    public Connection konekDatabase(){
        try{
            //setting driver mysql
            Class.forName("com.mysql.jdbc.Driver");
             //buat connection
            konek = DriverManager.getConnection("jdbc:mysql://localhost/responsi","root","");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Connnectioon Error : " + e.getMessage());
        }
        
    return konek;
    }

    
}