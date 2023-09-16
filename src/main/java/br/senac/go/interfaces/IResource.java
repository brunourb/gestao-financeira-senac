package br.senac.go.interfaces;

public interface IResource<T,N> extends GenericOperations<T,N> {

    void deleteByEntity(T entity);
}
