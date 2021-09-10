package com.intreview.assessment.ATM.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.intreview.assessment.ATM.exception.atmException;
import com.intreview.assessment.ATM.model.Note;
@Service
public class CashReserve {
	
	//i need a method to create 1500 with a set amount of notes
	private static final int initialReserve = 1500;
	
	public int currentReserve = 0;
	CashReserve() throws atmException{
	ArrayList<Note> initalNotes = new ArrayList<Note>();
	for(int i=0;i<9;i++) {
		initalNotes.add(Note.FIFTY);
	}
	for(int i=0;i<29;i++) {
		initalNotes.add(Note.TWENTY);
	}
	for(int i=0;i<29;i++) {
		initalNotes.add(Note.TEN);
	}
	for(int i=0;i<19;i++) {
		initalNotes.add(Note.FIVE);
	}
	
	createReserve(initalNotes);
	}
	public void createReserve(ArrayList<Note>Notes) throws atmException{
		for(Note note: Notes) {
			currentReserve=+note.getValue();
		}
//		if(currentReserve!=initialReserve){
//			throw new atmException("Error creating cash reserve");
//		}
		
	}
	public ArrayList<Note> withdraw(int withdrawAmmount) throws atmException {
		if(withdrawAmmount>initialReserve&& withdrawAmmount>currentReserve) {
			throw new atmException("Not enough cash in system");
		}
		ArrayList<Note> notesToDispense = new ArrayList<Note>();
		int currentValue=0;
		int[] noteValues= {50,20,10,5};
		if(currentReserve>withdrawAmmount) {

			      
	         for(int i=0;i<noteValues.length && withdrawAmmount!=0;i++)
	         {
	             if(withdrawAmmount>=noteValues[i])
	                 System.out.println("No of "+noteValues[i]+"'s"+" :"+withdrawAmmount/noteValues[i]);
	             for(int x= 0; x< withdrawAmmount/noteValues[i]; x++) {
	            	 if(noteValues[i]==Note.FIFTY.getValue()) {
	            		 notesToDispense.add(Note.FIFTY);
	            	 }else if (noteValues[i]==Note.TWENTY.getValue()) {
	            		 notesToDispense.add(Note.TWENTY);
	            	 }else if (noteValues[i]==Note.TEN.getValue()) {
	            		 notesToDispense.add(Note.TEN);
	            	 }else if (noteValues[i]==Note.FIVE.getValue()) {
	            		 notesToDispense.add(Note.FIVE);
	            	 }
	             }
	             
	             withdrawAmmount=withdrawAmmount%noteValues[i];
	         }   
			
		}
		return notesToDispense;
	}

	

}
