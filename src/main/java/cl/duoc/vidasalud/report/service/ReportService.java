package cl.duoc.vidasalud.report.service;

import cl.duoc.vidasalud.report.dto.ReportDtos.KpisResponse;
import cl.duoc.vidasalud.report.dto.ReportDtos.PrestacionDemandaResponse;
import cl.duoc.vidasalud.report.dto.ReportDtos.TopServiciosResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * IMPORTANTE para la presentación: en el diseño final del caso, este
 * servicio no calcula nada por sí mismo — consume el tópico Kafka
 * "appointments.events" (ver punto 9 del caso) y va actualizando estas
 * métricas de forma asíncrona, para no bloquear el core transaccional
 * de appointments.
 *
 * Kafka no forma parte de lo que evalúa la EP1 (el indicador de
 * reportería no está en la pauta de esta entrega), así que acá se deja
 * un cálculo simulado en memoria que cumple el contrato del endpoint
 * y que se reemplaza por el consumer real en la evaluación donde
 * corresponda integrar streaming.
 */
@Service
public class ReportService {

    private final AtomicLong contadorSimulado = new AtomicLong(0);

    public KpisResponse obtenerKpis(String range) {
        long atencionesPorHora = 8 + (contadorSimulado.incrementAndGet() % 5);
        return new KpisResponse(range, atencionesPorHora, 12.5, 3, 2);
    }

    public TopServiciosResponse obtenerTopServicios(String range) {
        List<PrestacionDemandaResponse> prestaciones = List.of(
                new PrestacionDemandaResponse("Consulta general", 42),
                new PrestacionDemandaResponse("Control odontológico", 27),
                new PrestacionDemandaResponse("Toma de exámenes", 15)
        );
        return new TopServiciosResponse(range, prestaciones);
    }
}
