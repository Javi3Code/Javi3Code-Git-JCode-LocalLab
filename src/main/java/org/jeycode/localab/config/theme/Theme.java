package org.jeycode.localab.config.theme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theme
{

      private AppColor bgColor,fgColor = new AppColor();
}
