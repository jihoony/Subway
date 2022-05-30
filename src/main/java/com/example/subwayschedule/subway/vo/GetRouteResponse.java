package com.example.subwayschedule.subway.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetRouteResponse {

    private String status;
    private ContextDTO context;
    private List<PathsDTO> paths;
    private List<Object> staticPaths;

    @NoArgsConstructor
    @Data
    public static class ContextDTO {
        private String engineVersion;
        private Object engineUrl;
        private Object start;
        private Object goal;
        private String departureTime;
        private String currentDateTime;
        private ServiceDayDTO serviceDay;
        private String recommendDirectionsType;
        private Object uuid;

        @NoArgsConstructor
        @Data
        public static class ServiceDayDTO {
            private int id;
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class PathsDTO {
        private int idx;
        private String mode;
        private String type;
        private String optimizationMethod;
        private List<String> labels;
        private String departureTime;
        private String arrivalTime;
        private String alarmDepartureTime;
        private String alarmArrivalTime;
        private int duration;
        private int intercityDuration;
        private int walkingDuration;
        private int waitingDuration;
        private int distance;
        private boolean shutdown;
        private int fare;
        private List<FaresDTO> fares;
        private List<LegsDTO> legs;
        private int transferCount;
        private String directionsType;
        private List<PathLabelsDTO> pathLabels;
        private List<String> vehicleTypes;

        @NoArgsConstructor
        @Data
        public static class FaresDTO {
            private List<List<RoutesDTO>> routes;
            private int fare;
            private int tripIdx;

            @NoArgsConstructor
            @Data
            public static class RoutesDTO {
                private int id;
                private String name;
                private String longName;
                private TypeDTO type;
                private boolean realtime;
                private boolean useInterval;
                private String operationType;
                private OperationDTO operation;
                private Object color;
                private Object platform;
                private Object headsign;
                private Object busInterval;
                private Object flag;

                @NoArgsConstructor
                @Data
                public static class TypeDTO {
                    private int id;
                    private String name;
                    private Object shortName;
                    private Object iconName;
                    private String color;
                }

                @NoArgsConstructor
                @Data
                public static class OperationDTO {
                    private String type;
                    private String name;
                    private String shortName;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class LegsDTO {
            private List<StepsDTO> steps;

            @NoArgsConstructor
            @Data
            public static class StepsDTO {
                private String type;
                private String instruction;
                private InfoDTO info;
                private String departureTime;
                private String arrivalTime;
                private AlarmTimeDTO alarmTime;
                private int distance;
                private int duration;
                private int tripIdx;
                private String headsign;
                private String wayType;
                private List<RoutesDTO> routes;
                private List<StationsDTO> stations;
                private List<?> arrivals;
                private List<PointsDTO> points;
                private Object walkpath;
                private boolean shutdown;
                private boolean lastTrip;
                private boolean firstTrip;
                private Object departureCity;
                private Object stationIdAsOptional;

                @NoArgsConstructor
                @Data
                public static class InfoDTO {
                    private Object walk;
                    private String etc;
                    private Object subway;
                }

                @NoArgsConstructor
                @Data
                public static class AlarmTimeDTO {
                    private String alarmDepartureTime;
                    private String alarmArrivalTime;
                }

                @NoArgsConstructor
                @Data
                public static class RoutesDTO {
                    private int id;
                    private String name;
                    private String longName;
                    private TypeDTO type;
                    private boolean realtime;
                    private boolean useInterval;
                    private String operationType;
                    private OperationDTO operation;
                    private Object color;
                    private PlatformDTO platform;
                    private String headsign;
                    private Object busInterval;
                    private Object flag;

                    @NoArgsConstructor
                    @Data
                    public static class TypeDTO {
                        private int id;
                        private String name;
                        private String shortName;
                        private String iconName;
                        private String color;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class OperationDTO {
                        private String type;
                        private String name;
                        private String shortName;
                    }

                    @NoArgsConstructor
                    @Data
                    public static class PlatformDTO {
                        private String status;
                        private TypeDTO type;
                        private String door;
                        private List<String> doors;

                        @NoArgsConstructor
                        @Data
                        public static class TypeDTO {
                            private String code;
                            private String desc;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class StationsDTO {
                    private int id;
                    private String placeId;
                    private String name;
                    private Object longName;
                    private String displayName;
                    private String displayCode;
                    private boolean stop;
                    private boolean realtime;
                    private AuxDTO aux;

                    @NoArgsConstructor
                    @Data
                    public static class AuxDTO {
                        private PlatformDTO platform;
                        private CrossoverDTO crossover;
                        private DoorDTO door;
                        private RestroomDTO restroom;
                        private List<String> facilities;
                        private List<String> disabledFacilities;
                        private LostCenterDTO lostCenter;

                        @NoArgsConstructor
                        @Data
                        public static class PlatformDTO {
                            private int id;
                            private String name;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class CrossoverDTO {
                            private int id;
                            private String name;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class DoorDTO {
                            private int id;
                            private String name;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class RestroomDTO {
                            private int id;
                            private String name;
                        }

                        @NoArgsConstructor
                        @Data
                        public static class LostCenterDTO {
                            private String url;
                            private String tel;
                        }
                    }
                }

                @NoArgsConstructor
                @Data
                public static class PointsDTO {
                    private double x;
                    private double y;
                }
            }
        }

        @NoArgsConstructor
        @Data
        public static class PathLabelsDTO {
            private String labelCode;
            private String labelText;
        }
    }
}
