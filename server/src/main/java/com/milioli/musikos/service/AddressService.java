package com.milioli.musikos.service;

import com.milioli.musikos.dto.AddressDto;
import com.milioli.musikos.record.Address;
import com.milioli.musikos.record.AddressResponse;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private EntityManager entityManager;

    public Address findByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format("https://viacep.com.br/ws/%s/json/", cep);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        AddressResponse result = restTemplate.exchange(uri, HttpMethod.GET, entity, AddressResponse.class).getBody();

        if (Objects.isNull(result)) {
            throw new IllegalStateException(String.format("CEP %s não encontrado.", cep));
        }

        return new Address(result.cep(), result.logradouro(), result.bairro(), result.localidade(), result.uf());
    }

    public Set<AddressDto> findAll() {
        final List<Address> addresses = entityManager.createQuery("select m.address from Musician m where m.address is not null group by m.address", Address.class)
                .getResultList();

        final Set<AddressDto> dtos = new HashSet<>();

        addresses.stream()
                .filter(address -> Objects.nonNull(address.state()))
                .collect(Collectors.groupingBy(Address::state))
                .forEach((state, cities) -> {

                    final AddressDto addressDto = new AddressDto();
                    addressDto.setState(state);

                    cities.stream()
                            .filter(address -> Objects.nonNull(address.city()))
                            .collect(Collectors.groupingBy(Address::city))
                            .forEach((city, neighborhoods) -> {

                                final AddressDto.CityDto cityDto = new AddressDto.CityDto();
                                cityDto.setCity(city);

                                neighborhoods.stream()
                                        .filter(address -> Objects.nonNull(address.neighborhood()))
                                        .collect(Collectors.groupingBy(Address::neighborhood))
                                        .forEach((neighborhood, streets) -> {

                                            final AddressDto.CityDto.NeighborhoodDto neighborhoodDto = new AddressDto.CityDto.NeighborhoodDto();
                                            neighborhoodDto.setNeighborhood(neighborhood);
                                            neighborhoodDto.getStreets().addAll(streets.stream()
                                                    .map(Address::street)
                                                    .filter(Objects::nonNull)
                                                    .collect(Collectors.toSet()));

                                            cityDto.getNeighborhoods().add(neighborhoodDto);

                                        });

                                addressDto.getCities().add(cityDto);

                            });

                    dtos.add(addressDto);
                });

        return dtos;
    }

}
