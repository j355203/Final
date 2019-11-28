package finalProject.eeit10911.service;

import java.util.List;

import finalProject.eeit10911.model.Article;

public interface ArticleService {
	Integer insert(Article AB);

	Article update(Article AB);

	String delete(Integer articleID);

	Article findByArticleID(Integer articleID);

	List<Article> selectAll();

	Article report(Article AB);

	List<Article> reportedArticle();

	List<Article> examinedArticle();

	List<Article> toBeDeletedArticle();

	List<String> getAllArticleClass();
	
	List<Article> selectByArticleClass(String articleClass);
	
	List<Article> selectPass();
}
