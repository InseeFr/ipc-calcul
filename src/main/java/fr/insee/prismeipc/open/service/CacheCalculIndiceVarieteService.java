package fr.insee.prismeipc.open.service;

import java.util.List;
import java.util.Map;

import fr.insee.prismeipc.open.model.IndiceVarieteMensuelAbstract;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.Territoire;

public interface CacheCalculIndiceVarieteService {

   public Map<ItemCoicop, Map<Territoire, List<IndiceVarieteMensuelAbstract>>> getAllMensuelByPosteAndTerritoire();
}
