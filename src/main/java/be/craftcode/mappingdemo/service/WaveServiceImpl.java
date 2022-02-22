package be.craftcode.mappingdemo.service;

import be.craftcode.mappingdemo.dto.CovidDTO;
import be.craftcode.mappingdemo.mappers.MapCovids;
import be.craftcode.mappingdemo.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaveServiceImpl implements IWaveService{
    private final WaveRepository waveRepository;
    private final MapCovids mapCovids;

    public WaveServiceImpl(WaveRepository waveRepository, MapCovids mapCovids) {
        this.waveRepository = waveRepository;
        this.mapCovids = mapCovids;
    }

    @Override
    public List<CovidDTO> getAllCovids() {
        return waveRepository.findAll().stream()
                .map(mapCovids::covidEOToDTO)
                .collect(Collectors.toList());
    }

}
