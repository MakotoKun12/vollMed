package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.infra.excepciones.ValidacionDeIntegridad;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HorarioAnticipacion {

    public void validar(DatosAgendarConsulta datos){
        var ahora = LocalDateTime.now();
        var horaConsulta = datos.fecha();

        var diferenciaDe30Min = Duration.between(ahora,horaConsulta).toMinutes()<30;

        if (diferenciaDe30Min){
            throw new ValidationException("Las consultas deben programarse con al menos 30 minutos de anticipacion");
        }
    }
}
