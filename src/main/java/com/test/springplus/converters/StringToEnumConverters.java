package com.test.springplus.converters;

import org.springframework.core.convert.converter.Converter;

import com.test.springplus.model.Gender;

public class StringToEnumConverters implements Converter<String,Gender>{

	@Override
	public Gender convert(String source) {
		// TODO Auto-generated method stub
		if(source.equals("Male")) {
			return Gender.MALE;
		}
		else if(source.equals("Female"))
		{
			return Gender.FEMALE;
		}
		else {
			return Gender.OTHERS;
		}
	}

}
