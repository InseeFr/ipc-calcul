package fr.insee.prismeipc.open.service;

import java.util.Optional;

import fr.insee.prismeipc.open.model.ItemCoicop;

public interface CacheItemsCoicopService {

   public Optional<ItemCoicop> findById(Long id);

}
