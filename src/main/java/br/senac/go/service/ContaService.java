package br.senac.go.service;

import br.senac.go.interfaces.IService;
import br.senac.go.model.Conta;
import br.senac.go.repository.ContaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.awt.event.ContainerEvent;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContaService implements IService<Conta,Integer> {

    @Autowired //injeção de dependência
    ContaRepository contaRepository;

    @Override
    public Conta create(Conta entity) {
        log.info("Método ContaService.create executado");
        log.debug(String.format("Método ContaService.create executado com o objeto: %s", entity.toString()));
        return contaRepository.save(entity);
    }

    @Override
    public Conta readById(Integer id) throws Exception {
        log.info("Método ContaService.readById executado");
        log.debug(String.format("Método ContaService.readById executado com o valor: %d", id));

        //Conta contaPesquisada = contaRepository.findById(id).orElseGet(Conta::new);
        Optional<Conta> contaPesquisada = contaRepository.findById(id);

        return contaPesquisada.orElseGet(Conta::new);
        /*
        if(contaPesquisada.isPresent()){
            return contaPesquisada.get();
        }
        else {
            return new Conta();
        }*/


    }

    @Override
    public Conta read(Conta entity) throws Exception {
        log.info("Método ContaService.read executado");
        log.debug(String.format("Método ContaService.read executado com o objeto: %s", entity.toString()));

        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<Conta> queryByExample = Example.of(entity,caseInsensitiveExampleMatcher);
        List<Conta> contas = contaRepository.findAll(queryByExample);

       return contaRepository.findOne(queryByExample).orElseGet(Conta::new);
    }

    @Override
    public Conta update(Conta entity) throws Exception {
        log.info("Método ContaService.update executado");
        log.debug(String.format("Método ContaService.update executado com o objeto: %s", entity.toString()));

        Conta contaExistente = this.read(entity);

        //}forma de atualizar os objetos
        //TODO
        contaExistente.setDataFim(entity.getDataFim()); //tratar get para objeto nulo
        contaExistente.setDataInicio(entity.getDataInicio());
        contaExistente.setDescricao(entity.getDescricao());

        contaRepository.save(contaExistente);
        return contaExistente;
    }

    @Override
    public Conta updatePart(Integer id, Conta entity) throws Exception {
        log.info("Método ContaService.updatePart executado");
        log.debug(String.format("Método ContaService.updatePart executado com o objeto: %d | %s", id, entity.toString()));

        contaRepository.save(entity);
        return null;
    }

    @Override
    public Conta updateFull(Integer id, Conta entity) {
        log.info("Método ContaService.updateFull executado");
        log.debug(String.format("Método ContaService.updateFull executado com o objeto: %d | %s", id, entity.toString()));

        return null;
    }

    @Override
    public Conta deleteById(Integer id) {
        log.info("Método ContaService.deleteById executado");
        log.debug(String.format("Método ContaService.deleteById executado com o valor: %d", id));
        return null;
    }

    @Override
    public Conta delete(Conta entity) {
        log.info("Método ContaService.delete executado");
        log.debug(String.format("Método ContaService.delete executado com o objeto: %s", entity.toString()));

        return null;
    }
}
