package cl.duoc.vidasalud.report.dto;

import java.util.List;

public class ReportDtos {

    public record KpisResponse(
            String range,
            long atencionesPorHora,
            double tiempoEsperaPromedioMinutos,
            long enEspera,
            long enAtencion
    ) {}

    public record PrestacionDemandaResponse(
            String prestacion,
            long totalAtenciones
    ) {}

    public record TopServiciosResponse(
            String range,
            List<PrestacionDemandaResponse> prestaciones
    ) {}
}
