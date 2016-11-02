package com.adapterModel.classAdapter;

public class CPower extends APower implements ChinaPower {

	@Override
	public void twoStep() {
		
		this.threeStep();

	}

}
