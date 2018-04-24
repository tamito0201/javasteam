package pl.l7ssha.javasteam.reflector;

// pl.l7ssha.javasteam.reflector
//
// Date created: 21 Apr 2018
// Author: Szymon 'l7ssha' Uglis

/**
 * Reflector base interface.
 * @param <E> Class to reflect
 */
public interface Reflector<E> {
   E get();
}
