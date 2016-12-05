
import java.util.*;
import java.util.Random;

public class Item implements Comparable <Item> {

  private int itemId;
  private int itemValue;
  private String itemName;
  private String description;
  private static Random rand = new Random();

  public Item(int price, int id, String itemName, String description) {
    
    if (itemName == null || description == null || price < 0)
      throw new IllegalArgumentException();
    this.description = description;
    this.itemName = itemName;
    this.itemValue = price;
    this.itemId = id;

  }
  
  public Item(int id, String itemName, String description) {
    this( rand.nextInt(250*(id+1)), id, itemName, description );
  }

  public String getDescription() {
    return description;
  }

  public int getID() {
    return itemId;
  }

  public int getItemValue() {
    return itemValue;
  }

  public String getName() {
    return itemName;
  }

  @Override public int compareTo(Item other) {
    return itemName.compareTo(other.getName());
  }

  @Override public String toString() {
    return getName();
  }

}