package org.jeycode.localab.configmodel.thememodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppColor
{

      private String hex;
      private int r,g,b;
      private float a;
}
