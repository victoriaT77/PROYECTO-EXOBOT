package BusinessLogic.Entities;

import java.util.List;

import DataAccess.tvSexoDAO;
import DataAccess.DTO.tvSexoDTO;

public class tvSexoBL {
    private tvSexoDTO sexo;
    private tvSexoDAO sDAO = new tvSexoDAO();

    public tvSexoBL() {}

    public List<tvSexoDTO> getAll() throws Exception {
        List<tvSexoDTO> lst= sDAO.readAll();
        for (tvSexoDTO sexoDTO : lst) {
            //Regla de negocio: convertir a mayusculas el nombre del sexo
            sexoDTO.setNombre(sexoDTO.getNombre().toUpperCase());
        }
        return lst;
    }
    public tvSexoDTO getBy(int idSexo) throws Exception {
        sexo=sDAO.readBy(idSexo);
        return sexo;
    }
    public boolean add(tvSexoDTO sexoDTO) throws Exception {
        return sDAO.create(sexoDTO);
    }
    public boolean update(tvSexoDTO sexoDTO) throws Exception {
        return sDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception {
        return sDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception {
        return sDAO.getRowCount();
    }
}
