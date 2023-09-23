package br.senac.go.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data //faz os métodos get,set,tostring, hascode, equals
@Entity //fala para o ORM gerenciar o estado deste item no banco de dados
@Table(name = "PESSOA") //'nomea' a tabela do banco de dados
public class Pessoa {

    @Id //fala que este item é chave primária
    @GeneratedValue(strategy= GenerationType.AUTO) //auto-incremental
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NOME", length = 120, nullable = false) //nomea o nome da coluna para MAIÚSCULO
    private String nome;

    @Column(name = "ENDERECO") //nomea o nome da coluna para MAIÚSCULO
    private String endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    private Carteira carteira;
}
