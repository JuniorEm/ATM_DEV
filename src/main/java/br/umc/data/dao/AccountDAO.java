package br.umc.data.dao;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.umc.data.entity.Account;

@Repository
public interface AccountDAO extends EntityRepository<Account, Long> {
	
	Account findByAccountNumberAndPinNumber(final String accountNumber, final String pinNumber);
}
