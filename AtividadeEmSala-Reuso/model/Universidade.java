package model;
import java.util.ArrayList;
import java.util.List;

public class Universidade{
    private String nomeUniversidade;

    private List<Aluno> ListaAlunos;
    private List<Professor> ListaProfessores;

    public Universidade(String nomeUniversidade){
        this.nomeUniversidade = nomeUniversidade;
        this.ListaAlunos = new ArrayList<>();
        this.ListaProfessores = new ArrayList<>();
    }
    public void matricularAluno(Aluno alu){
        ListaAlunos.add(alu);
    }

    public void CadastrarProfessor(Professor pro){
        ListaAlunos.add(pro);
    }

    public void exibirDetalhesUniversidade() {
        System.out.println("Universidade: " + this.nomeUniversidade);
        System.out.println("Alunos Matriculados");
        
        for (Aluno a : ListaAlunos) {
            
            System.out.println("Nome: " + a.getNome() + " | Matrícula: " + a.getMatricula());
        }
        for(Professor p: ListaProfessores){
            System.out.println("Nome: " + p.getNome());

        }
    }
}