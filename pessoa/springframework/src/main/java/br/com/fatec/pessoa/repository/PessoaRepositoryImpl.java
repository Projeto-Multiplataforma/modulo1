package br.com.fatec.pessoa.repository;

import br.com.fatec.pessoa.exception.BadRequestException;
import br.com.fatec.pessoa.exception.InternalServerException;
import br.com.fatec.pessoa.entity.Pessoa;
import br.com.fatec.pessoa.repository.client.PessoaRepositoryWithMongo;
import br.com.fatec.pessoa.repository.orm.PessoaOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository{
    private static final Logger LOG = LoggerFactory.getLogger(PessoaRepositoryImpl.class);

    private final PessoaRepositoryWithMongo repository;

    public PessoaRepositoryImpl(PessoaRepositoryWithMongo repository){
        this.repository = repository;
    }

    public Pessoa save(Pessoa pessoa){
        try{
            PessoaOrm orm = PessoaRepositoryAdapter.cast(pessoa);
            return PessoaRepositoryAdapter.cast(repository.save(orm));
        } catch (Exception ex) {
            LOG.error("Erro ao salvar pessoa: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    public Page<Pessoa> findByATIVOTrue(Pageable pageable){
        try{
            return PessoaRepositoryAdapter.cast(repository.findByATIVOTrue(pageable));
        } catch (Exception ex) {
            LOG.error("Erro ao procurar pessoa com ativo true: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    public Pessoa findByIDAndATIVOTrue(String id){
        try{
            Optional<PessoaOrm> optional = repository.findByIDAndATIVOTrue(id);
            if(optional.isEmpty()){
                throw new BadRequestException("Pessoa não encontrada");
            }
            return PessoaRepositoryAdapter.cast(optional.get());
        } 
        catch(BadRequestException ex){
            LOG.error("Pessoa não encontrada {}, {}",
                    ex.getMessage(), LocalDateTime.now());
            throw ex;
        } catch (Exception ex){
            LOG.error("Erro ao procurar pessoa por id: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }

    public void delete(String id){
        try{
            Pessoa pessoa = findByIDAndATIVOTrue(id);
            repository.save(new PessoaOrm(
                    pessoa.id(),
                    pessoa.nome(),
                    pessoa.dataNascimento(),
                    false
            ));
        } catch(BadRequestException ex){
            LOG.error("Pessoa não encontrada {}, {}",
                    ex.getMessage(), LocalDateTime.now());
            throw ex;
        } catch (Exception ex){
            LOG.error("Erro ao deletar pessoa: {} o erro aconteceu na data/hora: {}",
                    ex.getMessage(), LocalDateTime.now());
            throw new InternalServerException(ex);
        }
    }
}
