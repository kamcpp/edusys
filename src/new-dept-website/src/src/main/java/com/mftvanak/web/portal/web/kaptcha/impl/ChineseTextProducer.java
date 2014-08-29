package com.mftvanak.web.portal.web.kaptcha.impl;

import java.util.Random;

import com.mftvanak.web.portal.web.kaptcha.TextProducer;

public class ChineseTextProducer implements TextProducer {
	private String[] simplifiedChineseTexts = new String[] { "包括焦点", "新道消点",
			"服分目搜", "索姓名電", "子郵件信", "主旨請回", "電子郵件", "給我所有", "討論區明", "發表新文",
			"章此討論", "區所有文", "章回主題", "樹瀏覽搜" };

	public String getText() {
		return simplifiedChineseTexts[new Random()
				.nextInt(simplifiedChineseTexts.length)];
	}
}
