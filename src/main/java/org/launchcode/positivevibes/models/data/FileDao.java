package org.launchcode.positivevibes.models.data;

import org.launchcode.positivevibes.models.File;
import org.springframework.data.repository.CrudRepository;

public interface FileDao extends CrudRepository<File, Long> {
    File findFirstByOrderByIdDesc();
}
