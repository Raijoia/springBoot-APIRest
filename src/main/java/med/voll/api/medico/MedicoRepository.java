package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//entidade e o tipo do ID da entidade
public interface MedicoRepository extends JpaRepository<Medico, Long> {
  Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
