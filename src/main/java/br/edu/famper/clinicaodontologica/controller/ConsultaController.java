package br.edu.famper.clinicaodontologica.controller;

import br.edu.famper.clinicaodontologica.dto.ConsultaDto;
import br.edu.famper.clinicaodontologica.exception.ResourceNotFoundException;
import br.edu.famper.clinicaodontologica.model.Consulta;
import br.edu.famper.clinicaodontologica.service.ConsultaService;
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
@RequestMapping("/api/consulta")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Consulta",
        description = "Operação para consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all queries from DB",
            description = "Fetches all queries from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<ConsultaDto> getAllConsultas() {
        log.info("Buscando todas as consultas");
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one querie from DB",
            description = "Fetches one querie from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<ConsultaDto> getConsultaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando consulta por id: {}", id);
        return ResponseEntity.ok().body(consultaService.getConsultaById(id));
    }

    @PostMapping
    @Operation(summary = "Salva a consulta",
            description = "Salva a consulta no banco de dados"
    )
    public Consulta createConsulta(@RequestBody ConsultaDto consultaDto) throws ResourceNotFoundException {
        log.info("Cadastro consulta: {}", consultaDto);
        return consultaService.saveConsulta(consultaDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza a consulta",
            description = "Atualiza a consulta no banco de dados"
    )
    public ResponseEntity<ConsultaDto> updateConsulta(@PathVariable(name = "id") Long id, @RequestBody ConsultaDto consultaDto) throws ResourceNotFoundException {
        log.info("Atualizando consulta: {}", consultaDto);
        return ResponseEntity.ok(consultaService.editConsulta(id, consultaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove consulta",
            description = "Remove a consulta do banco de dados"
    )
    public Map<String, Boolean> deleteConsulta(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando consulta: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", consultaService.deleteConsulta(id));
        return response;
    }
}