package com.achievo.springmvc.common;

import java.beans.PropertyEditorSupport;

import com.achievo.springmvc.entity.User;

public class MyPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		String[] textArray = text.split(",");
		user.setName(textArray[0]);
		user.setAge(Integer.parseInt(textArray[1]));
		this.setValue(user);
	}

	public static void main(String[] args) {
		MyPropertyEditor editor = new MyPropertyEditor();
		editor.setAsText("tom,22");
		System.out.println(editor.getValue());
	}

}
