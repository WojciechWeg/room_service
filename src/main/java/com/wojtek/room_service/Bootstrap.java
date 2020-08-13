package com.wojtek.room_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public Bootstrap(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setName("Large Room");
        roomEntity.setLocation("1st floor");
        roomEntity.setNumberOfSeats(10);
        roomEntity.setHasProjector(true);
        roomEntity.setPhoneNumber("22-22-22-22");

        RoomEntity roomEntity2  = new RoomEntity();
        roomEntity2.setName("Medium Room");
        roomEntity2.setLocation("1st floor");
        roomEntity2.setNumberOfSeats(6);
        roomEntity2.setHasProjector(true);

        RoomEntity roomEntity3 = new RoomEntity();
        roomEntity3.setName("Small Room");
        roomEntity3.setLocation("2nd floor");
        roomEntity3.setNumberOfSeats(4);
        roomEntity3.setHasProjector(false);

        roomRepository.save(roomEntity);
        roomRepository.save(roomEntity2);
        roomRepository.save(roomEntity3);

    }
}
