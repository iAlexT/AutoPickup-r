package me.ialext.dlux.autopickup.module;

import me.ialext.dlux.autopickup.SimpleCache;
import me.ialext.dlux.autopickup.cache.AutoPickupCache;
import team.unnamed.inject.bind.AbstractModule;
import team.unnamed.inject.identity.Key;
import team.unnamed.inject.identity.type.TypeReference;
import team.unnamed.inject.name.Names;

import java.util.UUID;

public class CacheModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Key.of(new TypeReference<SimpleCache<UUID>>() {
        }, Names.named("auto-pickup"))).to(AutoPickupCache.class).singleton();
    }
}
