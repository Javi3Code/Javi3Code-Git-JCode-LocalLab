package org.jeycode.localab.commandmodel;

import java.util.Set;

import org.jeycode.localab.commandmodel.contract.Executable;
import org.jeycode.localab.commandmodel.helper.Commands;
import org.jeycode.localab.commandmodel.helper.Parameters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * El objeto que va a envolver todo lo relacionado a la
 * operación-comando/parámetros.
 * 
 * @see Commands
 * @see Parameters
 * 
 * @author Javier Pérez Alonso
 *
 *         11 ago. 2021
 *
 */

@Getter
@Setter
@Builder
public final class CommandWrapper
{

      private Set<String> parameters;
      private Executable executable;
}
