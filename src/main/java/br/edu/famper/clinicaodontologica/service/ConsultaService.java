package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.ConsultaDto;
import br.edu.famper.clinicaodontologica.model.Consulta;
import br.edu.famper.clinicaodontologica.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<ConsultaDto> getAllConsultas(){
        return consultaRepository
                .findAll()
                .stream()
                .map(consulta -> ConsultaDto
                        .builder()
                        .descricao(consulta.getDescricao())
                        .valor(consulta.getValor())
                        .data(consulta.getData())
                        .build())
                .toList();
        //finalizar

    }
}

/*
    public List<Funcionario> findAll(){
        return funcionarioReposity.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarioReposity.findById(id);
    }

    public Funcionario update(Funcionario funcionario) {
        Funcionario salvo = funcionarioReposity.findById(funcionario.getCodigo())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado!!"));
        salvo.setNome(funcionario.getNome());
        salvo.setCargo(funcionario.getCargo());
        salvo.setDepartamento(funcionario.getDepartamento());
        salvo.setDataAdmissao(funcionario.getDataAdmissao());
        salvo.setEmail(funcionario.getEmail());
        salvo.setTelefone(funcionario.getTelefone());
        return funcionarioReposity.save(salvo);
    }

    public void deleteById(Long id) {
        funcionarioReposity.deleteById(id);
    }
}
