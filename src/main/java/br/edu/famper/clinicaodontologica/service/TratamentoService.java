package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.TratamentoDto;
import br.edu.famper.clinicaodontologica.model.Tratamento;
import br.edu.famper.clinicaodontologica.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TratamentoService {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    public List<TratamentoDto> getAllTratamentos(){
        return tratamentoRepository
                .findAll()
                .stream()
                .map(tratamento -> TratamentoDto
                        .builder()
                        .descricao(tratamento.getDescricao())
                        .dataInicio(tratamento.getDataInicio())
                        .dataFim(tratamento.getDataFim())
                        .build()
                )
                .toList();
    }

    //buscar
    public TratamentoDto getTratamentoById(long id){
        Tratamento tra = tratamentoRepository.findById(id).orElseThrow();
        return new TratamentoDto()
                .builder()
                .descricao(tra.getDescricao())
                .dataInicio(tra.getDataInicio())
                .dataFim(tra.getDataFim())
                .build();

    }

    //inserir
    public Tratamento saveTratamento(TratamentoDto tratamentoDto){
        Tratamento tratamento = new Tratamento();
        tratamento.setDescricao(tratamentoDto.getDescricao());
        tratamento.setDataInicio(tratamentoDto.getDataInicio());
        tratamento.setDataFim(tratamentoDto.getDataFim());
        return tratamentoRepository.save(tratamento);
    }

    //editar
    public TratamentoDto editTratamento(Long id, TratamentoDto tratamentoDto  ){
        Tratamento tratamento = tratamentoRepository.findById(id).orElseThrow();
        tratamento.setDescricao(tratamentoDto.getDescricao());
        tratamento.setDataInicio(tratamentoDto.getDataInicio());
        tratamento.setDataFim(tratamentoDto.getDataFim());
        Tratamento tratamentoEdited = tratamentoRepository.save(tratamento);
        return new TratamentoDto()
                .builder()
                .descricao(tratamentoEdited.getDescricao())
                .dataInicio(tratamentoEdited.getDataInicio())
                .dataFim(tratamentoEdited.getDataFim())
                .build();
    }

    //apagar
    public boolean deleteTratamento(long id){
        try{
            Tratamento tratamento = tratamentoRepository.findById(id).orElseThrow();
            tratamentoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Tratamento update (Tratamento tratamento){
        Tratamento salvo = tratamentoRepository.findById(tratamento.getId())
                .orElseThrow(() -> new RuntimeException("Tratamento não encontrado"));
        salvo.setDescricao(tratamento.getDescricao());
        salvo.setDataInicio(tratamento.getDataInicio());
        salvo.setDataFim(tratamento.getDataFim());
        return tratamentoRepository.save(salvo);
    }
}

