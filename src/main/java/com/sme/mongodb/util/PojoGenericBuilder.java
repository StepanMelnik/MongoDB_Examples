package com.sme.mongodb.util;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Generic builder of pojo.
 */
public class PojoGenericBuilder<T>
{
    private final T pojo;

    public PojoGenericBuilder(Supplier<T> supplier)
    {
        this.pojo = supplier.get();
    }

    public static <T> PojoGenericBuilder<T> of(Supplier<T> supplier)
    {
        return new PojoGenericBuilder<>(supplier);
    }

    public <V> PojoGenericBuilder<T> with(BiConsumer<T, V> consumer, V value)
    {
        consumer.accept(pojo, value);
        return this;
    }

    public T build()
    {
        return pojo;
    }
}
