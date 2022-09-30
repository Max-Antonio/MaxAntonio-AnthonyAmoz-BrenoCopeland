import java.util.ArrayList;

public class Personagem {
    private ArrayList<Item> inventario;

    public Personagem() {
      inventario = new ArrayList<>();
    }


    public void addItem(Item item) {
        inventario.add(item);
    }

    public void listaItens() {
        System.out.println("Inventario: ");
        if (inventario.size() == 0) {
          System.out.println("Inventario vazio.");
        }
        else {
          for (Item item : inventario) {
            System.out.println("- " + item.getNome());
          }
        }

    }
    

    public void escreveDescricao(String nome) {
        for (Item item : inventario) {
            if (item.getNome() == nome) {
                System.out.println(item.getDescricao());
                break;
              }
        }
        System.out.println("Esse item não está em seu inventario...");
        }
  

    public boolean checaItem(Item itemp) {  
        boolean c = false;
        for (Item item : inventario) {
            if (item == itemp) {
                c = true;}
        }
      return c;
    }

    public Item procuraItem(String nome) {
          for (Item item : inventario) {
            if (item.getNome().equals(nome)) {
              return item;
            }
          }
      return null;
    }





}