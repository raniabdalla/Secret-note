package org.launchcode.secretnote.data;

import org.launchcode.secretnote.models.SecretNote;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<SecretNote, Integer> {
}
