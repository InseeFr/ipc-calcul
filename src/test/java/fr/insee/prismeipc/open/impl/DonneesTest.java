package fr.insee.prismeipc.open.impl;

import java.math.BigDecimal;

import fr.insee.prismeipc.open.model.Echantillon;
import fr.insee.prismeipc.open.model.ItemCoicop;
import fr.insee.prismeipc.open.model.PonderationVarieteEchantillon;
import fr.insee.prismeipc.open.model.Territoire;
import fr.insee.prismeipc.open.model.Variete;
import fr.insee.prismeipc.open.model.VarieteEchantillon;
import fr.insee.prismeipc.open.model.enumeration.NiveauCoicop;

public class DonneesTest {

   // ItemCoicop
   public final static ItemCoicop ITEM_COICOP_ENSEMBLE = new ItemCoicop(0l, "00", null, NiveauCoicop.ENSEMBLE);
   public final static ItemCoicop ITEM_COICOP_DIVISION_01 = new ItemCoicop(1l, "01", ITEM_COICOP_ENSEMBLE, NiveauCoicop.DIVISION);
   public final static ItemCoicop ITEM_COICOP_GROUPE_011 = new ItemCoicop(11l, "011", ITEM_COICOP_DIVISION_01, NiveauCoicop.GROUPE);
   public final static ItemCoicop ITEM_COICOP_CLASSE_0111 = new ItemCoicop(111l, "0111", ITEM_COICOP_GROUPE_011, NiveauCoicop.CLASSE);
   public final static ItemCoicop ITEM_COICOP_SOUS_CLASSE_01111 = new ItemCoicop(1111l, "01111", ITEM_COICOP_CLASSE_0111, NiveauCoicop.SOUS_CLASSE);
   public final static ItemCoicop ITEM_COICOP_SOUS_CLASSE_01112 = new ItemCoicop(1112l, "01112", ITEM_COICOP_CLASSE_0111, NiveauCoicop.SOUS_CLASSE);
   public final static ItemCoicop ITEM_COICOP_POSTE_011111 = new ItemCoicop(11111l, "011111", ITEM_COICOP_SOUS_CLASSE_01111, NiveauCoicop.POSTE);
   public final static ItemCoicop ITEM_COICOP_POSTE_011122 = new ItemCoicop(11122l, "011122", ITEM_COICOP_SOUS_CLASSE_01112, NiveauCoicop.POSTE);
   public final static ItemCoicop ITEM_COICOP_POSTE_011121 = new ItemCoicop(11121l, "011121", ITEM_COICOP_SOUS_CLASSE_01112, NiveauCoicop.POSTE);

   // Territoire
   public final static Territoire TERRITOIRE_METROPOLE = new Territoire(1l, "MET", "Métropole", 0l);
   public final static Territoire TERRITOIRE_GUADELOUPE = new Territoire(2l, "GUA", "Guadeloupe", 0l);

   // Echantillon
   public final static Echantillon ECHANTILLON_2022 = new Echantillon(1l, (short) 2022);

   // Variete
   public final static Variete VARIETE_METROPOLE_1 = new Variete(1l, TERRITOIRE_METROPOLE);
   public final static Variete VARIETE_METROPOLE_2 = new Variete(2l, TERRITOIRE_METROPOLE);
   public final static Variete VARIETE_METROPOLE_3 = new Variete(3l, TERRITOIRE_METROPOLE);
   public final static Variete VARIETE_GUADELOUPE_4 = new Variete(4l, TERRITOIRE_GUADELOUPE);

   // VarieteEchantillon
   public final static VarieteEchantillon VARIETE_2022_METROPOLE_1 = new VarieteEchantillon(VARIETE_METROPOLE_1, ECHANTILLON_2022, ITEM_COICOP_POSTE_011111, true, false,
      new PonderationVarieteEchantillon(50, 50, new BigDecimal(999), new BigDecimal(999)));
   public final static VarieteEchantillon VARIETE_2022_METROPOLE_2 = new VarieteEchantillon(VARIETE_METROPOLE_2, ECHANTILLON_2022, ITEM_COICOP_POSTE_011111, true, false,
      new PonderationVarieteEchantillon(50, 50, new BigDecimal(999), new BigDecimal(999)));
   public final static VarieteEchantillon VARIETE_2022_METROPOLE_3 = new VarieteEchantillon(VARIETE_METROPOLE_3, ECHANTILLON_2022, ITEM_COICOP_POSTE_011111, false, true,
      new PonderationVarieteEchantillon(100, 100, new BigDecimal(999), new BigDecimal(999)));
   public final static VarieteEchantillon VARIETE_2022_GUADELOUPE_4 = new VarieteEchantillon(VARIETE_GUADELOUPE_4, ECHANTILLON_2022, ITEM_COICOP_POSTE_011111, true, false,
      new PonderationVarieteEchantillon(100, 100, new BigDecimal(999), new BigDecimal(999)));

}
