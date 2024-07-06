package repositoriess;

import model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationJPARepository extends JpaRepository<Registration, Long>  {}
