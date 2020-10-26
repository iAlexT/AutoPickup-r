package me.ialext.dlux.autopickup.cache;

import me.ialext.dlux.autopickup.SimpleCache;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AutoPickupCache implements SimpleCache<UUID> {

    private final Set<UUID> autoPickupers = new HashSet<>();

    @Override
    public Set<UUID> get() {
        return autoPickupers;
    }
}
