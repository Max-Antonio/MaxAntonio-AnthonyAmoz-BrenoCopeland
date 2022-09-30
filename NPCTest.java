import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NPCTest {
  @Test
  public void testGetFalas() {
    NPC carlos;
    Item faca;
    faca = new Item("faca", "faca");
    carlos = new NPC("Carlos", "Eu sou Carlos", "Carlos sou eu", faca);

    assertEquals("Eu sou Carlos", carlos.getFalas());

  }

  @Test
  public void testGetFalasChave() {
    NPC carlos;
    Item faca;
    faca = new Item("faca", "faca");
    carlos = new NPC("Carlos", "Eu sou Carlos", "Carlos sou eu", faca);

    assertEquals("Carlos sou eu", carlos.getFalasChave());
  }

  @Test
  public void testGetItemChave() {
    NPC carlos;
    Item faca;
    faca = new Item("faca", "faca");
    carlos = new NPC("Carlos", "Eu sou Carlos", "Carlos sou eu", faca);

    assertEquals(faca, carlos.getItemChave());
  }

  @Test
  public void testGetNome() {
    NPC carlos;
    Item faca;
    faca = new Item("faca", "faca");
    carlos = new NPC("Carlos", "Eu sou Carlos", "Carlos sou eu", faca);

    assertEquals("Carlos", carlos.getNome());

  }
}
