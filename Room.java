import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

 import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<NPC> npcs;
    private ArrayList<Item> itens;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        npcs = new ArrayList<>();
        itens = new ArrayList<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Voce esta " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Saidas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    public void removeItem(Item item) {
        try {
            itens.remove(item);}
        catch(Exception e) {
            System.out.print("O item que voce procura nao esta no quarto.");
        }
        
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public void removeNPC(NPC npc) {
        try {
            npcs.remove(npc);}
        catch(Exception e) {
            System.out.print("A pessoa que procura não está no quarto");
        }
    }

    public void mostraElementos() {
        if (itens.size() > 0) {
            System.out.println("-itens na sala:");
            for (Item i : itens) {
                System.out.println(i.getNome());
            }
        }
        else {
            System.out.println("Nenhum item na sala...");
        }

        if (npcs.size() > 0) {
            System.out.println("\n-Pessoas na sala: ");
            for (NPC n : npcs) {
                System.out.println(n.getNome());
            }

        }
        else {
            System.out.println("Ninguem na sala...");
        }

        }

  public Item encontraItem(String nome) {
    for (Item i : itens) {
      if(i.getNome().equals(nome)) {
        return i;
      }
    }
    return null;
  }

  public NPC encontraNPC(String nome) {
    for (NPC n : npcs) {
      if(n.getNome().equals(nome)) {
        return n;
      }
    }
    return null;
  }
        


    }


