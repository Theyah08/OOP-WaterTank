public class waterTank {
    
    private double capacity;
    private double currentlevel;

    // user can create own capacity for water tank
    public waterTank(double capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException("The capacity must be in positive");
        }
        this.capacity = capacity;
        this.currentlevel = 0;
    }


    // user adding water
    public void fill(double liters) {
        if (liters <= 0) {
            System.out.println("Invalid amount, numbers should always be positive");
            return;
        }

        currentlevel += liters;
        if (currentlevel > capacity) {
            currentlevel = capacity;
            System.out.println("Your Tank is full, some water overflowed...");
            System.out.println("Your current water level: " + currentlevel);
        } else {
            System.out.println(liters + " liters added.");
        }
    }


    // user remove water
    public void drain(double liters) {
        if (liters <= 0) {
            System.out.println("Invalid amount, numbers should always be positive");
            return;
        }

        currentlevel -= liters;
        if (currentlevel < 0) {
            currentlevel = 0;
            System.out.println("Water Tank is empty, unable to drain more.");
        } else {
            System.out.println(liters + " liters drained.");
        }
    }


    // displaying Water Tank's current level
    public double getCurrentLevel() {
        return currentlevel;
    }


    public boolean isFull() {
        return currentlevel == capacity;
    }


    public boolean isEmpty() {
        return currentlevel == 0;
    }


    // visual display of tank
    public void displayTank() {
        int height = 10;
        int filledrows = (int) Math.round((currentlevel / capacity) * height);

        System.out.println("     ╔════════╗");
        for (int i = height; i > 0; i--) {
            if (i <= filledrows) {
                if (i == filledrows) {
                    System.out.println("     ║~~~~~~~~║");
                } else {
                    System.out.println("     ║████████║");
                } 
            }else {
                    System.out.println("     ║        ║");
            }
        }

        System.out.println("     ╚════════╝");

        double percent = (currentlevel / capacity) * 100;
        System.out.printf("Capacity: %.1f Liters | Current Level: %.1f Liters (%.1f%%)\n",
                capacity, currentlevel, percent);
    }


}
