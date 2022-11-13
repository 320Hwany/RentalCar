import automobile.Car;
import automobile.SUV;
import automobile.Truck;
import exception.CheckAutomobileValid;
import exception.CommandException;
import repository.AutomobileRepository;
import exception.CheckDateValid;
import service.RentalService;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RentalManagement {

    public static void main(String[] args) throws FileNotFoundException {

        RentalService rentalService = new RentalService();
        CheckDateValid checkDateValid = new CheckDateValid();
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
            String command = split.get(0);
            boolean checkDate = checkDateValid.checkDate(split);
            boolean checkCommand = CommandException.checkCommand(command);
            boolean checkAutomobile = CheckAutomobileValid.checkAutomobile(split);
            if (checkDate && checkCommand && checkAutomobile) {
                switch (command) {
                    case "r" : rentalService.reservation(split);
                        break;
                    case "c" : rentalService.cancelReservation(split);
                        break;
                    case "o" : rentalService.checkOut(split);
                        break;
                    case "i" : rentalService.checkIn(split);
                        break;
                    case "v" : rentalService.viewAllReservedVehicles();
                        break;
                    case "a" : rentalService.viewAllRentedVehicles();
                        break;
                    case "p" : rentalService.income();
                        break;
                    case "d" : rentalService.setDate(split);
                        break;
                    default: System.out.println("올바르지 않은 명령어입니다. 다시 입력해주세요");
                        break;
                }
            }
        }
    }
}
