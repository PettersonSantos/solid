package br.com.petterson.rh.service.reajuste;

import br.com.petterson.rh.ValidacaoException;
import br.com.petterson.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste{
    public void validar(Funcionario funcionario, BigDecimal aumento){
        long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(funcionario.getDataUltimoReajuste(), LocalDate.now());
        if (mesesDesdeUltimoReajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser no minimo 6 meses");
        }
    }
}
