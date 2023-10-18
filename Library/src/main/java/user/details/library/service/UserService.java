package user.details.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.details.library.model.User;
import user.details.library.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> listAll() {
        return repo.findAll();
    }
    public void save(User user) {
        repo.save(user);
    }
    public User get(int id) {
        return repo.findById(id).orElse(null);
    }
    public void delete(int id){
        repo.deleteById(id);
    }
    }




