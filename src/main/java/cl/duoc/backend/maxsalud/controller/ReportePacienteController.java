package cl.duoc.backend.maxsalud.controller;

import cl.duoc.backend.maxsalud.service.ReportePacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReportePacienteController {

    @Autowired
    private ReportePacienteService reporteService;

    /**
     * Endpoint para obtener el reporte completo de pacientes
     * GET http://localhost:8080/api/reportes/completo
     * 
     * @return Lista de reportes completos con información general, descuentos y multas
     */
    @GetMapping("/completo")
    public ResponseEntity<?> obtenerReporteCompleto() {
        try {
            List<?> reporte = reporteService.generarReporteCompleto();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Reporte completo generado exitosamente");
            response.put("data", reporte);
            response.put("total", reporte.size());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return manejarError(e, "Error al generar el reporte completo");
        }
    }

    /**
     * Endpoint para obtener el reporte de pacientes con descuentos
     * GET http://localhost:8080/api/reportes/con-descuentos
     * 
     * @return Lista de pacientes que tienen descuentos aplicados por edad
     */
    @GetMapping("/con-descuentos")
    public ResponseEntity<?> obtenerReporteConDescuentos() {
        try {
            List<?> reporte = reporteService.generarReporteConDescuentos();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Reporte de pacientes con descuentos generado exitosamente");
            response.put("data", reporte);
            response.put("total", reporte.size());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return manejarError(e, "Error al generar el reporte de descuentos");
        }
    }

    /**
     * Endpoint para obtener el reporte de pacientes morosos
     * GET http://localhost:8080/api/reportes/morosos
     * 
     * @return Lista de atenciones con pagos morosos y multas aplicadas
     */
    @GetMapping("/morosos")
    public ResponseEntity<?> obtenerReporteMorosos() {
        try {
            List<?> reporte = reporteService.generarReporteMorosos();
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Reporte de pacientes morosos generado exitosamente");
            response.put("data", reporte);
            response.put("total", reporte.size());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return manejarError(e, "Error al generar el reporte de morosos");
        }
    }

    /**
     * Endpoint genérico para obtener cualquier tipo de reporte usando query param
     * GET http://localhost:8080/api/reportes?tipo=COMPLETO
     * GET http://localhost:8080/api/reportes?tipo=CON_DESCUENTOS
     * GET http://localhost:8080/api/reportes?tipo=MOROSOS
     * 
     * @param tipo Tipo de reporte (COMPLETO, CON_DESCUENTOS, MOROSOS). Por defecto: COMPLETO
     * @return Lista de reportes según el tipo especificado
     */
    @GetMapping
    public ResponseEntity<?> obtenerReportePorTipo(
            @RequestParam(value = "tipo", defaultValue = "COMPLETO") String tipo) {
        try {
            List<?> reporte = reporteService.generarReportePorTipo(tipo);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Reporte tipo '" + tipo + "' generado exitosamente");
            response.put("tipoReporte", tipo.toUpperCase());
            response.put("data", reporte);
            response.put("total", reporte.size());
            
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("success", false);
            error.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        } catch (Exception e) {
            return manejarError(e, "Error al generar el reporte");
        }
    }

    /**
     * Método auxiliar para manejar errores de forma consistente
     */
    private ResponseEntity<?> manejarError(Exception e, String mensaje) {
        Map<String, Object> error = new HashMap<>();
        error.put("success", false);
        error.put("message", mensaje);
        error.put("error", e.getMessage());
        
        e.printStackTrace(); // Para debugging
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
