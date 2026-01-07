package DataAccess;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.tvSexoDTO;
import Framework.PatException;

public class tvSexoDAO extends DataHelperSQLite implements IDAO<tvSexoDTO> {
    @Override
    public List<tvSexoDTO> readAll() throws Exception {
        List<tvSexoDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo"
                + " ,IdCatalogoTipo"
                + " ,Nombre"
                + " ,Descripcion"
                + " ,Estado"
                + " , FechaCreacion"
                + " , FechaModificacion"
                + " FROM Catalogo"
                + " WHERE IdCatalogoTipo = 2"
                + " AND Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                tvSexoDTO sexo = new tvSexoDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                );
                lst.add(sexo);
            }
            rs.close();
            pstmt.close();
            return lst;
        } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
        }
    }

    @Override
    public boolean create(tvSexoDTO entity) throws Exception {
         String query = "INSERT INTO Catalogo (idCatalogoTipo, Nombre, Descripcion) VALUES (?, ? ,?)";
         try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
            } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
            }
    }

    @Override
    public boolean update(tvSexoDTO entity) throws Exception {
        DateTimeFormatter   dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime       now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET Nombre = ?, Descripcion = ?, FechaModificacion = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
            }
    }@Override
    public tvSexoDTO readBy(Integer id) throws Exception {
       tvSexoDTO s =new tvSexoDTO();
         String query = "SELECT IdCatalogo,"
                + " IdCatalogoTipo,"
                + " Nombre,"
                + " Descripcion,"
                + " Estado,"
                + " FechaCreacion,"
                + " FechaModificacion"
                + " FROM Catalogo"
                + " WHERE Estado = 'A'"
                + " AND IdCatalogoTipo =2"
                + " AND IdCatalogo = "+ id.toString();
                
        try {
            Connection conn = openConnection();
            Statement   stmt = conn.createStatement();
            ResultSet   rs   = stmt.executeQuery(query);
            while(rs.next()){
                s=new tvSexoDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                );


            }
            return s;
        } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
            }
        }
    
    @Override
        public Integer getRowCount() throws Exception {

            String query = "SELECT COUNT(*) TotalReg FROM Catalogo WHERE Estado = 'A' AND IdCatalogoTipo = 2";
            try {
                Connection conn = openConnection();
                Statement   stmt = conn.createStatement();
                ResultSet   rs   = stmt.executeQuery(query);
                if(rs.next()){
                    return rs.getInt(1);
                }
                return 0;
            } catch (SQLException e) {
                throw new PatException(e.getMessage(), getClass().getName(), "getRowCount");
            }
        }
    
}
