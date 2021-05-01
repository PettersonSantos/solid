package br.com.petterson.rh.service.promocao;

import br.com.petterson.rh.ValidacaoException;
import br.com.petterson.rh.model.Cargo;
import br.com.petterson.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE  == cargoAtual){
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }
        if(!metaBatida){
            throw new ValidacaoException("Funcionario não bateu a meta");
        }
        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }
}
