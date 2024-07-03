public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz !");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Canınız Yenilendi !");

        return true;
    }
}
