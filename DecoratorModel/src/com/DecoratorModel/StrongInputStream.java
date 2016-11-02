package com.DecoratorModel;

public class StrongInputStream implements InputStream {
	
	private InputStream inputStream;
	
	public StrongInputStream(InputStream inputStream) {
		
		this.inputStream = inputStream;
	}
	
	
	//读取一个字符
	/**
	 * 增强它的功能
	 */
	@Override
	public int read() {
		int byte1 = inputStream.read();
		byte1 <<= 8;
		int byte2 = inputStream.read();
		int byte3 = byte1 | byte2;
		return byte3;
	}
	


}
