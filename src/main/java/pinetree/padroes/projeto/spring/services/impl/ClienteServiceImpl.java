package pinetree.padroes.projeto.spring.services.impl;

import org.springframework.stereotype.Service;
import pinetree.padroes.projeto.spring.models.Cliente;
import pinetree.padroes.projeto.spring.services.ClienteService;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Override
    public List<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(UUID id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(UUID id, Cliente cliente) {

    }

    @Override
    public void deletar(UUID id) {

    }
}
