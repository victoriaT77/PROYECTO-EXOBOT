import BusinessLogic.Entities.tvEstadoCivilBL;
import BusinessLogic.Entities.tvPersonaTipoBL;
import BusinessLogic.Entities.tvSexoBL;
import DataAccess.tvEstadoCivilDAO;
import DataAccess.tvPersonaTipoDAO;
import DataAccess.tvSexoDAO;
import DataAccess.DTO.tvEstadoCivilDTO;
import DataAccess.DTO.tvPersonaTipoDTO;
import DataAccess.DTO.tvSexoDTO;

public class App {
    public static void main(String[] args) throws Exception {

        //Testing DAOs
        try {
            tvSexoDAO sexoDAO = new tvSexoDAO();
            for (tvSexoDTO sexo : sexoDAO.readAll()) {
                System.out.println(sexo.toString());
            }
            System.out.println("----------------------------");
            tvEstadoCivilDAO estadoCivil = new tvEstadoCivilDAO();
            for (tvEstadoCivilDTO reg:estadoCivil.readAll()) {
                System.out.println(reg.toString());
            }

            System.out.println("----------------------------");
            tvPersonaTipoDAO personaTipo = new tvPersonaTipoDAO();
            for (tvPersonaTipoDTO reg:personaTipo.readAll()) {
                System.out.println(reg.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
    }

    //Testing BL
        try {

            //Generar una excepcion para probar el encadenamiento

            //int a = a (100)/b
            // try{
            // int resultado =10/0;
            // int resultadoB=b/a(0);
            // }catch(NullPointerException ex){
            //     throw new Exception("Error en puntero nulo"+ex.getMessage());    
            //  catch(ArithmeticException ex){
            //     throw new Exception("Error en la division"+ex.getMessage());
            // }
            // catch(Exception e){
            //     System.out.println(e.toString());
            // }finally{
            //     System.out.println("Finally ejecutado");
            // }


            tvSexoBL sBL= new tvSexoBL();
            sBL.add(new tvSexoDTO(0,0,"Nuevo Sexo","sexo",null,null,null));
            for (tvSexoDTO sexo : sBL.getAll()) {
                System.out.println(sexo.toString());
            }
            System.out.println("----------------------------");
            tvEstadoCivilBL ecBL= new tvEstadoCivilBL();
            for (tvEstadoCivilDTO reg:ecBL.getAll()) {
                System.out.println(reg.toString());
            }
            System.out.println("----------------------------");
            tvPersonaTipoBL ptBL= new tvPersonaTipoBL();
            for (tvPersonaTipoDTO reg:ptBL.getAll()) {
                System.out.println(reg.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
    }
}
}
