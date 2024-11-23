package br.edu.famper.clinicaodontologica.controller;

import br.edu.famper.clinicaodontologica.dto.PagamentoDto;
import br.edu.famper.clinicaodontologica.exception.ResourceNotFoundException;
import br.edu.famper.clinicaodontologica.model.Pagamento;
import br.edu.famper.clinicaodontologica.service.PagamentoService;
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
@RequestMapping("/api/pagamento")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Pagamento",
        description = "Operation for payment")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all payment from DB",
            description = "Fetches all payment from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public List<PagamentoDto> getAllPagamentos() {
        log.info("Buscando todas os pagamentos");
        return pagamentoService.getAllPagamentos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one payment from DB",
            description = "Fetches one payment from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<PagamentoDto> getPagamentoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando pagamento por id: {}", id);
        return ResponseEntity.ok().body(pagamentoService.getPagamentoById(id));
    }

    @PostMapping
    @Operation(summary = "Salva o pagamento",
            description = "Salva o pagamento no banco de dados"
    )
    public Pagamento createPagamento(@RequestBody PagamentoDto pagamentoDto) throws ResourceNotFoundException {
        log.info("Cadastro pagamento: {}", pagamentoDto);
        return pagamentoService.savepagamento(pagamentoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualiza pagamento",
            description = "Atualiza pagamento no banco de dados"
    )
    public ResponseEntity<PagamentoDto> updatePagamento(@PathVariable(name = "id") Long id, @RequestBody PagamentoDto pagamentoDto) throws ResourceNotFoundException {
        log.info("Atualizando pagamento: {}", pagamentoDto);
        return ResponseEntity.ok(pagamentoService.editPagamento(id, pagamentoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove pagameneto",
            description = "Remove um pagamento do banco de dados"
    )
    public Map<String, Boolean> deletePagamento(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando pagamento: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletedo", pagamentoService.deletePagamento(id));
        return response;
    }
}
