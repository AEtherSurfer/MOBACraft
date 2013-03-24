package com.aethercraft.moba;

@SuppressWarnings("serial")
public class MOBACraftException extends RuntimeException {
	public MOBACraftException(String msg, Exception e) {
		super(msg, e);
	}
}
