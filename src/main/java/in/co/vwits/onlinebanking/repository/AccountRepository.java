package in.co.vwits.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.co.vwits.onlinebanking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	List<Account> findByaccountStatus(String status);

	Account findByuserid(Integer userId);
}
