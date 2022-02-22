package be.craftcode.mappingdemo.service;

import be.craftcode.mappingdemo.dto.CovidDTO;

import java.util.List;

public interface IWaveService {
    List<CovidDTO> getAllCovids();
}
