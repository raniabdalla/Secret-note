package org.launchcode.secretnote.data;


import org.launchcode.secretnote.models.SecretNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends CrudRepository<SecretNote, UUID> {
}
