package be.craftcode.mappingdemo.mappers;

import be.craftcode.mappingdemo.dto.CovidDTO;
import be.craftcode.mappingdemo.entity.CovidEO;
import be.craftcode.mappingdemo.responses.CovidResponse;
import org.springframework.stereotype.Service;

@Service
public class MapCovidsImpl implements MapCovids {
    @Override
    public CovidDTO covidEOToDTO(CovidEO covidEO) {
        if (covidEO == null) {
            return null;
        }

        return new CovidDTO.CovidDTOBuilder(covidEO.getId())
                .type(covidEO.getType())
                .lineage(covidEO.getLineage())
                .firstDocumented(covidEO.getFirstDocumented())
                .build();
    }

    @Override
    public CovidEO covidDTOToEO(CovidDTO covidDTO) {
        if (covidDTO == null) {
            return null;
        }

        return new CovidEO.CovidEOBuilder(covidDTO.getId())
                .type(covidDTO.getType())
                .lineage(covidDTO.getLineage())
                .firstDocumented(covidDTO.getFirstDocumented())
                .build();
    }

    @Override
    public CovidResponse covidDTOToResponse(CovidDTO covidDTO) {
        if (covidDTO == null) {
            return null;
        }

        return new CovidResponse.CovidResponseBuilder(covidDTO.getId())
                .type(covidDTO.getType())
                .lineage(covidDTO.getLineage())
                .firstDocumented(covidDTO.getFirstDocumented())
                .build();
    }
}
