public class Armor {
    private String name;
    private int id;
    private int protection;
    private int price;

    public Armor(String name, int id, int protection, int price) {
        this.name = name;
        this.id = id;
        this.protection = protection;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armors = new Armor[3];
        armors[0] = new Armor("Hafif Zırh", 1,1,15);
        armors[1] = new Armor("Orta Zırh", 2,3,25);
        armors[2] = new Armor("Ağır Zırh", 3,5,40);
        return armors;
    }

    public static Armor getArmorById(int id){
        for(Armor armor : Armor.armors()){
            if(armor.getId() == id){
                return armor;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
