package BusinessLogic.Entities;

import java.util.List;

import DataAccess.tvEstadoCivilDAO;
import DataAccess.DTO.tvEstadoCivilDTO;

public class tvEstadoCivilBL {
    private tvEstadoCivilDTO ecDTO;
    private tvEstadoCivilDAO eDAO = new tvEstadoCivilDAO();

    public tvEstadoCivilBL() {}

    public List<tvEstadoCivilDTO> getAll() throws Exception {
        List<tvEstadoCivilDTO> lst= eDAO.readAll();
        for (tvEstadoCivilDTO eDTO : lst) {
            //Regla de negocio: convertir a mayusculas el nombre del estado civil
            eDTO.setNombre(eDTO.getNombre().toUpperCase());
        }
        return lst;
    }
    public tvEstadoCivilDTO getBy(int idEstadoCivil) throws Exception {
        ecDTO=eDAO.readBy(idEstadoCivil);
        return ecDTO;
    }
    public boolean add(tvEstadoCivilDTO regDTO) throws Exception {
        return eDAO.create(regDTO);
    }
    public boolean update(tvEstadoCivilDTO regDTO) throws Exception {
        return eDAO.update(regDTO);
    }
    public boolean delete(int idEstadoCivil) throws Exception {
        return eDAO.delete(idEstadoCivil);
    }
    public Integer getRowCount() throws Exception {
        return eDAO.getRowCount();
    }
}
