package pinetree.padroes.projeto.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinetree.padroes.projeto.spring.models.Cliente;
import pinetree.padroes.projeto.spring.services.ClienteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * Interface interativa da API: http://localhost:8080/swagger-ui/index.html
 *
 */

@RestController
@RequestMapping("clientes")
@Tag(name="Clientes", description="API Rest String Boot Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary="OBTER TODOS", description="Retorna a lista de todos os clientes")
    public ResponseEntity<List<Cliente>> buscarTodos() {

        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary="OBTER UM", description="Retorna as informações do cliente informado")
    public ResponseEntity<Object> buscarPorId(@PathVariable UUID id) {

        Optional<Cliente> clienteOptional = clienteService.buscarPorId(id);
        return clienteOptional
                .<ResponseEntity<Object>>map(cliente -> ResponseEntity.status(HttpStatus.OK).body(cliente))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado."));
    }

    @PostMapping
    @Operation(summary="CRIAR", description="Cria o cliente")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary="ATUALIZAR", description="Atualiza as informações do cliente informado")
    public ResponseEntity<Cliente> atualizar(@PathVariable UUID id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="REMOVER", description="Exclui o cliente informado")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
