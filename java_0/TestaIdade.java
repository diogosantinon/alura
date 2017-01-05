class TestaIdade {

    public static void main(String[] args) {
        // imprime a idade
        int idade = 20;
        System.out.println(idade);

        boolean amigoDoDono = true;
        if (idade < 18 && !amigoDoDono) {
            System.out.println("Não pode entrar");
        }
        else {
            System.out.println("Pode entrar");
        }

        // gera uma idade no ano seguinte
        int idadeNoAnoQueVem;
        idadeNoAnoQueVem = idade + 1;

        // imprime a idade
        System.out.println(idadeNoAnoQueVem);
/*
        for (int i = 0; i < 10; i = i + 1) {
          System.out.println("olá!");
        }

        int i = 0;
        while (i < 10) {
            System.out.println("olá!");
            i = i + 1;
        }
*/

        for (int i = 0; i < 100; i++) {
            if (i > 50 && i < 60) {
                continue;
            }
            System.out.println(i);
        }        
    }

    
}