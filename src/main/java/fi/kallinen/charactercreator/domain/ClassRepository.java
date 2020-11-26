package fi.kallinen.charactercreator.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Chclass, Long> {
	List<Chclass> findByClname(String clname);
}
