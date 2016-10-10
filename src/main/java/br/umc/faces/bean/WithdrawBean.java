package br.umc.faces.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.umc.data.dao.AccountDAO;
import br.umc.data.dao.WithdrawValueDAO;
import br.umc.data.entity.Account;
import br.umc.data.entity.WithdrawValue;
import br.umc.faces.model.Withdraw;
import br.umc.faces.util.FacesUtil;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class WithdrawBean implements Serializable {
	@Inject private AccountLoggedBean logged;
	@Inject private WithdrawValueDAO withdrawDAO;
	@Inject private AccountDAO accountDAO;
	private List<WithdrawValue> values;
	private Withdraw withdraw;
	private WithdrawValue selected;
	private Account account;

	@PostConstruct
	public void init() {
		values = withdrawDAO.findAll();
		withdraw = new Withdraw();
		selected = new WithdrawValue();
		account = logged.getAccount();
	}

	public List<WithdrawValue> getValues() {
		return values;
	}

	public WithdrawValue getSelected() {
		return selected;
	}

	public void setSelected(final WithdrawValue selected) {
		this.selected = selected;
	}
	
	public Withdraw getWithdraw() {
		return withdraw;
	}

	public void withdraw() {
		final BigDecimal obtained = withdraw.getValuePostWithdraw(account, selected);
		account.setBalance(obtained);
		accountDAO.save(account);
		
		showConfirmationDialog();
	}

	private void showConfirmationDialog() {
		final RequestContext requestContext = FacesUtil.getRequestContext();
		requestContext.execute("PF('withdraw_confirm').show();");
		requestContext.update("dlg_withdraw");
	}
}
