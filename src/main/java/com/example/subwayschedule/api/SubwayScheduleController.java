package com.example.subwayschedule.api;

import com.example.subwayschedule.service.SubwayScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SubwayScheduleController {

    private SubwayScheduleService service;

    public SubwayScheduleController(SubwayScheduleService service) {
        this.service = service;
    }

    @GetMapping("/schedule/{stationId}")
    public Object getSchedule(@RequestParam(value = "time", required = false, defaultValue = "") String time,
                              @RequestParam(value = "size", required = false, defaultValue = "5") long maxSize,
                              @RequestParam(value = "station", required = false, defaultValue = "소요산, 동두천") List<String> stations,
                              @PathVariable(name = "stationId") String stationId) throws JsonProcessingException {

        log.debug("time: {}", time);
        log.debug("maxSize: {}", maxSize);
        stations.stream().forEach(station -> log.debug(station));

        log.debug("stationId: {}", stationId);

        return service.getSchedule(time, maxSize, stations, stationId);
    }

    @GetMapping("/station/{name}")
    public Object getStationName(@PathVariable(name = "name") String name) throws JsonProcessingException {
        log.debug("name {}", name);
        return service.getStationName(name);
    }

    @GetMapping("/route/{start}/{end}")
    public Object getRoute(@RequestParam(value = "time", required = false, defaultValue = "") String time,
            @PathVariable String start, @PathVariable String end) throws JsonProcessingException {

        log.debug("time: {}", time);
        log.debug("start: {}", start);
        log.debug("end: {}", end);

        return service.getRoute(time, start, end);
    }
}
