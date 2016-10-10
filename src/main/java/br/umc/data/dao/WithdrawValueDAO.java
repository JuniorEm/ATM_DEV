package br.umc.data.dao;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.umc.data.entity.WithdrawValue;

@Repository
public interface WithdrawValueDAO extends EntityRepository<WithdrawValue, Long> {}
