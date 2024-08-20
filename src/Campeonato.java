
import java.util.Random;

public class Campeonato {
    public Clube clubes[];
    
    public Campeonato(Clube clubes[]) {
        this.clubes = clubes;
    }

    public void jogarCampeonato(){
        for (Clube clube1 : clubes) {
            for (Clube clube2 : clubes){
                if (!clube2.equals(clube1)){
                    this.jogarPartida(clube1, clube2);
                }
            }
        }

        this.getClassificacao();
        this.getCampeao();
    }

    private void jogarPartida(Clube m, Clube v){
        Random gerador = new Random();

        int gols_m = Math.abs(gerador.nextInt() % 6);
        int gols_v = Math.abs(gerador.nextInt() % 6);
        int saldoGols = Math.abs(gols_m-gols_v);
        if (gols_m > gols_v) {
            m.ganhar(saldoGols);
            v.perder(saldoGols);
        } else if (gols_m < gols_v) {
            m.perder(saldoGols);
            v.ganhar(saldoGols);
        } else {
            m.empatar();
            v.empatar();
        }

        System.out.println(m.nome + " x " +  v.nome+ "\n( " + gols_m + "\t x \t" + gols_v + " )\n");
    }

    private void ordenaVetor(Clube[] vetor){
        Clube temp;
        for (int i=0; i<vetor.length; i++){
            for (int j=i+1; j<vetor.length; j++){
                if ((vetor[i].pontos < vetor[j].pontos) || ((vetor[i].pontos == vetor[j].pontos) && vetor[i]. saldoGols < vetor[j].saldoGols)){
                    temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                } 
            }
        }
    }

    public String getClassificacao(){
        Clube ordClubes[] = this.clubes.clone(); 
        ordenaVetor(ordClubes);

        String classificacao = "";
        for (Clube clube : ordClubes){
            classificacao = classificacao.concat(clube.pontos + " \t" + clube.nome + "\n");
        }
        
        return classificacao;
    }

    public String getCampeao(){
        Clube ordClubes[] = this.clubes.clone(); 
        ordenaVetor(ordClubes);

        return ordClubes[0].nome;
    }
}
