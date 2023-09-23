package br.senac.go.interfaces;

public interface GenericOperations<T,N> {

    /**
     * Quando a pessoa for criar um recurso, a aplicação
     * recebe uma entidade(T) e retorna a entidade (T) com o campo
     * id preenchido
     * @param entity
     * @return
     */
    T create(T entity);
    T read(T entity);
    T readById(N id);

    T update(T entity);
    T updatePart(N id, T entity);
    T updateFull(N id, T entity);
    void delete(N id);
}
