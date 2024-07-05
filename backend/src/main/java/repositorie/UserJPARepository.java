package repositorie;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}
