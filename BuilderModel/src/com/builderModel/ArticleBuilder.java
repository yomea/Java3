package com.builderModel;

public class ArticleBuilder implements Builder {
	
	Article article = new Article();

	@Override
	public void BuildPart1() {
		article.setTitle("hello");
		
	}

	@Override
	public void BuildPart2() {
		article.setContent("world");
	}

	@Override
	public Product getProduct() {
		return article;
	}

}
