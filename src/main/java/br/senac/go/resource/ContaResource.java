package br.senac.go.resource;

import br.senac.go.interfaces.IResource;

import br.senac.go.model.Conta;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //fazer log das requisições
@RestController("api/conta")
//@Tag(name = "conta", description = "documentação ao resource conta")
@Tags({
        @Tag(name = "conta", description = "documentação ao resource conta"),
        @Tag(name = "investimento", description = "documentação para conta de investimento")
})
public class ContaResource implements IResource<Conta,Integer> {
    @Override
    public Conta create(Conta entity) {
        log.info("Executado método ContaResource.create");
        //log.debug("Executado método ContaResource.create com os seguinte valores:"+entity);
        log.debug(String.format("Executado método ContaResource.create | valores: %s",entity.toString()));
        return null;
    }

    @Override
    public Conta read(Conta entity) {
        log.info("Executado método ContaResource.read");
        //log.debug("Executado método ContaResource.create com os seguinte valores:"+entity);
        log.debug(String.format("Executado método ContaResource.read | valores: %s",entity.toString()));
        return null;
    }

    @Override
    public Conta readById(Integer id) {
        return null;
    }

    @Override
    public Conta update(Conta entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteByEntity(Conta entity) {

    }
}
