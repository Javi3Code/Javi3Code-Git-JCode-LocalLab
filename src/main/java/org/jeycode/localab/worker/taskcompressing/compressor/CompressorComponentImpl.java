package org.jeycode.localab.worker.taskcompressing.compressor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static org.jeycode.localab.utils.GenericHelper.GZIP_TEMP_DIR_LOCATION_VAR;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;

@Component
@Slf4j
public class CompressorComponentImpl implements CompressorComponent
{

      private final ZipFile zipFileObj;
      private final String location;

      public CompressorComponentImpl(ZipFile zipFileObj,@Value(GZIP_TEMP_DIR_LOCATION_VAR)String location)
      {
            this.zipFileObj = zipFileObj;
            this.location = location;
      }

}
