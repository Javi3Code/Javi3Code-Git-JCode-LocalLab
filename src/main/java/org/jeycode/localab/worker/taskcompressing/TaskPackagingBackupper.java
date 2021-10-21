package org.jeycode.localab.worker.taskcompressing;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public interface TaskPackagingBackupper
{

      CompletableFuture<Boolean> compressAsync(Path path);

      boolean compress(Path path);

      CompletableFuture<Boolean> deCompressAsync(Path path);

      boolean deCompress(Path path);

}
