package fr.insee.prismeipc.open.service;

import java.util.List;

import fr.insee.prismeipc.open.model.IndiceCoicopMensuel;

public interface IndiceCoicopMensuelService {

   public List<IndiceCoicopMensuel> persisteAll(List<IndiceCoicopMensuel> indicesAEnregistrer);

}
