public class Inventory {
    private  Weapon weapon;
    private Armor armor;

    private String food = "";

    private String water = "";

    private String wood = "";

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWood() {
        return wood;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public Inventory() {
        this.weapon = new Weapon("Yumruk", 0,0,0);
        this.armor = new Armor("Kıyafet",0,0,0);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
