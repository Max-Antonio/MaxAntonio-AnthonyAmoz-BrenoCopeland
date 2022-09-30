import java.util.ArrayList;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */



public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Personagem jogador;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        jogador = new Personagem();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room hallPrincipal, escritorio, jardim, piscina, banheiro, cozinha;
        Item Pato, Faca, Relogio, Luvas, Tesoura, Veneno, Espanador, Garrafa;
        NPC Adriel, Ferdinando, Marta, James, Leonard;

      
        // create the rooms

        hallPrincipal = new Room("no hall principal");
        escritorio = new Room("num escritorio");
        jardim = new Room("no jardim da mansao");
        piscina = new Room("na piscina");
        banheiro = new Room("no banheiro");
        cozinha = new Room("na cozinha");

        // cria os itens
        Pato = new Item("Carcaca de Pato", "Restos de um pato inteiro              assado, so sobraram os ossos e pedaços pequenos de cartilagem e            carne. Devia estar delicioso.");

        Faca = new Item("Faca de Cozinha", "Uma faca de cozinha afiada e           brilhante, parece ser muito bem cuidada, mas há uma irregularidade         em sua ponta. ");

        Relogio = new Item("Relogio", "Um relogio antiquado mas bem                bonito. Talvez pertença a algum dos convidados da festa ou ate             mesmo ao dono da mansão.");

        Luvas = new Item("Luvas", "Um par de luvas elegantes, provavelmente feitas para serem usadas por um mordomo. Nao e um lugar comum para encontrar algo assim.");

        Tesoura = new Item("Tesoura", "Uma tesoura simples de jardinaria, usada para podar árvores e arbustos, sempre está com o próprio");

        Veneno = new Item("Veneno", "Um frasco de veneno com tamanho razoável, que pode ser encontrado na cabana do jardim (ou qualquer outro lugar do tipo). Aparenta estar vazio, e a borda ainda está úmida.");

        Espanador = new Item("Espanador", "Um espanador simples para limpar poeira, aparenta estar bem limpo diferente dos móveis da casa.");

        Garrafa = new Item("Garrafa", "Uma garrafa pela metade, parece uma receita caseira já que a embalagem foi feita com adesivo e letra cursiva, a garrafa também é diferente.");

        

        // cria os npcs
      
      Adriel = new NPC("Adriel",  "Adriel:  Meu nome é Adriel, venho servindo ao dono desta mansão faz 30 anos. Portanto, a última pessoa que você deveria suspeitar seria de mim! \n Eu estava servindo os convidados a noite inteira! Meu patrão, como sempre, sobrecarregou a minha função, não tive tempo nem de respirar, imagine de matá-lo! Sei muito bem que ele não me tratava da melhor maneira, mas jamais faria uma atrocidade dessas. \n" , "Adriel: M - minhas luvas? Onde elas estavam? Não as vejo desde o início da festa, será que alguém as tomou de mim?\n", Luvas);
        
        Ferdinando = new NPC("Ferdinando", "Ferdinando: Opa, precisa do que? Deveria estar investigando a morte do chefe, não? Eu estava a noite toda na cozinha, fui proibido de ir para o hall durante o evento. Sim, eu vi o cozinheiro indo para a floresta, até ajudei ele a pegar o mel, ele sempre é gente fina comigo. \n", "Ferdinando: Ah, pera, alguém usou meu pote de veneno? Quando foi isso? Não acredito que alguém mexeu nas minhas coisas.\n", Veneno);

        Marta = new NPC("Marta", "Marta: Olá, não imaginei que viesse parar aqui. Eu sou a Marta, a faxineira da mansão. Esta piscina não é utilizada há anos, entretanto sempre fui ordenada a deixar ela impecável, acho que nessa família é mais sobre aparência do que utilidade, não é mesmo?. Estava no hall, quando os convidados chegaram estava com um pouco de calor então decidi que era melhor vir para aqui. A noite está bastante agradável, não? Eh, Digo pelo clima claro, não pelo ocorrido. \n", "Marta: Opa, vejo que achou meu espanador, se eu perco isso o James me mata, digo rs, me dá um carão ele sempre foi mais impaciente comigo diferente do patrão, Por quê estava no escritório? Ah, agora você me fez lembrar que eu tinha entrado no escritório para começar a limpar, mas o James chegou apressado com uma cara de quem queria privacidade, então o deixei lá.\n", Espanador);

        James = new NPC("James","James: Sou James King, amigo de longa data do dono dessa mansao e co-criador da empresa Sublime Comunications. Sou a ultima pessoa que deve suspeitar sobre o assassinato, estava no banheiro o tempo todo, acho que o frango que o chef fez faz mal ao meu estômago. Realmente uma perda terrivel tivemos hoje, a empresa não será a mesma sem ele para co-administrar comigo. \n", null, null);

        Leonard = new NPC("Leonard","Leonard: Me chamo Leonard, sou o chefe de cozinha, fui contratado ano passado para fazer o menu das festas extravagantes do senhor dono. Nao sei nada sobre o assassinato do senhor dono, certamente nao fui eu! Estava na minha cozinha o tempo todo preparando a comida para a festa. Fazer pato laqueado no mel de cacau com ervas e frutas demanda tempo, ter que usar ingredientes que eu mesmo colhi no dia está muito alem do meu salario! \n","Leonard: Voce achou minha faca de cozinha? bem que eu senti falta dela fazendo o pato hoje, afio ela todos os dias, ela pode cortar ate madeira. \n", Faca);
      

        // adciona os itens
        hallPrincipal.addItem(Relogio);
        hallPrincipal.addItem(Luvas);

        cozinha.addItem(Faca);
        cozinha.addItem(Pato);

        jardim.addItem(Tesoura);
        jardim.addItem(Veneno);

        piscina.addItem(Garrafa);

        escritorio.addItem(Espanador);

        // adciona os npcs
        hallPrincipal.addNPC(Adriel);

        cozinha.addNPC(Leonard);

        piscina.addNPC(Marta);

        banheiro.addNPC(James);

        jardim.addNPC(Ferdinando);

        
        // initialise room exits

        hallPrincipal.setExit("leste", piscina);
        hallPrincipal.setExit("oeste", jardim);
        hallPrincipal.setExit("norte", escritorio);
        hallPrincipal.setExit("sul", cozinha);
      
        piscina.setExit("oeste", hallPrincipal);

        jardim.setExit("leste", hallPrincipal);

        escritorio.setExit("sul", hallPrincipal);
        escritorio.setExit("oeste", banheiro);

        banheiro.setExit("leste", escritorio);

        cozinha.setExit("norte", hallPrincipal);

        currentRoom = hallPrincipal;  // começa o jogo no hall 
    }



    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar. Adeus!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bem vindo ao jogo de misterio!");
        System.out.println("Seu objetivo é encontrar o assassino");
        System.out.println("Escreva '" + CommandWord.HELP + "' se precisar de ajuda.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("não entendo o que quer dizer...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
                
            case ANALISAR:
                analisa(command);
                break;

            case PEGAR:
                pegaItem(command);
                break;

            case INVENTARIO:
                jogador.listaItens();
                break;

            case FALAR:
                falarCom(command);
              break;

          case ACUSAR:
                wantToQuit = acusa(command);
              break;
          
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {   
        System.out.println("~----------------------------------------------~\n");
        System.out.println("Voce esta numa mansao onde ocorreu um assassinato");
        System.out.println("procure pistas para achar o assassino.\n");
        System.out.println("Você pode: \nPegar itens em uma sala; \nFalar com as pessoas da sala; \nAnalisar a sala; \nVer os itens do seu inventário; \nAcusar alguem(eh preciso estar na mesma sala de quem quer acusar);");
        System.out.println();
        System.out.println("Seus comandos são:");
        parser.showCommands();
        System.out.println("~----------------------------------------------~\n");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir pra onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("nao tem porta nessa direcao!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void pegaItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Pegar o que?");
            return;
        }

        String nomeItem = command.getSecondWord();
        Item item = currentRoom.encontraItem(nomeItem);

      if(item != null) {
        currentRoom.removeItem(item);
        jogador.addItem(item);     
        System.out.println("Voce obteve o item " + nomeItem);
        System.out.println("\nDecricao: " + item.getDescricao());
        
      }
      else {
        System.out.println("Nao entendo o que quer dizer...");
      }



    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("sair do que?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void analisa(Command command) {
      if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Analisar o que? (sala/item)");
            return;
        }

      String SegundaPalavra = command.getSecondWord();
      
      if (SegundaPalavra.equals("item")) {
        System.out.println("Qual item?");
      }
      else if (SegundaPalavra.equals("sala")) {
        currentRoom.mostraElementos();
      }
      else{
        Item item = jogador.procuraItem(SegundaPalavra);
        if (item != null) {
          System.out.println("Descricao: " + item.getDescricao());
        }
        else {
           System.out.println("Nao entendo o que quer dizer...");
        }
      }
      
    }

    private void falarCom(Command command) {
      if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Falar com quem?");
            return;
        }

      String nome = command.getSecondWord();

      NPC npc = currentRoom.encontraNPC(nome);

      if(npc != null) {
        if (jogador.checaItem(npc.getItemChave())) {
          System.out.println(npc.getFalasChave());
        }
        else {
          System.out.println(npc.getFalas());
        }
      }
      else {
        System.out.println("Nao entendo o que quer dizer...");
      }
      
    }
  private boolean acusa(Command command) {
    if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("acusar quem?");
            return false;
        }
    String nome = command.getSecondWord();

    NPC npc = currentRoom.encontraNPC(nome);

    if (npc != null) {
      if (npc.getNome().equals("James")) {
        System.out.println("Parabens! voce conseguiu achar o assassino");
      }
      else {
        System.out.println("Voce acusou um inocente injustamente e o assassino nunca mais foi visto. Voce perdeu.");
      }
      return true;

    }
    else {
      System.out.println("Nao entendo o que quer dizer...");
      return false;
    }
  }
  
}
