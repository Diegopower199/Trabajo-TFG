package tfg.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import commonclasses.TransaccionVacacion;
import tfg.backend.constants.GlobalConstants;

import tfg.backend.services.BlockchainVacacionAutorizadaService;

// Propósito: Controla la interacción con el cliente y maneja las solicitudes HTTP relacionadas con las vacaciones autorizadas.

@CrossOrigin(origins = GlobalConstants.FRONTEND_URL, methods = { RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/blockchainVacacionesAutorizadas")
public class BlockchainVacacionAutorizadaController {

    @Autowired
    BlockchainVacacionAutorizadaService vacacionAutorizadaService;

    // localhost:8080/vacacionesEmpleados/api/getAll
    @GetMapping("/api/getAll")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        List<Map<String, Object>> allVacacionesEmpleados = vacacionAutorizadaService
                .getAllTransaccionesVacacionesAutorizadas();
        if (allVacacionesEmpleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allVacacionesEmpleados);
        }
    }

    // localhost:8080/vacacionesAutorizadas/api/save
    @PostMapping("/api/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody TransaccionVacacion vacacionEmpleadoRequest) {
        try {

            TransaccionVacacion newVacacionAutorizada = vacacionAutorizadaService
                    .saveTransaccionVacacionAutorizada(vacacionEmpleadoRequest);

            if (newVacacionAutorizada == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            } else {
                return ResponseEntity.ok(newVacacionAutorizada.toMap());
            }

        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            // No sé si en el status poner bad_request o 409
        }
    }
}
