package com.wojtek.room_service;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RoomController.BASE_URL)
public class RoomController {

    public static final String BASE_URL = "room";

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PutMapping()
    public void createNewUser(@Valid @RequestBody Room room) {
        roomService.createNewRoom(room);
    }

    @PostMapping("/{roomName}")
    public void update(@PathVariable String roomName, @Valid @RequestBody Room room){ roomService.updateRoom(roomName,room); }

    @DeleteMapping({"/{roomName}"})
    public void delete(@PathVariable String roomName){
        roomService.delete(roomName);
    }

    @GetMapping({"","/"})
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping({"/{roomName}"})
    public Optional<RoomEntity> getRoomById(@PathVariable String roomName){
        return roomService.getRoomById(roomName);
    }
}
