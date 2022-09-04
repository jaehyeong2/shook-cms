package jjfactory.shookcms.busniess.repository.user;

import jjfactory.shookcms.busniess.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
