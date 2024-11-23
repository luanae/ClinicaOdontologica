package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.PagamentoDto;
import br.edu.famper.clinicaodontologica.model.Pagamento;
import br.edu.famper.clinicaodontologica.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoDto> getAllPagamentos(){
        return pagamentoRepository
                .findAll()
                .stream()
                .map(pagamento -> PagamentoDto
                        .builder()
                        .valor(pagamento.getValor())
                        .dataPagamento(pagamento.getDataPagamento())
                        .formaPagamento(pagamento.getFormaPagamento())
                        .build()
                )
                .toList();
    }

    //buscar
    public PagamentoDto getPagamentoById(long id){
        Pagamento pag = pagamentoRepository.findById(id).orElseThrow();
        return new PagamentoDto()
                .builder()
                .valor(pag.getValor())
                .dataPagamento(pag.getDataPagamento())
                .formaPagamento(pag.getFormaPagamento())
                .build();
    }

    //inserir
    public Pagamento savepagamento(PagamentoDto pagamentoDto){
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(pagamentoDto.getValor());
        pagamento.setDataPagamento(pagamentoDto.getDataPagamento());
        pagamento.setFormaPagamento(pagamentoDto.getFormaPagamento());
        return pagamentoRepository.save(pagamento);
    }

    //editar
    public PagamentoDto editPagamento(Long id, PagamentoDto pagamentoDto  ){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
        pagamento.setValor(pagamentoDto.getValor());
        pagamento.setDataPagamento(pagamentoDto.getDataPagamento());
        pagamento.setFormaPagamento(pagamentoDto.getFormaPagamento());
        Pagamento pagamentoEdited = pagamentoRepository.save(pagamento);
        return new PagamentoDto()
                .builder()
                .valor(pagamentoEdited.getValor())
                .dataPagamento(pagamentoEdited.getDataPagamento())
                .formaPagamento(pagamentoEdited.getFormaPagamento())
                .build();
    }

    //apagar
    public boolean deletePagamento(long id){
        try{
            Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
            pagamentoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Pagamento update (Pagamento pagamento){
        Pagamento salvo = pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        salvo.setValor(pagamento.getValor());
        salvo.setDataPagamento(pagamento.getDataPagamento());
        salvo.setFormaPagamento(pagamento.getFormaPagamento());
        return pagamentoRepository.save(salvo);
    }
}
