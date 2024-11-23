package br.edu.famper.clinicaodontologica.controller;

import br.edu.famper.clinicaodontologica.dto.TratamentoDto;
import br.edu.famper.clinicaodontologica.exception.ResourceNotFoundException;
import br.edu.famper.clinicaodontologica.model.Tratamento;
import br.edu.famper.clinicaodontologica.service.TratamentoService;
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
@RequestMapping("/api/tratamento")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Tratamento",
        description = "Operation for treatment")
public class TratamentoController {

    private final TratamentoService tratamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all treatments from DB",
            description = "Fetches all treatments from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<TratamentoDto> getAllTratamentos() {
        log.info("Buscando todas as tratamentos");
        return tratamentoService.getAllTratamentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one treatment from DB",
            description = "Fetches one treatment from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<TratamentoDto> getTratamentoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando tratamento por id: {}", id);
        return ResponseEntity.ok().body(tratamentoService.getTratamentoById(id));
    }

    @PostMapping
    @Operation(summary = "Save treatment",
            description = "Save a treatment in database"
    )
    public Tratamento createTratamento(@RequestBody TratamentoDto tratamentoDto) throws ResourceNotFoundException {
        log.info("Cadastro tratamento: {}", tratamentoDto);
        return tratamentoService.saveTratamento(tratamentoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update treatment",
            description = "Update a treatment in database"
    )
    public ResponseEntity<TratamentoDto> updateTratamento(@PathVariable(name = "id") Long id, @RequestBody TratamentoDto tratamentoDto) throws ResourceNotFoundException {
        log.info("Atualizando tratamento: {}", tratamentoDto);
        return ResponseEntity.ok(tratamentoService.editTratamento(id, tratamentoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove treatment",
            description = "Remove a treatment in database"
    )
    public Map<String, Boolean> deleteTratamento(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando tratamento: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", tratamentoService.deleteTratamento(id));
        return response;
    }
}
