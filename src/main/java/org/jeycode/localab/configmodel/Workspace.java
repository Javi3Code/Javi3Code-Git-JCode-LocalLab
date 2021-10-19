package org.jeycode.localab.configmodel;

import java.util.Set;

import org.jeycode.localab.utils.LocaleRef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workspace
{

      private String dirPath;
      private Set<LocaleRef> localeRefs;
}
