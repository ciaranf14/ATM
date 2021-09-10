package com.intreview.assessment.ATM.service;

import java.util.ArrayList;

import com.intreview.assessment.ATM.exception.atmException;
import com.intreview.assessment.ATM.model.Account;
import com.intreview.assessment.ATM.model.Note;

public interface BankFuncService {
	Account getAccountByIdAndPin(int id, int pin) throws atmException;
	ArrayList<Note> getWithdrawal(Account account, int withdrawAmmount) throws atmException;

}
