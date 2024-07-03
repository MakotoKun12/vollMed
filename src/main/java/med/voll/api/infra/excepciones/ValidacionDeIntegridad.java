package med.voll.api.infra.excepciones;

public class ValidacionDeIntegridad extends RuntimeException{

    public ValidacionDeIntegridad(String s){
        super(s);
    }
}
