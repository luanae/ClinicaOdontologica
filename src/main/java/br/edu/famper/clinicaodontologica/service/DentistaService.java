package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.DentistaDto;
import br.edu.famper.clinicaodontologica.model.Dentista;
import br.edu.famper.clinicaodontologica.repository.DentistaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    public List<DentistaDto> getAllDentistas(){
        return dentistaRepository
                .findAll()
                .stream()
                .map(dentista -> DentistaDto
                        .builder()
                        .nome(dentista.getNome())
                        .cpf_cnpj(dentista.getCpf_cnpj())
                        .email(dentista.getEmail())
                        .telefone(dentista.getTelefone())
                        .endereco(dentista.getEndereco())
                        .build()
                )
                .toList();

    }

    //buscar uma consulta
    public DentistaDto getDentistaById(long id){
        Dentista den = dentistaRepository.findById(id).orElseThrow();
        return new DentistaDto()
                .builder()
                .nome(den.getNome())
                .cpf_cnpj(den.getCpf_cnpj())
                .email(den.getEmail())
                .telefone(den.getTelefone())
                .endereco(den.getEndereco())
                .build();

    }

    //inserir uma consulta
    public Dentista saveDentista(DentistaDto dentistaDto){
        Dentista dentista = new Dentista();
        dentista.setNome(dentistaDto.getNome());
        dentista.setCpf_cnpj(dentistaDto.getCpf_cnpj());
        dentista.setEmail(dentistaDto.getEmail());
        dentista.setTelefone(dentistaDto.getTelefone());
        dentista.setEndereco(dentistaDto.getEndereco());
        return dentistaRepository.save(dentista);
    }

    //editar uma consulta
    public DentistaDto editDentista(Long id, DentistaDto dentistaDto  ){
        Dentista dentista = dentistaRepository.findById(id).orElseThrow();
        dentista.setNome(dentistaDto.getNome());
        dentista.setCpf_cnpj(dentistaDto.getCpf_cnpj());
        dentista.setEmail(dentistaDto.getEmail());
        dentista.setTelefone(dentistaDto.getTelefone());
        dentista.setEndereco(dentistaDto.getEndereco());
        Dentista dentistaEdited = dentistaRepository.save(dentista);
        return new DentistaDto()
                .builder()
                .nome(dentistaEdited.getNome())
                .cpf_cnpj(dentistaEdited.getCpf_cnpj())
                .email(dentistaEdited.getEmail())
                .telefone(dentistaEdited.getTelefone())
                .endereco(dentistaEdited.getEndereco())
                .build();
    }

    //apagar uma consulta
    public boolean deleteDentista(long id){
        try{
            Dentista dentista = dentistaRepository.findById(id).orElseThrow();
            dentistaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Dentista update (Dentista dentista){
        Dentista salvo = dentistaRepository.findById(dentista.getId())
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));
        salvo.setNome(dentista.getNome());
        salvo.setCpf_cnpj(dentista.getCpf_cnpj());
        salvo.setEmail(dentista.getEmail());
        salvo.setTelefone(dentista.getTelefone());
        salvo.setEndereco(dentista.getEndereco());
        return dentistaRepository.save(salvo);
    }
}
