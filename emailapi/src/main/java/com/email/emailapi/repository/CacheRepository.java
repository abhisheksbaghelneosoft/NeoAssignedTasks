package com.email.emailapi.repository;
import java.util.Optional;

/**
 * CacheRepository
 */
public interface CacheRepository {

    void put(String key, Integer value);

    Optional<String> get(String key);

    void remove(String key);

}