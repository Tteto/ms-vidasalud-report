package cl.duoc.vidasalud.report.service;

import cl.duoc.vidasalud.report.dto.ReportDtos.KpisResponse;
import cl.duoc.vidasalud.report.dto.ReportDtos.TopServiciosResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReportServiceTest {

    private final ReportService service = new ReportService();

    @Test
    void devuelveKpisConElRangoSolicitado() {
        KpisResponse kpis = service.obtenerKpis("last24h");

        assertThat(kpis.range()).isEqualTo("last24h");
        assertThat(kpis.atencionesPorHora()).isGreaterThan(0);
    }

    @Test
    void devuelveTopServiciosNoVacio() {
        TopServiciosResponse top = service.obtenerTopServicios("last7d");

        assertThat(top.prestaciones()).isNotEmpty();
    }
}
