package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Universidade {
    private static Universidade instancia;
    private String nomeUniversidade;
    private List<Aluno> listaAlunos;
    private List<Professor> listaProfessores;

    private Universidade(String nomeUniversidade) {
         this.nomeUniversidade = nomeUniversidade;
         this.listaAlunos = new ArrayList<>();
         this.listaProfessores = new ArrayList<>(); 
        }
        public static synchronized Universidade getInstance() {
             if (instancia == null) {
                 instancia = new Universidade("Universidade Federal");
                 }
                  return instancia;
                 }

         public String getNomeUniversidade() {
             return nomeUniversidade;
             }

        public void matricularAluno(Aluno alu) {
             listaAlunos.add(alu);
             }
              
        public void cadastrarProfessor(Professor pro) {
             listaProfessores.add(pro);
             } 

        public List<Aluno> getListaAlunos(){
            return Collections.unmodifiableList(listaAlunos);

        }
        public  List<Professor> getListaProfessores(){
            return Collections.unmodifiableList(listaProfessores);
        }
    }
