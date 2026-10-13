package factory;

import Model.Aluno;
import Model.DadosInvalidosException;
import Model.Pessoa;
import Model.Professor;

public class PessoaFactory {
    public enum TipoPessoa {
        ALUNO, PROFESSOR
    }

    public static Pessoa criarPessoa(TipoPessoa tipo, String nome, String cpf, String campoEspecifico)
            throws DadosInvalidosException {
        if (tipo == TipoPessoa.ALUNO) {
            return new Aluno(nome, cpf, campoEspecifico);
        } else if (tipo == TipoPessoa.PROFESSOR) {
            float salario;
            try {
                salario = Float.parseFloat(campoEspecifico.replace(",", "."));
            } catch (NumberFormatException e) {
                throw new DadosInvalidosException("O salário deve ser um valor numérico válido!");
            }
            return new Professor(nome, cpf, salario);
        } else {
            throw new DadosInvalidosException("Tipo de pessoa não suportado.");
        }
    }
}