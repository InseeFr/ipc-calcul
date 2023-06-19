package fr.insee.prismeipc.open.service;

import java.util.List;

import fr.insee.prismeipc.open.model.IndiceCoicopMensuelAbstract;

public interface CacheIndicePosteService {

   public List<? extends IndiceCoicopMensuelAbstract> findByAnneeMois(Short annee, Short mois);

}
