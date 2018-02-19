package com.exception;

public class CustomException  extends Exception{
	/**
	 * This class provides custom
	 * way of handling exceptions.
	 * 
	 * 
	 *
	 */	
		private static final long serialVersionUID = 1L;
		
		public String errorMessage; 
		
		/**
		 * This constructor assigns the 
		 * exception message, when the 
		 * exception is handled using this
		 * class. It takes 1 parameter message.
		 * 
		 * 
		 * @param message
		 */
		public CustomException(String message){
			errorMessage = message;
		}
		
		
		/**
		 * toString is an overridden function 
		 * to convert the exception thrown. 
		 * 
		 */
		@Override
		public String toString() {
		 
			return super.toString();
		}
		
		
		/**
		 * getErrorMessage function is used to 
		 * print the error message thrown from 
		 * a class where it is handled.
		 */
		public void getErrorMessage()
		{
			System.out.println(errorMessage);
		}
		

	}

