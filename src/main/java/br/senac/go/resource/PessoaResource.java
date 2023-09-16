package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Pessoa;

public class PessoaResource implements IResource<Pessoa, Integer> {
    @Override
    public Pessoa create(Pessoa entity) {
        return null;
    }

    @Override
    public Pessoa read(Pessoa entity) {
        return null;
    }

    @Override
    public Pessoa readById(Integer id) {
        return null;
    }

    @Override
    public Pessoa update(Pessoa entity) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteByEntity(Pessoa entity) {

    }
}
