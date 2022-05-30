package com.example.subwayschedule.subway.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetStationInfoResponse {

    private ServiceRegionDTO serviceRegion;
    private List<RealInfoDTO> realInfo;
    private List<LogicalInfoDTO> logicalInfo;
    private List<SubwayLineSectionDTO> subwayLineSection;
    private List<StationsDTO> stations;
    private List<SubwayTotalLineSectionDTO> subwayTotalLineSection;
    private List<SimilarStationsDTO> similarStations;
    private List<AreaInfoDTO> areaInfo;
    private SvgInfoDTO svgInfo;

    @NoArgsConstructor
    @Data
    public static class ServiceRegionDTO {
        private String code;
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class SvgInfoDTO {
        private String width;
        private String height;
    }

    @NoArgsConstructor
    @Data
    public static class RealInfoDTO {
        private String id;
        private LogicalLineDTO logicalLine;
        private String longitude;
        private String latitude;
        private String name;
        private String koName;
        private String enName;
        private String displayCode;

        @NoArgsConstructor
        @Data
        public static class LogicalLineDTO {
            private String code;
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class LogicalInfoDTO {
        private String name;
        private String koName;
        private String enName;
        private String displayCode;
        private String imagePosX;
        private String imagePosY;
        private String express;
        private String id;
    }

    @NoArgsConstructor
    @Data
    public static class SubwayLineSectionDTO {
        private String startStationId;
        private String endStationId;
        private LogicalLineDTO logicalLine;
        private String style;

        @NoArgsConstructor
        @Data
        public static class LogicalLineDTO {
            private String code;
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class StationsDTO {
        private String id;
        private String text;
    }

    @NoArgsConstructor
    @Data
    public static class SubwayTotalLineSectionDTO {
        private String stationCode;
        private String totalLines;
        private String decos;
    }

    @NoArgsConstructor
    @Data
    public static class SimilarStationsDTO {
        private String stationId;
        private String stationName;
    }

    @NoArgsConstructor
    @Data
    public static class AreaInfoDTO {
        private String areacode;
        private String areaNameFull;
        private String areaNameShort;
    }
}
