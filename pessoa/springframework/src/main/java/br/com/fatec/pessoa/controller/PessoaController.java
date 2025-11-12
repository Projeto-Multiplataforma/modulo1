package br.com.fatec.pessoa.controller;

import br.com.fatec.pessoa.controller.adapter.PessoaControllerAdapter;
import br.com.fatec.pessoa.controller.dto.request.PessoaRequest;
import br.com.fatec.pessoa.controller.dto.response.PessoaResponse;
import br.com.fatec.pessoa.entity.Pessoa;
import br.com.fatec.pessoa.repository.PessoaRepository;
import br.com.fatec.pessoa.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaRepository repository;
    private final PessoaService service;

    public PessoaController(
            PessoaRepository repository,
            PessoaService service
    ){
        this.repository = repository;
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public PessoaResponse save(@RequestBody PessoaRequest request){
        Pessoa pessoa = PessoaControllerAdapter.cast(request);
        return PessoaControllerAdapter.cast(service.save(pessoa));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find-id/{id}")
    public PessoaResponse findById(@PathVariable String id){
        return PessoaControllerAdapter.cast(repository.findByIDAndATIVOTrue(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<PessoaResponse> findAll(
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        Pageable pageable = PageRequest.of(10, pageNumber);
        return PessoaControllerAdapter.cast(repository.findByATIVOTrue(pageable));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PessoaResponse update(
            @PathVariable String id,
            @RequestBody PessoaRequest request
    ) {
        Pessoa pessoa = PessoaControllerAdapter.cast(request, id);
        return PessoaControllerAdapter.cast(service.save(pessoa));
    }

}
