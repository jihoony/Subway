package com.example.subwayschedule.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface SubwayScheduleService {
    Object getSchedule(String currentTime, long maxSize, List<String> stations, String stationId) throws JsonProcessingException;

    Object getStationName(String name) throws JsonProcessingException;

    Object getRoute(String time, String start, String end) throws JsonProcessingException;
}
