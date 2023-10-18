package user.details.library.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import user.details.library.model.User;

public interface UserRepository  extends JpaRepository<User,Integer> {

}
