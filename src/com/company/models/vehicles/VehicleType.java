package com.company.models.vehicles;

import com.company.models.parkingslots.ParkingSlotType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.models.parkingslots.ParkingSlotType.*;

public enum VehicleType {
    HANDICAPPED_CAR(Arrays.asList(COMPACT,LARGE,HANDICAPPED)),
    CAR(Arrays.asList(COMPACT,LARGE)),
    TRUCK(Arrays.asList(LARGE)),
    ELECTRIC_CAR(Arrays.asList(ELECTRIC)),
    VAN(Arrays.asList(LARGE,COMPACT)),
    MOTOR_BIKE(Arrays.asList(COMPACT,MOTORBIKE));

    private final List<ParkingSlotType> fitsIn;

    VehicleType(List<ParkingSlotType> canFitSlots){
        fitsIn =canFitSlots;
    }

    public List<ParkingSlotType> getFitsIn() {
        return fitsIn;
    }
}
