package me.ialext.dlux.autopickup;

import java.util.Set;

public interface SimpleCache<E> {

    Set<E> get();

    default void add(E e) {
        get().add(e);
    }

    default void remove(E e) {
        get().remove(e);
    }

    default boolean exists(E e) {
        return get().contains(e);
    }
}
