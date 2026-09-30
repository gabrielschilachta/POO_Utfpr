package model;
public class AtividadeEmSala1 {
    public static void main(String[] args){

        
        Aluno al1 = new Aluno("Gabriel", "1414141", "2587665");
        Professor pr1 = new Professor("Alisson", "11111111", 5000);


        
        

        
        Universidade uni = new Universidade("Universidade Federal");

        
       // uni.matricularAluno(aluno1);
        //uni.matricularAluno(aluno2);

        
        uni.exibirDetalhesUniversidade();
    }
}
    
    

