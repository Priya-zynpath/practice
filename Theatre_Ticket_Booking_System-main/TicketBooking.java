import java.util.Scanner;

class Theater {

    String seats[][] = new String[5][5];

    Theater() {

        for(int i = 0; i < 5; i++) {

            for(int j = 0; j < 5; j++) {

                seats[i][j] = "O";
            }
        }
    }

    void displaySeats() {

        System.out.println("\n===== SCREEN THIS SIDE =====\n");

        for(int i = 0; i < 5; i++) {

            for(int j = 0; j < 5; j++) {

                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("\nO = Available");
        System.out.println("X = Booked");
    }

    void bookSeat(int row, int col) {

        if(seats[row][col].equals("O")) {

            seats[row][col] = "X";

            int price;

            if(row == 0 || row == 1) {
                price = 250;
            }
            else {
                price = 150;
            }

            System.out.println("Ticket Booked Successfully");
            System.out.println("Ticket Price : Rs." + price);
        }
        else {

            System.out.println("Seat Already Booked");
        }
    }

    void cancelSeat(int row, int col) {

        if(seats[row][col].equals("X")) {

            seats[row][col] = "O";

            System.out.println("Ticket Cancelled Successfully");
        }
        else {

            System.out.println("Seat Already Available");
        }
    }
}

public class TicketBooking {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            Theater t = new Theater();

            int choice;

            do {

                System.out.println("\n===== THEATER TICKET BOOKING SYSTEM =====");
                System.out.println("1. View Seats");
                System.out.println("2. Book Ticket");
                System.out.println("3. Cancel Ticket");
                System.out.println("4. Exit");

                System.out.print("Enter Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> t.displaySeats();

                    case 2 -> {
                        t.displaySeats();

                        System.out.print("Enter Row (1-5): ");
                        int row = sc.nextInt();

                        System.out.print("Enter Column (1-5): ");
                        int col = sc.nextInt();

                        if (row >= 1 && row <= 5 && col >= 1 && col <= 5) {
                            t.bookSeat(row - 1, col - 1);
                        } else {
                            System.out.println("Invalid Seat Number");
                        }
                    }

                    case 3 -> {
                        t.displaySeats();

                        System.out.print("Enter Row (1-5): ");
                        int row = sc.nextInt();

                        System.out.print("Enter Column (1-5): ");
                        int col = sc.nextInt();

                        if (row >= 1 && row <= 5 && col >= 1 && col <= 5) {
                            t.cancelSeat(row - 1, col - 1);
                        } else {
                            System.out.println("Invalid Seat Number");
                        }
                    }

                    case 4 -> System.out.println("Thank You");

                    default -> System.out.println("Invalid Choice");
                }

            } while(choice != 4);
        }
    }
}