package br.edu.famper.clinicaodontologica.controller;

import br.edu.famper.clinicaodontologica.dto.DentistaDto;
import br.edu.famper.clinicaodontologica.exception.ResourceNotFoundException;
import br.edu.famper.clinicaodontologica.model.Dentista;
import br.edu.famper.clinicaodontologica.service.DentistaService;
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
@RequestMapping("/api/dentista")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Dentista",
        description = "Operação para dentista")
public class DentistaController {
    private final DentistaService dentistaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all dentist from DB",
            description = "Fetches all dentist from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<DentistaDto> getAllDentistas() {
        log.info("Buscando todas as dentistas");
        return dentistaService.getAllDentistas();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one dentist from DB",
            description = "Fetches one dentist from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<DentistaDto> getDentistaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando dentista por id: {}", id);
        return ResponseEntity.ok().body(dentistaService.getDentistaById(id));
    }

    @PostMapping
    @Operation(summary = "Salva dentista",
            description = "Salva o dentista no banco de dados"
    )
    public Dentista createDentista(@RequestBody DentistaDto dentistaDto) throws ResourceNotFoundException {
        log.info("Cadastro dentista: {}", dentistaDto);
        return dentistaService.saveDentista(dentistaDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update dentist",
            description = "Update a dentist in database"
    )
    public ResponseEntity<DentistaDto> updateDentista(@PathVariable(name = "id") Long id, @RequestBody DentistaDto dentistaDto) throws ResourceNotFoundException {
        log.info("Atualizando dentista: {}", dentistaDto);
        return ResponseEntity.ok(dentistaService.editDentista(id, dentistaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove dentist",
            description = "Remove a dentist in database"
    )
    public Map<String, Boolean> deleteDentista(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando dentista: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", dentistaService.deleteDentista(id));
        return response;
    }
}
