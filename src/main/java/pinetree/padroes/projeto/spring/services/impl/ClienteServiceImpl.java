package pinetree.padroes.projeto.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pinetree.padroes.projeto.spring.models.Cliente;
import pinetree.padroes.projeto.spring.models.Endereco;
import pinetree.padroes.projeto.spring.repositories.ClienteRepository;
import pinetree.padroes.projeto.spring.repositories.EnderecoRepository;
import pinetree.padroes.projeto.spring.services.ClienteService;
import pinetree.padroes.projeto.spring.services.ViaCepService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * *
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep().replaceAll("[^0-9]", "");
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);

        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clienteRepository.save(cliente);
    }
    @Override
    public List<Cliente> buscarTodos() {

        // Buscar todos os Clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {

        // Buscar Cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    @Override
    public void inserir(Cliente cliente) {
        // Salva os dados do cliente vinculando o Endereco (novo ou existente).
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(UUID id, Cliente cliente) {

        // Buscar Cliente por ID, caso exista:
         Optional<Cliente> clienteBd = clienteRepository.findById(id);
         if (clienteBd.isPresent()) {
             salvarClienteComCep(cliente);
         }
    }

    @Override
    public void deletar(UUID id) {

        // Deletar Cliente por ID.
        clienteRepository.deleteById(id);

    }
}
