import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsCount = this.randomObstacleCount();
        System.out.println("Şu an buradasınız :" + this.getName());
        System.out.println("Dikkatli ol burada " + obsCount + " tane " + this.getObstacle().getName() + " yaşıyor");
        System.out.println("<S>avaş veye <K>aç");
        String selectCase = scanner.nextLine().toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsCount)) {
                return true;
            }
        }
        return this.getPlayer().getHealth() > 0;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = scanner.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    Random r = new Random();
                    int whoFirst = r.nextInt(2);
                    if (whoFirst == 1) {
                        System.out.println("Siz vurdunuz ");
                        obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        System.out.println();
                        System.out.println("Canavar size vurdu");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getProtection();
                        if (obstacleDamage > 0) {
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        }
                        afterHit();
                    } else {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getProtection();
                            if (obstacleDamage > 0) {
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            }
                            afterHit();
                            System.out.println("Siz vurdunuz ");
                            obstacle.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                    if (this.getObstacle().getHealth() == 0) {
                        System.out.println(i + ". " + this.getObstacle().getName() + " öldü..");
                    }
                } else {
                    return false;
                }
            }
        }

        if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
            System.out.println(this.getName() + " etabını geçtiniz .");
            System.out.println(this.getObstacle().getAward() + " altın kazandınız");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            return true;
        } else {
            return false;
        }
    }

    private void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık :" + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar :" + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getProtection());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("----------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasarı : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward() + " Altın");
        System.out.println();
    }

    public int randomObstacleCount() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
