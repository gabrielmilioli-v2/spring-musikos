package com.milioli.musikos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class AddressDto {

    private String state;
    private final Set<CityDto> cities = new HashSet<>();

    @Setter
    @Getter
    public static class CityDto {

        private String city;
        private final Set<NeighborhoodDto> neighborhoods = new HashSet<>();

        @Setter
        @Getter
        public static class NeighborhoodDto {

            private String neighborhood;
            private final Set<String> streets = new HashSet<>();

        }
    }
}
