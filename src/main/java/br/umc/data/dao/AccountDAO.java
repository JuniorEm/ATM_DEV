package br.umc.data.dao;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import br.umc.data.entity.Account;

@Repository
public interface AccountDAO extends EntityRepository<Account, Long> {
	
	@Query(singleResult = SingleResultType.OPTIONAL)
	Account findByAccountNumberAndPinNumber(final String accountNumber, final String pinNumber);
	
	@Query(singleResult = SingleResultType.OPTIONAL)
	Account findByAccountNumber(final String accountNumber);
}
