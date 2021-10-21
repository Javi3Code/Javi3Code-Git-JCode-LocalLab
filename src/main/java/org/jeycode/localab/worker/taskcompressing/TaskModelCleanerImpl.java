package org.jeycode.localab.worker.taskcompressing;

import static org.jeycode.localab.utils.GenericHelper.ASYNC_EXECUTOR;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskModelCleanerImpl implements TaskPackagingCleaner
{

     

      @Override @Async(ASYNC_EXECUTOR)
      public CompletableFuture<Boolean> deleteTaskModelStructureAsync(Path path)
      {
            return CompletableFuture.supplyAsync(()-> deleteTaskModelStructure(path));
      }

      @Override
      public Boolean deleteTaskModelStructure(Path path)
      {
            String okLogMsg = "Se ha borrado correctamente el 'Task'";
            String errLogMsg = "No se ha podido borrar correctamente el 'Task'";
            try
            {
                  log.info("Se procede a borrar el TaskModelStructure.");
                  boolean deleteRecursively = FileSystemUtils.deleteRecursively(path);
                  String logMsg = deleteRecursively ? okLogMsg : errLogMsg;
                  log.info(logMsg);
                  return deleteRecursively;
            }
            catch (IOException ex)
            {
                  log.error(errLogMsg);
                  return false;
            }
      }
}
