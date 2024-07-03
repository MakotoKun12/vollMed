package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class PacienteSinConsulta {

    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(19);

        var pacienteConConsulta = repository.existsByPacienteIdAndDataBetween(datos.idPaciente(),primerHorario,ultimoHorario);

        if (pacienteConConsulta){
            throw new ValidationException("EL paciente ya tiene una consulta para ese dia");
        }
    }
}
