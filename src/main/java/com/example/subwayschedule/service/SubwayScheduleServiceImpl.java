package com.example.subwayschedule.service;

import com.example.subwayschedule.subway.NaverSubway;
import com.example.subwayschedule.subway.vo.GetInfoResponse;
import com.example.subwayschedule.subway.vo.GetRouteResponse;
import com.example.subwayschedule.subway.vo.GetStationInfoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubwayScheduleServiceImpl implements SubwayScheduleService {
    private NaverSubway naverSubway;

    private SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat timeForamt = new SimpleDateFormat("HH:mm:ss");
    private SimpleDateFormat ymdTimeForamt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public SubwayScheduleServiceImpl(NaverSubway naverSubway) {
        this.naverSubway = naverSubway;
    }

    @Override
    public Object getSchedule(String time, long maxSize, List<String> stations, String stationId) throws JsonProcessingException {

        log.debug("time {}", time);

        Date now = getDate(time);

        log.debug("now {}", now);

        ResponseEntity<String> responseEntity = naverSubway.getInfo(stationId, "ko");

        if (responseEntity.getStatusCode() == HttpStatus.OK){

            ObjectMapper objectMapper = new ObjectMapper();
            GetInfoResponse getInfoResponse = objectMapper.readValue(responseEntity.getBody(), GetInfoResponse.class);

            String ymd = ymdFormat.format(now);

            Date finalNow = now;
            List<GetInfoResponse.UpDownDTO> collect = getInfoResponse.getWeekdaySchedule().getUp().stream()
                    .filter(up -> {
                        try {
                            Date departureTime = ymdTimeForamt.parse(ymd + "T" + up.getDepartureTime());
                            return departureTime.after(finalNow);
                        } catch (ParseException e) {
                            return false;
                        }
                    })
                    .filter(up-> stations.stream()
                            .anyMatch(station ->station.equals(up.getHeadsign())))
                    .limit(maxSize)
                    .collect(Collectors.toList());

            return collect;
        }

        return null;
    }

    private Date getDate(String currentTime) {
        Date now = null;
        if (currentTime == null || currentTime.trim().equals("")) {
            now = new Date();
        } else {
            try {
                Date date = new Date();
                String ymd = ymdFormat.format(date);
                now = ymdTimeForamt.parse( ymd + "T" + currentTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return now;
    }

    @Override
    public Object getStationName(String name) throws JsonProcessingException {

        ResponseEntity<String> stationName = naverSubway.getStationName("1000", "6.29", "metaData.json", "ko");

        if (stationName.getStatusCode() == HttpStatus.OK){
            ObjectMapper objectMapper = new ObjectMapper();
            List<GetStationInfoResponse> getStationInfoResponse = objectMapper.readValue(stationName.getBody(), new TypeReference<List<GetStationInfoResponse>>() {});

            List<GetStationInfoResponse.RealInfoDTO> collect = getStationInfoResponse.stream()
                    .map(stationInfo ->
                            stationInfo.getRealInfo().stream()
                                    .filter(real -> real.getName().contains(name))
                                    .sorted(Comparator.comparingInt(real->Integer.parseInt(real.getLogicalLine().getCode())))
                                    .sorted(Comparator.comparing(GetStationInfoResponse.RealInfoDTO::getName))
                                    .collect(Collectors.toList())
                    )
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

            return collect;
        }


        return null;
    }

    @Override
    public Object getRoute(String time, String start, String end) throws JsonProcessingException {

        log.debug("time {}", time);

        Date now = getDate(time);
        log.debug("now {}", now);

        String currentTime = ymdTimeForamt.format(now);
        log.debug("currentTime {}", currentTime);

        ResponseEntity<String> responseEntity = naverSubway.getRoute(start, end, currentTime);
        if (responseEntity.getStatusCode() == HttpStatus.OK){
            GetRouteResponse getRouteResponse = new ObjectMapper().readValue(responseEntity.getBody(), GetRouteResponse.class);
            List<GetRouteResponse.PathsDTO> paths = getRouteResponse.getPaths();

            return paths;
        }

        return null;
    }

}
