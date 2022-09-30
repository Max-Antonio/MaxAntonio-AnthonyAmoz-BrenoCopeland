import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoomTest {
  @Test
  public void testEncontraItem() {
    Room quarto;
    Item cama;
    quarto = new Room("no quarto");
    cama = new Item("cama", "bem confortavel");

    quarto.addItem(cama);

    assertEquals(cama, quarto.encontraItem("cama"));

  }

  @Test
  public void testEncontraNPC() {
    Room sala;
    NPC marcelo;
    sala = new Room("na sala");
    marcelo = new NPC("marcelo", "", "", null);

    sala.addNPC(marcelo);

    assertEquals(marcelo, sala.encontraNPC("marcelo"));

  }
}
