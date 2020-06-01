package com.sujit.bfo.utility;

import java.util.ArrayList;

public class Response {
	int status;
	ArrayList result;
	String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList getResult() {
		return result;
	}
	public void setResult(ArrayList result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Response [status=" + status + ", result=" + result + ", message=" + message + "]";
	}
	
	

}
