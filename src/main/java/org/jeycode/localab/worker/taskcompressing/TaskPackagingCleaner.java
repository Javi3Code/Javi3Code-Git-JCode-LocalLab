package org.jeycode.localab.worker.taskcompressing;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public interface TaskPackagingCleaner
{

      Boolean deleteTaskModelStructure(Path path);

      CompletableFuture<Boolean> deleteTaskModelStructureAsync(Path path);
}
