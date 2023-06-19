package fr.insee.prismeipc.open.service;

import java.util.Optional;

import fr.insee.prismeipc.open.model.IndicePosteAnnuel;
import fr.insee.prismeipc.open.model.IndicePosteMensuel;

public interface CacheCalculIndicePosteService {

   public Optional<IndicePosteMensuel> findByItemCoicopIdTerritoireId(Long itemCoicopId, Long territoireId);

   public Optional<IndicePosteAnnuel> findIndicePosteAnnuelByItemCoicopIdTerritoireId(Long itemCoicopId, Long territoireId);

}
