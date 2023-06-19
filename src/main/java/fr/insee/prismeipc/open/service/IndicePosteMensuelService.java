package fr.insee.prismeipc.open.service;

import java.util.List;

import fr.insee.prismeipc.open.model.IndicePosteMensuel;

public interface IndicePosteMensuelService {

   public List<IndicePosteMensuel> saveAll(List<IndicePosteMensuel> indicesPosteMensuel);

}
