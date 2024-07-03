package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicoActivo {

    @Autowired
    private MedicoRepository repository;

    public void validar(DatosAgendarConsulta datos){

        if (datos.idMedico()==null){
            return;
        }

        var medicoActivo = repository.findActivoById(datos.idMedico());

        if (!medicoActivo){
            throw new ValidationException("El medico se encuentra inactivo");
        }

    }
}
