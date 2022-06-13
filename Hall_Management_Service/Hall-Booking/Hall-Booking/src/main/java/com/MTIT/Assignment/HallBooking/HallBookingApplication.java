package com.MTIT.Assignment.HallBooking;

import com.MTIT.Assignment.HallBooking.model.Hall;
import com.MTIT.Assignment.HallBooking.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HallBookingApplication{

	public static void main(String[] args) {
		SpringApplication.run(HallBookingApplication.class, args);
	}

//	@Autowired
//	private HallRepository hallRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Hall hall = new Hall();
//		hall.setHallName("Savoy");
//		hall.setHallType("Comfortable");
//		hall.setLocation("Colombo");
//		hall.setAvailability("Yes");
//		hall.setSeatCapacity(10);
//		hallRepository.save(hall);
//
//		Hall hall1 = new Hall();
//		hall.setHallName("PVR");
//		hall.setHallType("Medium");
//		hall.setLocation("India");
//		hall.setAvailability("No");
//		hall.setSeatCapacity(50);
//		hallRepository.save(hall1);

}
