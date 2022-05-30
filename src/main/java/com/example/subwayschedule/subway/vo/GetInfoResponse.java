package com.example.subwayschedule.subway.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetInfoResponse {

    private TodayServiceDayDTO todayServiceDay;
    private int stationId;
    private String upWay;
    private String downWay;
    private String upDirection;
    private String downDirection;
    private boolean hasExpressLaneType;
    private List<LanesDTO> lanes;
    private ScheduleDTO weekdaySchedule;
    private ScheduleDTO saturdaySchedule;
    private ScheduleDTO sundaySchedule;

    @NoArgsConstructor
    @Data
    public static class LanesDTO {
        private int id;
        private String name;
        private String longName;
        private TypeDTO type;
        private OperationDTO operation;
        private String upWay;
        private String downWay;
    }

    @NoArgsConstructor
    @Data
    public static class TypeDTO {
        private int id;
        private String name;
        private String longName;
        private String shortName;
        private String iconName;
        private String color;
        private int sortingPriority;
        private ServiceAreaDTO serviceArea;
    }

    @NoArgsConstructor
    @Data
    public static class ServiceAreaDTO {
        private int id;
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class TodayServiceDayDTO {
        private int id;
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class ScheduleDTO {
        private List<UpDownDTO> up;
        private List<UpDownDTO> down;
    }

    @NoArgsConstructor
    @Data
    public static class UpDownDTO {
        private String departureTime;
        private String headsign;
        private OperationDTO operation;
        private int operationOrder;
        private int laneId;
        private boolean lastTrip;
        private boolean firstTrip;
    }

    @NoArgsConstructor
    @Data
    public static class OperationDTO {
        private String type;
        private String name;
        private String shortName;
    }
}
