package com.example.subwayschedule.subway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${feign.client.config.subway.name}", url = "${feign.client.config.subway.url}",
configuration = CustomFeignConfiguration.class)
public interface NaverSubway {

    @GetMapping("transit/subway/stations/{stationId}/schedule")
    ResponseEntity<String> getInfo(@PathVariable("stationId") String stationId, @RequestParam String lang);

    @GetMapping("subway/provide")
    ResponseEntity<String> getStationName(@RequestParam String readPath, @RequestParam String version, @RequestParam String requestFile, @RequestParam String lang);

    @GetMapping("transit/directions/subway")
    ResponseEntity<String> getRoute(@RequestParam String start, @RequestParam String goal, @RequestParam String departureTime);
}
