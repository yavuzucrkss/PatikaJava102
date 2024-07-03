import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    public void start(){
        System.out.println("Mavera Oyununa Hoşgeldiniz");
        System.out.println("Lütfen Bir İsim Gİriniz");
        //String playerName = scanner.nextLine();
        Player player = new Player("Ali");
        System.out.println(player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("------------------Bölgeler------------------");
            System.out.println("1- Güvenli Ev -> Burası sizin için güvenli");;
            System.out.println("2- Mağaza -> Silah veya Zırh satın alabilirsiniz");
            System.out.println("3- Mağara -> <Ödül : Yemek> Mağaraya gir");
            System.out.println("4- Orman -> <Ödül : Odun> Ormana git");
            System.out.println("5- Nehir -> <Ödül : Su> Nehre git");
            System.out.println("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz :");
            int selectLoc = scanner.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forrest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
                    break;
            }
            if(location == null){
                continue;
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }
        }

    }
}
