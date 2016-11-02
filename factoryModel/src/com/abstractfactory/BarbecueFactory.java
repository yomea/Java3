package com.abstractfactory;
/**
 * 买烧烤，送水
 * @author may
 *
 */
public class BarbecueFactory extends AbstractFactory {

	@Override
	public MainProduct createMainProduct() {
		return new Barbecue() ;
	}

	@Override
	public FreeProduct createFreeProduct() {
		return new Water();
	}

}
