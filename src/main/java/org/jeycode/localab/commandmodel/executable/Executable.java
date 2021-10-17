package org.jeycode.localab.commandmodel.executable;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * 
 * Functional Interface que provee el método ejecutable po los comandos.
 * 
 * @author Javier Pérez Alonso
 *
 *         11 ago. 2021
 *
 */
@FunctionalInterface
public interface Executable 
{

      CompletableFuture<Boolean> execute(Set<String> parameter,Object...optional);

}
