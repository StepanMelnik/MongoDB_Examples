package com.sme.mongodb.util;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Optional consumer that supports ifPresent, ifNotPresent operations (the application works with Java8).
 * 
 * @param T The parameter of consumer.
 */
public final class OptionalConsumer<T>
{
    private final Optional<T> optional;

    // private constructor
    private OptionalConsumer(Optional<T> optional)
    {
        this.optional = optional;
    }

    /**
     * Create optional consumer.
     * 
     * @param <T> optional instance;
     * @param optional The Optional instance;
     * @return Returns {@link OptionalConsumer}.
     */
    public static <T> OptionalConsumer<T> of(Optional<T> optional)
    {
        return new OptionalConsumer<>(optional);
    }

    /**
     * Check if optional is present with the given consumer.
     * 
     * @param consumer The given consumer;
     * @return Returns {@link OptionalConsumer}.
     */
    public OptionalConsumer<T> ifPresent(Consumer<? super T> consumer)
    {
        optional.ifPresent(consumer);
        return this;
    }

    /**
     * Check if optional is not present with the given consumer.
     * 
     * @param runnable The given runnable;
     * @return Returns {@link OptionalConsumer}.
     */
    public OptionalConsumer<T> ifNotPresent(Runnable runnable)
    {
        if (!optional.isPresent())
        {
            runnable.run();
        }
        return this;
    }
}
