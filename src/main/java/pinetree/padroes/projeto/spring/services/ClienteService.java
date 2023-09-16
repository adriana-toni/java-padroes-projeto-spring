package pinetree.padroes.projeto.spring.services;


import pinetree.padroes.projeto.spring.models.Cliente;

import java.util.List;
import java.util.UUID;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 */
public interface ClienteService {

    List<Cliente> buscarTodos();

    Cliente buscarPorId(UUID id);

    void inserir(Cliente cliente);

    void atualizar(UUID id, Cliente cliente);

    void deletar(UUID id);

}
