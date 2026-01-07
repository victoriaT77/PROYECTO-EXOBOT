package BusinessLogic.Entities;

import java.util.List;

import DataAccess.tvPersonaTipoDAO;
import DataAccess.DTO.tvPersonaTipoDTO;

public class tvPersonaTipoBL {
    // Add methods similar to EstadoCivilBL and SexoBL as needed    
    private tvPersonaTipoDTO ptDTO;
    private tvPersonaTipoDAO ptDAO = new tvPersonaTipoDAO(); 
    public tvPersonaTipoBL() {}   

    public List<tvPersonaTipoDTO> getAll() throws Exception {
        return ptDAO.readAll();
    }
    public tvPersonaTipoDTO getBy(int idReg) throws Exception {
        ptDTO=ptDAO.readBy(idReg);
        return ptDTO;
    }
    public boolean add(tvPersonaTipoDTO regDTO) throws Exception {
        return ptDAO.create(regDTO);
    }
    public boolean update(tvPersonaTipoDTO regDTO) throws Exception {
        return ptDAO.update(regDTO);
    }
    public boolean delete(int idCatalogo) throws Exception {
        return ptDAO.delete(idCatalogo);
    }
    public Integer getRowCount() throws Exception {
        return ptDAO.getRowCount();
    }

    
}
