package fr.insee.prismeipc.open.service;

import java.util.Map;
import java.util.Optional;

import fr.insee.prismeipc.open.model.AgregatCoicop;
import fr.insee.prismeipc.open.model.PonderationCoicopAbstract;

public interface CachePonderationPosteService {

   Optional<? extends Map<Long, ? extends PonderationCoicopAbstract>> findByAgregatSansMois(AgregatCoicop agregat);

}
