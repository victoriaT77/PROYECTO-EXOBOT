package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import DataAccess.DTO.tvEstadoCivilDTO;

public class tvEstadoCivilDAO extends DataHelperSQLite implements IDAO<tvEstadoCivilDTO> {

    @Override
    public List<tvEstadoCivilDTO> readAll() throws Exception {
        List<tvEstadoCivilDTO> lst = new ArrayList<>();
        String query = "SELECT IdCatalogo"
                + " ,IdCatalogoTipo"
                + " ,Nombre"
                + " ,Descripcion"
                + " ,Estado"
                + " , FechaCreacion"
                + " , FechaModificacion"
                + " FROM Catalogo"
                + " WHERE IdCatalogoTipo = 3"
                + " AND Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                tvEstadoCivilDTO sexo = new tvEstadoCivilDTO(
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
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean create(tvEstadoCivilDTO entity) throws Exception {
         String query = "INSERT INTO Catalogo (idCatalogoTipo, Nombre, Descripcion) VALUES (?, ? ,?)";
         try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
            } catch (Exception e) {
                throw e;
            }
    }

    @Override
    public boolean update(tvEstadoCivilDTO entity) throws Exception {
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
            throw e;
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
            throw e;
        }
    }@Override
    public tvEstadoCivilDTO readBy(Integer id) throws Exception {
       tvEstadoCivilDTO s =new tvEstadoCivilDTO();
         String query = "SELECT IdCatalogo,"
                + " IdCatalogoTipo,"
                + " Nombre,"
                + " Descripcion,"
                + " Estado,"
                + " FechaCreacion,"
                + " FechaModificacion"
                + " FROM Catalogo"
                + " WHERE Estado = 'A'"
                + " AND IdCatalogoTipo =3"
                + " AND IdCatalogo = "+ id.toString();
                
        try {
            Connection conn = openConnection();
            Statement   stmt = conn.createStatement();
            ResultSet   rs   = stmt.executeQuery(query);
            while(rs.next()){
                s=new tvEstadoCivilDTO(
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
            throw e;
        }
        }
    
        @Override
        public Integer getRowCount() throws Exception {
            
            String query = "SELECT COUNT(*) TotalReg FROM Catalogo WHERE Estado = 'A' AND IdCatalogoTipo = 3";
            try {
                Connection conn = openConnection();
                Statement   stmt = conn.createStatement();
                ResultSet   rs   = stmt.executeQuery(query);
                if(rs.next()){
                    return rs.getInt(1);
                }
                return 0;
            } catch (SQLException e) {
                throw e;
            }

    }
}
