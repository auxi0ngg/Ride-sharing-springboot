package com.project.ridebooking.RideBookingApplication.Service;

import org.locationtech.jts.geom.Point;

import java.util.concurrent.CompletableFuture;

public interface DistanceService {

    public CompletableFuture<Double> calculateDistance(Point src, Point dest);

}
