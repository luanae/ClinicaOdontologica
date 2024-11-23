package br.edu.famper.clinicaodontologica.controller;

import br.edu.famper.clinicaodontologica.dto.PacienteDto;
import br.edu.famper.clinicaodontologica.exception.ResourceNotFoundException;
import br.edu.famper.clinicaodontologica.model.Paciente;
import br.edu.famper.clinicaodontologica.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/paciente")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Paciente",
        description = "Operation for patient")
public class PacienteController {
    private final PacienteService pacienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all patient from DB",
            description = "Fetches all patient from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<PacienteDto> getAllPacientes() {
        log.info("Buscando todas os pacientes");
        return pacienteService.getAllPacientes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one patient from DB",
            description = "Fetches one patient from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<PacienteDto> getPacienteById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando paciente por id: {}", id);
        return ResponseEntity.ok().body(pacienteService.getPacienteById(id));
    }

    @PostMapping
    @Operation(summary = "Save patient",
            description = "Save a patient in database"
    )
    public Paciente createPaciente(@RequestBody PacienteDto pacienteDto) throws ResourceNotFoundException {
        log.info("Cadastro paciente: {}", pacienteDto);
        return pacienteService.savePaciente(pacienteDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update patient",
            description = "Update a patient in database"
    )
    public ResponseEntity<PacienteDto> updatePaciente(@PathVariable(name = "id") Long id, @RequestBody PacienteDto pacienteDto) throws ResourceNotFoundException {
        log.info("Atualizando paciente: {}", pacienteDto);
        return ResponseEntity.ok(pacienteService.editPaciente(id, pacienteDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove patient",
            description = "Remove a patient in database"
    )
    public Map<String, Boolean> deletePaciente(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando paciente: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", pacienteService.deletePaciente(id));
        return response;
    }
}
