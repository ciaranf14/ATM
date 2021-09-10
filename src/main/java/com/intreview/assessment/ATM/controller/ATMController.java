package com.intreview.assessment.ATM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intreview.assessment.ATM.exception.atmException;
import com.intreview.assessment.ATM.model.Account;
import com.intreview.assessment.ATM.model.Note;
import com.intreview.assessment.ATM.service.BankFuncService;

@RestController("/atm")
public class ATMController {
	
	@Autowired
	BankFuncService bankFuncService;
	
	@GetMapping("/{account}/{pin}")
	public Account getAccount(@PathVariable(value="account") Integer account, @PathVariable(value="pin") Integer pin) throws atmException {
		return bankFuncService.getAccountByIdAndPin(account, pin);
	}
	
	@GetMapping("/{account}/{pin}/{withdraw}")
	public List<Note> withdraw(@PathVariable(value="account") Integer account, @PathVariable(value="pin") Integer pin,@PathVariable(value="withdrawAmmount") Integer withdrawAmmount) throws atmException{
		return bankFuncService.getWithdrawal(bankFuncService.getAccountByIdAndPin(account, pin), withdrawAmmount);
	}
}
