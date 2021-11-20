package in.co.vwits.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.co.vwits.onlinebanking.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
