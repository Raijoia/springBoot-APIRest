package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaMesmoHorario {
  private ConsultaRepository repository;
  public void validar(DadosAgendamentoConsulta dados) {
    var medicoPossuiOutraConsultaMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
    if(medicoPossuiOutraConsultaMesmoHorario) {
      throw new ValidacaoException("Médico ja possui outra consulta agendada nesse mesmo horário");
    }
  }
}
