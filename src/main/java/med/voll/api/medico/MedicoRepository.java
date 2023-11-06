package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

//entidade e o tipo do ID da entidade
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
