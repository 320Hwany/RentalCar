import automobile.Car;
import automobile.SUV;
import automobile.Truck;
import repository.AutomobileRepository;
import service.RentalService;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RentalManagement {

    public static void main(String[] args) throws FileNotFoundException {

        RentalService rentalService = new RentalService();

        AutomobileRepository automobileRepository = new AutomobileRepository();

        Scanner scanner1 = new Scanner(new File("rentalcars.txt"));
        while (scanner1.hasNextLine()) {
            String str = scanner1.nextLine();
            List<String> split = List.of(str.split(" "));
            if (split.get(0).equals("c")) {
                Car car = new Car(Integer.valueOf(split.get(2)), Integer.valueOf(split.get(1)));
                car.setStartLocalDate(LocalDate.of(1,1,1));
                car.setEndLocalDate(LocalDate.of(1, 1, 1));
                automobileRepository.save(car);
            } else if (split.get(0).equals("s")) {
                SUV suv = new SUV(Integer.valueOf(split.get(2)), Integer.valueOf(split.get(1)));
                suv.setStartLocalDate(LocalDate.of(1,1,1));
                suv.setEndLocalDate(LocalDate.of(1,1,1));
                automobileRepository.save(suv);
            } else if (split.get(0).equals("t")) {
                Truck truck = new Truck(Integer.valueOf(split.get(2)), Integer.valueOf(split.get(1)));
                truck.setStartLocalDate(LocalDate.of(1,1,1));
                truck.setEndLocalDate(LocalDate.of(1,1,1));
                automobileRepository.save(truck);
            }
        }

        Scanner scanner2 = new Scanner(new File("commands.txt"));
        while (scanner2.hasNextLine()) {
            String str = scanner2.nextLine();
            List<String> split = List.of(str.split(" "));

            if (split.get(0).equals("r")) {
                rentalService.reservation(split);
            } else if (split.get(0).equals("c")) {
                rentalService.cancelReservation(split);
            } else if (split.get(0).equals("o")) {
                rentalService.checkOut(split);
            } else if (split.get(0).equals("i")) {
                rentalService.checkIn(split);
            }  else if (split.get(0).equals("v")) {
                rentalService.viewAllReservedVehicles(split);
            } else if (split.get(0).equals("a")) {
                rentalService.viewAllRentedVehicles(split);
            } else if (split.get(0).equals("p")) {
                rentalService.income();
            } else if (split.get(0).equals("d")) {
                rentalService.setDate(split);
            }
        }
    }
}
