import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        waterTank tank = null;

        while (tank == null) {
            System.out.print("Enter water tank capacity (liters): ");
            try {
                double capacity = scanner.nextDouble();
                tank = new waterTank(capacity);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please use numbers.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        boolean display = true;
        while (display) {
            System.out.println("\n === Water Tank ===");
            System.out.println("1. Fill tank");
            System.out.println("2. Drain Tank");
            System.out.println("3. Check current water level");
            System.out.println("4. Check if tank is Full");
            System.out.println("5. Check if tank is Empty");
            System.out.println("6. Display Tank Visualization");
            System.out.println("7. Exit");
            int choice = -1;


            try {
                System.out.print("Enter your choice (1 to 7): ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            // giving space to separate 
            System.out.println(" ");


            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter liters to add: ");
                        double add = scanner.nextDouble();
                        tank.fill(add);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.nextLine();
                    }
                    break;


                case 2:
                    try {
                        System.out.println("Enter liters to drain: ");
                        double drainWater = scanner.nextDouble();
                        tank.drain(drainWater);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.nextLine();
                    }
                    break;


                case 3:
                    System.out.println("Current water level: " + tank.getCurrentLevel());
                    break;


                case 4:
                    if (tank.isFull()) {
                        System.out.println("Water Tank is Full");
                    } else {
                        System.out.println("Water Tank is not full, current water level: " + tank.getCurrentLevel());
                        tank.displayTank();
                    }
                    break;


                case 5:
                    if (tank.isEmpty()) {
                        System.out.println("Water Tank is still at: ");
                        tank.displayTank();
                    } else {
                        System.out.println("Water Tank is still at: " + tank.getCurrentLevel() + " liters and not empty.");
                    }
                    break;


                case 6:
                    tank.displayTank();
                    break;


                case 7:
                    System.out.println("Goodbye, See you next time :) ");
                    display = false;
                    scanner.close();
                    break;


                default:
                    System.out.println("Invalid choice! Please select 1-7.");

            }

        }

    }
    
}
