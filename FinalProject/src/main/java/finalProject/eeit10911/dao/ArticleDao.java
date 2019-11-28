package finalProject.eeit10911.dao;

import java.util.List;

import finalProject.eeit10911.model.Article;

public interface ArticleDao {
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
