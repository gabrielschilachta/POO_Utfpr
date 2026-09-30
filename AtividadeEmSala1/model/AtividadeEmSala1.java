package model;
public class AtividadeEmSala1 {
    public static void main(String[] args){

        
        Aluno aluno1 = new Aluno("Lucas Silva", "2026101");
        Aluno aluno2 = new Aluno("Beatriz Souza", "2026102");
        
        

        
        Universidade uni = new Universidade("Universidade Federal");

        
        uni.matricularAluno(aluno1);
        uni.matricularAluno(aluno2);

        
        uni.exibirDetalhesUniversidade();
    }
}
    
    

