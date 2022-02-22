package be.craftcode.mappingdemo.mappers;

import be.craftcode.mappingdemo.dto.CovidDTO;
import be.craftcode.mappingdemo.entity.CovidEO;
import be.craftcode.mappingdemo.responses.CovidResponse;

public interface MapCovids {
    CovidDTO covidEOToDTO(CovidEO covidEO);

    CovidEO covidDTOToEO(CovidDTO covidDTO);

    CovidResponse covidDTOToResponse(CovidDTO covidDTO);
}
