package be.craftcode.mappingdemo.controller;

import be.craftcode.mappingdemo.mappers.MapCovids;
import be.craftcode.mappingdemo.responses.CovidResponse;
import be.craftcode.mappingdemo.service.IWaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WaveController {
    private final MapCovids mapCovids;
    private final IWaveService waveService;

    public WaveController(MapCovids mapCovids, IWaveService waveService) {
        this.mapCovids = mapCovids;
        this.waveService = waveService;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/waves",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CovidResponse>> getAllTypes() {
        try {
            List<CovidResponse> covidResponses = waveService.getAllCovids().stream()
                    .map(mapCovids::covidDTOToResponse).collect(Collectors.toList());

            return new ResponseEntity<>(covidResponses, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
