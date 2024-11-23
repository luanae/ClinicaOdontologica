package br.edu.famper.clinicaodontologica.service;

import br.edu.famper.clinicaodontologica.dto.PacienteDto;
import br.edu.famper.clinicaodontologica.model.Paciente;
import br.edu.famper.clinicaodontologica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PacienteService {

        @Autowired
        private PacienteRepository pacienteRepository;

        public List<PacienteDto> getAllPacientes(){
            return pacienteRepository
                    .findAll()
                    .stream()
                    .map(paciente -> PacienteDto
                            .builder()
                            .nome(paciente.getNome())
                            .cpf(paciente.getCpf())
                            .email(paciente.getEmail())
                            .telefone(paciente.getTelefone())
                            .endereco(paciente.getEndereco())
                            .build()
                    )
                    .toList();
        }

        //buscar
        public PacienteDto getPacienteById(long id){
            Paciente pac = pacienteRepository.findById(id).orElseThrow();
            return new PacienteDto()
                    .builder()
                    .nome(pac.getNome())
                    .cpf(pac.getCpf())
                    .email(pac.getEmail())
                    .telefone(pac.getTelefone())
                    .endereco(pac.getEndereco())
                    .build();
        }

        //inserir
        public Paciente savePaciente(PacienteDto pacienteDto){
            Paciente paciente = new Paciente();
            paciente.setNome(pacienteDto.getNome());
            paciente.setCpf(pacienteDto.getCpf());
            paciente.setEmail(pacienteDto.getEmail());
            paciente.setTelefone(pacienteDto.getTelefone());
            paciente.setEndereco(pacienteDto.getEndereco());
            return pacienteRepository.save(paciente);
        }

        //editar
        public PacienteDto editPaciente(Long id, PacienteDto pacienteDto  ){
            Paciente paciente = pacienteRepository.findById(id).orElseThrow();
            paciente.setNome(pacienteDto.getNome());
            paciente.setCpf(pacienteDto.getCpf());
            paciente.setEmail(pacienteDto.getEmail());
            paciente.setTelefone(pacienteDto.getTelefone());
            paciente.setEndereco(pacienteDto.getEndereco());
            Paciente pacienteEdited = pacienteRepository.save(paciente);
            return new PacienteDto()
                    .builder()
                    .nome(pacienteEdited.getNome())
                    .cpf(pacienteEdited.getCpf())
                    .email(pacienteEdited.getEmail())
                    .telefone(pacienteEdited.getTelefone())
                    .endereco(pacienteEdited.getEndereco())
                    .build();
        }

        //apagar
        public boolean deletePaciente(long id){
            try{
                Paciente paciente = pacienteRepository.findById(id).orElseThrow();
                pacienteRepository.deleteById(id);
                return true;
            } catch (Exception e){
                return false;
            }
        }

        public Paciente update (Paciente paciente){
            Paciente salvo = pacienteRepository.findById(paciente.getId())
                    .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
            salvo.setNome(paciente.getNome());
            salvo.setCpf(paciente.getCpf());
            salvo.setEmail(paciente.getEmail());
            salvo.setTelefone(paciente.getTelefone());
            salvo.setEndereco(paciente.getEndereco());
            return pacienteRepository.save(salvo);
        }
    }