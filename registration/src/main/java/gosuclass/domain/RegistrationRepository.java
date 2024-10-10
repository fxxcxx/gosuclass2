package gosuclass.domain;

import gosuclass.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "registrations",
    path = "registrations"
)
public interface RegistrationRepository
    extends PagingAndSortingRepository<Registration, Long> {
    @Query(
        value = "select registration " +
        "from Registration registration " +
        "where(:id is null or registration.id = :id) and (:classId is null or registration.classId = :classId) and (:status is null or registration.status like %:status%)"
    )
    Registration findByMyPage(Long id, Long classId, String status);
}
