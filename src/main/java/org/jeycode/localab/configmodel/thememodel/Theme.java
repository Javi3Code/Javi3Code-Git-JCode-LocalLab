package org.jeycode.localab.configmodel.thememodel;

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
