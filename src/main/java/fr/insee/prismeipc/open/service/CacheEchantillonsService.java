package fr.insee.prismeipc.open.service;

import java.util.Optional;

import fr.insee.prismeipc.open.model.Echantillon;

public interface CacheEchantillonsService {

   public Optional<Echantillon> findByAnnee(Short annee);

}
