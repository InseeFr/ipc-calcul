package fr.insee.prismeipc.open.service;

import java.util.List;

import fr.insee.prismeipc.open.model.AnneeMois;
import fr.insee.prismeipc.open.model.IndiceVarieteMensuel;

public interface IndiceVarieteMensuelService {

   public List<IndiceVarieteMensuel> findByAnneeMois(AnneeMois anneeMois);

}
