package fr.insee.prismeipc.open.model.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum TypeIndiceVarieteMensuel {
   CALCULE("CALCULE"), //
   SAISI("SAISI") //
   ;

   private String code;

   private TypeIndiceVarieteMensuel(String code) {
      this.code = code;
   }

   private static final Map<String, TypeIndiceVarieteMensuel> mapCodes = new HashMap<>();
   static {
      for (TypeIndiceVarieteMensuel typeIndiceVarieteMensuel : values()) {
         mapCodes.put(typeIndiceVarieteMensuel.getCode(), typeIndiceVarieteMensuel);
      }
   }

   public static TypeIndiceVarieteMensuel getByCode(String code) {
      final TypeIndiceVarieteMensuel value = mapCodes.get(code);
      if (value != null) {
         return value;
      }
      throw new IllegalArgumentException("Code de TypeIndiceVarieteMensuel inconnu : " + code);
   }

   public String getCode() {
      return code;
   }
}
