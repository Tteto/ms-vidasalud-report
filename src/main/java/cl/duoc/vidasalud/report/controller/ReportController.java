package cl.duoc.vidasalud.report.controller;

import cl.duoc.vidasalud.report.dto.ReportDtos.KpisResponse;
import cl.duoc.vidasalud.report.dto.ReportDtos.TopServiciosResponse;
import cl.duoc.vidasalud.report.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    @GetMapping("/kpis")
    public KpisResponse kpis(@RequestParam(defaultValue = "last24h") String range) {
        return service.obtenerKpis(range);
    }

    @GetMapping("/top-services")
    public TopServiciosResponse topServicios(@RequestParam(defaultValue = "last7d") String range) {
        return service.obtenerTopServicios(range);
    }
}
