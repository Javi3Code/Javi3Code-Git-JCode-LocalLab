package org.jeycode.localab.worker.taskcompressing;

import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import org.jeycode.localab.applicationcontext.model.ApplicationContext;
import org.jeycode.localab.worker.taskcompressing.compressor.CompressorComponent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskPackagingBackupperImpl implements TaskPackagingBackupper
{

      private final CompressorComponent compressorComponentImpl;

      @Override @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> compressAsync(Path path)
      {
            return null;
      }

      @Override
      public boolean compress(Path path)
      {
            return false;
      }

      @Override @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> deCompressAsync(Path path)
      {
            return null;
      }

      @Override
      public boolean deCompress(Path path)
      {
            return false;
      }

}
