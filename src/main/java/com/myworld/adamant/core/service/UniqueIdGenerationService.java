package com.myworld.adamant.core.service;

public interface UniqueIdGenerationService {

    String generateNumericUniqueId(String uniqueIdGenerationCounterKey);

    String generateAlphanumericUniqueId(String uniqueIdGenerationCounterKey);
}
