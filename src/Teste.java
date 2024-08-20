public class Teste {
    public static void main(String[] args) throws Exception {
        Clube clube1 = new Clube("Flamengo");
        Clube clube2 = new Clube("Santos");
        Clube clube3 = new Clube("Fluminense");
        Clube clube4 = new Clube("Bahia");

        Clube clubes[] = new Clube[]{clube1, clube2, clube3, clube4};

        Campeonato campeonato = new Campeonato(clubes);

        campeonato.jogarCampeonato();
        System.out.println("Classificação Final:\n\n" + campeonato.getClassificacao());
        System.out.println("Parabéns, " + campeonato.getCampeao() + "! Campeão da Copa Teste de Futebol 2024!!!");
    }
}
