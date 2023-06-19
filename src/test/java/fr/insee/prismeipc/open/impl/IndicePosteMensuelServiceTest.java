package fr.insee.prismeipc.open.impl;

import java.util.List;

import fr.insee.prismeipc.open.model.IndicePosteMensuel;
import fr.insee.prismeipc.open.service.IndicePosteMensuelService;

public class IndicePosteMensuelServiceTest implements IndicePosteMensuelService {

   public List<IndicePosteMensuel> indicesAEnregistrer;

   @Override
   public List<IndicePosteMensuel> saveAll(List<IndicePosteMensuel> indicesAEnregistrer) {
      this.indicesAEnregistrer = indicesAEnregistrer;
      return indicesAEnregistrer;
   };

   public List<IndicePosteMensuel> getIndices() {
      return indicesAEnregistrer;
   }

   public void clear() {
      indicesAEnregistrer = null;
   }

}
