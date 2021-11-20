package in.co.vwits.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.co.vwits.onlinebanking.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer> {

}
