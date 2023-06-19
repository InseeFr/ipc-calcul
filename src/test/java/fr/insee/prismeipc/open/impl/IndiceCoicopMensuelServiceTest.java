package fr.insee.prismeipc.open.impl;

import java.util.List;

import fr.insee.prismeipc.open.model.IndiceCoicopMensuel;
import fr.insee.prismeipc.open.service.IndiceCoicopMensuelService;

public class IndiceCoicopMensuelServiceTest implements IndiceCoicopMensuelService {

   public List<IndiceCoicopMensuel> indicesAEnregistrer;

   public List<IndiceCoicopMensuel> persisteAll(List<IndiceCoicopMensuel> indicesAEnregistrer) {
      this.indicesAEnregistrer = indicesAEnregistrer;
      return indicesAEnregistrer;
   };

   public List<IndiceCoicopMensuel> getIndices() {
      return indicesAEnregistrer;
   }

   public void clear() {
      indicesAEnregistrer = null;
   }
}
