public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------------Mağazaya Hoşgeldiniz !--------------");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış Yap");
        int selectCase = Location.scanner.nextInt();
        while(selectCase < 1 ||selectCase > 3){
            System.out.println("Geçersiz Değer, Tekrar Giriniz :");
            selectCase = Location.scanner.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz...");
                return true;
        }

        return true;
    }

    public void printWeapon(){
        System.out.println("-----------Silahlar----------");
        for(Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getId()+ "-" + weapon.getName() + " <Para : "+ weapon.getPrice() + " , Hasar: " + weapon.getDamage() + " >");
        }
        System.out.println((Weapon.weapons().length + 1 )+ "- Geri Dön");
        System.out.println("Bir silah seçiniz : ");
        int selection = scanner.nextInt();
        if(selection == Weapon.weapons().length + 1){
            onLocation();
        }
        else{
            while(selection < 1 ||selection > Weapon.weapons().length + 1){
                System.out.println("Geçersiz Değer, Tekrar Giriniz :");
                selection = Location.scanner.nextInt();
            }
            buyWeapon(selection);
        }
    }

    public void buyWeapon(int selectWeapon){
        Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!");
                printWeapon();
            }else{
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmor(){
        System.out.println("-----------Zırhlar----------");
        for(Armor armor : Armor.armors()){
            System.out.println(armor.getId()+ "-" + armor.getName() + " <Para : "+ armor.getPrice() + " , Koruma: " + armor.getProtection() + " >");
        }
        System.out.println((Armor.armors().length + 1 )+ "- Geri Dön");
        System.out.println("Bir zırh seçiniz : ");
        int selection = scanner.nextInt();
        if(selection == Armor.armors().length + 1){
            onLocation();
        }
        else{
            while(selection < 1 || selection > Armor.armors().length + 1){
                System.out.println("Geçersiz Değer, Tekrar Giriniz :");
                selection = Location.scanner.nextInt();
            }
            buyArmor(selection);
        }
    }

    public void buyArmor(int selectArmor){
        Armor selectedArmor = Armor.getArmorById(selectArmor);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır!");
                printArmor();
            }else{
                System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
