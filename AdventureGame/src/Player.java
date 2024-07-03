import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String name;
    private String charType;
    private Inventory inventory;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Character[] characters = {new Samurai(), new Archer(), new Knight()};
        System.out.println("---------------------------------------------");
        for (Character character : characters) {
            System.out.println(character.getId() + ". Karakter: " + character.getName()
                    + " \t Hasar: " + character.getDamage()
                    + " \t Sağlık: " + character.getHealth()
                    + " \t Para: " + character.getMoney());
        }
        System.out.println("---------------------------------------------");
        System.out.println("Lütfen bir karakter seçiniz");
        int selectChar = scanner.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(characters[0]);
                break;
            case 2:
                initPlayer(characters[1]);
                break;
            case 3:
                initPlayer(characters[2]);
                break;
            default:
                initPlayer(characters[0]);
        }

        System.out.println(this.getCharType() + " seçtiniz.");
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void initPlayer(Character character) {
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setOriginalHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setCharType(character.getName());
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage;
    }

    public int getTotalDamage() {
        return damage + inventory.getWeapon().getDamage();
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0 ){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }


    public void printInfo() {

        System.out.println(
                " Silahınız : " + this.getInventory().getWeapon().getName() +
                        ", Zırh :" + this.getInventory().getArmor().getName() +
                        ", Koruma :" + this.getInventory().getArmor().getProtection() +
                        ", Hasarınız : " + this.getTotalDamage() +
                        ", Sağlığınız : " + this.getHealth() +
                        ", Para :" + this.getMoney()

        );
    }
}
