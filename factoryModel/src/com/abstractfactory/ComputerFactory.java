package com.abstractfactory;

/**
 * 买台电脑，送鼠标垫
 * @author may
 *
 */
public class ComputerFactory extends AbstractFactory {
	
	@Override
	public MainProduct createMainProduct() {
		return new Computer();
	}

	@Override
	public FreeProduct createFreeProduct() {
		return new Mousepad();
	}

}
