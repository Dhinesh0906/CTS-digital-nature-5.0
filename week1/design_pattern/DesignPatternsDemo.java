public class DesignPatternsDemo {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern ===");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same Instance: " + (s1 == s2));

        System.out.println("\n=== Factory Pattern ===");
        FoodFactory pizzaFactory = new PizzaFactory();
        Food pizza = pizzaFactory.createFood();
        System.out.println(pizza.prepare());

        FoodFactory burgerFactory = new BurgerFactory();
        Food burger = burgerFactory.createFood();
        System.out.println(burger.prepare());

        System.out.println("\n=== Builder Pattern ===");
        Computer computer = new ComputerBuilder("512 GB SSD", "16 GB")
                .setGraphicsCard("RTX 4060")
                .setBluetooth("Bluetooth 5.0")
                .build();

        System.out.println(computer);
    }
}

class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

interface Food {
    String prepare();
}

class Pizza implements Food {
    public String prepare() {
        return "Preparing Pizza";
    }
}

class Burger implements Food {
    public String prepare() {
        return "Preparing Burger";
    }
}

abstract class FoodFactory {
    abstract Food createFood();
}

class PizzaFactory extends FoodFactory {
    public Food createFood() {
        return new Pizza();
    }
}

class BurgerFactory extends FoodFactory {
    public Food createFood() {
        return new Burger();
    }
}

class Computer {

    private String storage;
    private String ram;
    private String graphicsCard;
    private String bluetooth;

    public Computer(String storage, String ram,
                    String graphicsCard, String bluetooth) {
        this.storage = storage;
        this.ram = ram;
        this.graphicsCard = graphicsCard;
        this.bluetooth = bluetooth;
    }

    public String toString() {
        return "Computer [Storage=" + storage +
                ", RAM=" + ram +
                ", Graphics=" + graphicsCard +
                ", Bluetooth=" + bluetooth + "]";
    }
}

class ComputerBuilder {

    private String storage;
    private String ram;
    private String graphicsCard;
    private String bluetooth;

    public ComputerBuilder(String storage, String ram) {
        this.storage = storage;
        this.ram = ram;
    }

    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public Computer build() {
        return new Computer(storage, ram, graphicsCard, bluetooth);
    }
}