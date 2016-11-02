package com.adapterModel.instanceAdapter;

public class CPower implements ChinaPower {
	
	private AmericaPower ap = new APower();

	@Override
	public void twoStep() {
		
		ap.threeStep();

	}

}
