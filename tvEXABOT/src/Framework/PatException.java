package Framework;

public class PatException extends Exception {
    
    public PatException(String e,String clase, String metodo){
        System.out.println("Error APP --> LOG: "+clase+" en el metodo: "+metodo+" por la razon: "+e);
        
    }
    @Override
    public String getMessage(){
        return "No seas sapo.....";
    }

}
