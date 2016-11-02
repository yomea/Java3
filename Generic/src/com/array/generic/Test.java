package com.array.generic;

public class Test {
/*
	public static void main(String[] args) {
		//下面的代码使用了泛型的数组，是无法通过编译的
		//java不支持泛型数组，因为java的数组赋给一个Object，
		//  那么就可以存放其它泛型的数据，如以下的本来是String的变成了StringBuffer
		//如果编译器不报错，那么String value = ref.getValue()肯定出现问题，出ClassCastException
		 //却不是ArrayStoreException异常，既然有了泛型，这种错误应该不会出现的，但却出现了这和泛型的编译器检查数据类型相悖，所以
		  //官方干脆就不让它支持泛型
		GenTest<String> genArr[] = new GenTest<String>[2];
		Object[] test = genArr;//把它当成Object的数组
		GenTest<StringBuffer> strBuf = new GenTest<StringBuffer>();
		strBuf.setValue(new StringBuffer());
		test[0] = strBuf;//将不同的泛型的同一类型数据存进去
		GenTest<String> ref = genArr[0]; //上面两行相当于使用数组移花接木，让Java编译器把GenTest<StringBuffer>当作了GenTest<String>
		String value = ref.getValue();// 这里是重点！这里肯定会出问题，StringBuffer不会是String
	}
	*/
}
