package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.ConsultaDto;
import br.edu.famper.clinicaodontologica.dto.DentistaDto;
import br.edu.famper.clinicaodontologica.dto.PacienteDto;
import br.edu.famper.clinicaodontologica.dto.PagamentoDto;
import br.edu.famper.clinicaodontologica.model.Consulta;
import br.edu.famper.clinicaodontologica.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaDto> getAllConsultas(){
        return consultaRepository
                .findAll()
                .stream()
                .map(consulta -> ConsultaDto
                        .builder()
                        .descricao(consulta.getDescricao())
                        .valor(consulta.getValor())
                        .data(consulta.getData())
                        .pagamento(PagamentoDto.builder()
                                .id(consulta.getPagamento().getId())
                                .valor(consulta.getPagamento().getValor())
                                .dataPagamento(consulta.getPagamento().getDataPagamento())
                                .formaPagamento(consulta.getPagamento().getFormaPagamento())
                                .build())
                        .paciente(PacienteDto.builder()
                                .id(consulta.getPaciente().getId())
                                .nome(consulta.getPaciente().getNome())
                                .cpf(consulta.getPaciente().getCpf())
                                .email(consulta.getPaciente().getEmail())
                                .endereco(consulta.getPaciente().getEndereco())
                        .build())
                        .dentista(DentistaDto.builder()
                                .id(consulta.getDentista().getId())
                                .nome(consulta.getDentista().getNome())
                                .cpf_cnpj(consulta.getDentista().getCpf_cnpj())
                                .endereco(consulta.getDentista().getEndereco())
                                .email(consulta.getDentista().getEmail())
                                .build())
                        .build())
                .toList();
    }

    //buscar uma consulta
    public ConsultaDto getConsultaById(long id){
        Consulta con = consultaRepository.findById(id).orElseThrow();
        return new ConsultaDto()
                .builder()
                .descricao(con.getDescricao())
                .valor(con.getValor())
                .data(con.getData())
                .dentista(DentistaDto.builder()
                        .id(con.getDentista().getId())
                        .nome(con.getDentista().getNome())
                        .cpf_cnpj(con.getDentista().getCpf_cnpj())
                        .endereco(con.getDentista().getEndereco())
                        .email(con.getDentista().getEmail())
                        .build())
                .paciente(PacienteDto.builder()
                        .id(con.getPaciente().getId())
                        .nome(con.getPaciente().getNome())
                        .cpf(con.getPaciente().getCpf())
                        .email(con.getPaciente().getEmail())
                        .endereco(con.getPaciente().getEndereco())
                        .build())
                .pagamento(PagamentoDto.builder()
                        .id(con.getPagamento().getId())
                        .valor(con.getPagamento().getValor())
                        .dataPagamento(con.getPagamento().getDataPagamento())
                        .formaPagamento(con.getPagamento().getFormaPagamento())
                        .build())
                .build ();
    }

    //inserir uma consulta
    public Consulta saveConsulta(ConsultaDto consultaDto){
        Consulta consulta = new Consulta();
        consulta.setDescricao(consultaDto.getDescricao());
        consulta.setValor(consultaDto.getValor());
        consulta.setData(consultaDto.getData());
        return consultaRepository.save(consulta);
    }

    //editar uma consulta
    public ConsultaDto editConsulta(Long id, ConsultaDto consultaDto  ){
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        consulta.setDescricao(consultaDto.getDescricao());
        consulta.setValor(consultaDto.getValor());
        consulta.setData(consultaDto.getData());
        Consulta consultaEdited = consultaRepository.save(consulta);
        return new ConsultaDto()
                .builder()
                .descricao(consultaEdited.getDescricao())
                .valor(consultaEdited.getValor())
                .data(consultaEdited.getData())
                .build();
    }

    //apagar uma consulta
    public boolean deleteConsulta(long id){
        try{
            Consulta consulta = consultaRepository.findById(id).orElseThrow();
            consultaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Consulta update (Consulta consulta){
        Consulta salvo = consultaRepository.findById(consulta.getId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        salvo.setDescricao(consulta.getDescricao());
        salvo.setValor(consulta.getValor());
        salvo.setData(consulta.getData());
        salvo.setDentista(consulta.getDentista());
        salvo.setPaciente(consulta.getPaciente());
        salvo.setPagamento(consulta.getPagamento());
        return consultaRepository.save(salvo);
    }
}
