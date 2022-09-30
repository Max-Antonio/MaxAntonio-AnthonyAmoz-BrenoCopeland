import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
  @Test
  public void testGetDescricao() {
 Item faca;
    faca = new Item("faca", "afiada");
assertEquals("afiada", faca.getDescricao()); 
}

  @Test
  public void testGetNome() {
  Item faca;
  faca = new Item("faca", "afiada");
  assertEquals("faca", faca.getNome()); 
}

}
