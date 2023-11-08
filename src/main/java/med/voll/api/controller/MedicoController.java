package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
  @Autowired
  private MedicoRepository repository;

  @PostMapping
//  transactional => transação de dados | fazendo uma escrita no banco de dados
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
    repository.save(new Medico(dados));
  }

  @GetMapping
//  @PageableDefault() para filtrar a listagem, nesse caso, tamanho = 10 e arrumar a lista de forma alfabética pelo nome
  public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
//  pegando todos os medicos e transformando eles em um DadosListagemMedico com o map
    return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
  }

  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid DadosAtualizarMedico dados){
    var medico = repository.getReferenceById(dados.id());
    medico.atualizarInformacoes(dados);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void excluir(@PathVariable Long id){
//    repository.deleteById(id); => deletar totalmente do banco de dados
    var medico = repository.getReferenceById(id);
    medico.excluir();
  }
}
