package com.intreview.assessment.ATM.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intreview.assessment.ATM.exception.atmException;
import com.intreview.assessment.ATM.model.Account;
import com.intreview.assessment.ATM.model.BankDataBase;
import com.intreview.assessment.ATM.model.Note;

@Service
public class BankFuncUtil implements BankFuncService {
	
	
	CashReserve cashReserve;
	
	BankDataBase bankDataBase;

	@Override
	public Account getAccountByIdAndPin(int id, int pin) throws atmException {
		ArrayList<Account> accounts = bankDataBase.getRegisteredAccounts();
		Optional<Account> realAccount = accounts.stream().distinct()
	            .filter(p -> p.getAccountId()==id)
	            .findFirst();
		if(realAccount.isPresent()) {
			if(realAccount.get().getPin()==pin) {
				return realAccount.get();
			}else {
				throw new atmException("The account does not exist");
			}
				
		}else {
			throw new atmException("You have entered the wrong pin");
		}
		
	}

	@Override
	public ArrayList<Note> getWithdrawal(Account account, int withdrawAmount) throws atmException {
		if(account.getTotalWithdrawal()>withdrawAmount) {
			account.setBalance(account.getBalance()-withdrawAmount);
			return cashReserve.withdraw(withdrawAmount);
		}else {
			throw new atmException("You have insufficient funds");
		}
		
	}

}
