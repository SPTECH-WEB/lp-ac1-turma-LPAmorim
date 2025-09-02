package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade){
        this.nome = nome;
        this.mensalidade = mensalidade;
        this.qtdAluno = 0;
        this.ativa = true;
    }

    public void matricular(Integer qtd){
        if (qtd != null && qtd > 0 && ativa){
            qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd){
        if (qtd != null && qtd > 0 && qtd <= qtdAluno && ativa){
            qtdAluno -= qtd;
            return qtd;
        }else return null;
    }

    public Integer desativar(){
        if (ativa){
            ativa = false;
            int qtdTurmaDesativada = qtdAluno;
            qtdAluno = 0;
            return qtdTurmaDesativada;

        }else return null;
    }

    public void transferir(Turma destino, Integer qtdATransferir){
        if (destino != null
                && destino.ativa
                && qtdATransferir != null
                && qtdATransferir > 0
                && qtdAluno >= qtdATransferir
                && ativa
        ){
            qtdAluno -= qtdATransferir;
            destino.qtdAluno += qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste){
        if (reajuste != null && reajuste > 0){
            mensalidade *= (1 + reajuste);
            return true;

        }else return false;
    }

    // getters
    public String getNome(){
        return nome;
    }

    public Double getMensalidade(){
        return mensalidade;
    }

    public Integer getQtdAluno(){
        return qtdAluno;
    }

    public Boolean getAtiva(){
        return ativa;
    }

    // setters
    public void setNome(String nome){
        this.nome = nome;
    }

}
