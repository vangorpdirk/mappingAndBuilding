package be.craftcode.mappingdemo.repository;

import be.craftcode.mappingdemo.entity.CovidEO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WaveRepository {
    private List<CovidEO> covidEOList;

    public WaveRepository() {
        this.covidEOList = List.of(
                new CovidEO.CovidEOBuilder(1).type("alpha").lineage("B.1.1.7").firstDocumented("UK Sep 2020").build(),
                new CovidEO.CovidEOBuilder(2).type("beta").lineage("B.1.351").firstDocumented("South Africa May 2020").build(),
                new CovidEO.CovidEOBuilder(3).type("gamma").lineage("P.1").firstDocumented("Brazil Nov 2020").build(),
                new CovidEO.CovidEOBuilder(4).type("delta").lineage("B.1.617.2").firstDocumented("India Oct 2020").build(),
                new CovidEO.CovidEOBuilder(5).type("epsilon").lineage("B.1.429").firstDocumented("USA Mar 2020").build()
        );
    }

    public List<CovidEO> findAll() {
        return covidEOList;
    }
}
