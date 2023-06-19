package fr.insee.prismeipc.open.service;

import java.util.Optional;

import fr.insee.prismeipc.open.model.IndiceCoicopAnnuel;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.enumeration.Population;

public interface CacheIndiceCoicopEchantillonService {

   Optional<IndiceCoicopAnnuel> findByItemCoicopTerritoirePopulation(ItemCoicop itemCoicop, Territoire territoire, Population population);

}
