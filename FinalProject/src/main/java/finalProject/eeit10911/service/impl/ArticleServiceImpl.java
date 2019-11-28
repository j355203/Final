package finalProject.eeit10911.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10911.dao.ArticleDao;
import finalProject.eeit10911.model.Article;
import finalProject.eeit10911.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	ArticleDao dao;

	@Autowired
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public Integer insert(Article AB) {
		return dao.insert(AB);
	}

	@Transactional
	@Override
	public Article update(Article AB) {
		return dao.update(AB);
	}

	@Transactional
	@Override
	public String delete(Integer articleID) {
		return dao.delete(articleID);
	}

	@Transactional
	@Override
	public Article findByArticleID(Integer articleID) {
		return dao.findByArticleID(articleID);
	}

	@Transactional
	@Override
	public List<Article> selectAll() {
		return dao.selectAll();
	}

	@Transactional
	@Override
	public Article report(Article AB) {
		return dao.report(AB);
	}

	@Transactional
	@Override
	public List<Article> reportedArticle() {
		return dao.reportedArticle();
	}

	@Transactional
	@Override
	public List<Article> examinedArticle() {
		return dao.examinedArticle();
	}

	@Transactional
	@Override
	public List<Article> toBeDeletedArticle() {
		return dao.toBeDeletedArticle();
	}

	@Transactional
	@Override
	public List<String> getAllArticleClass() {
		return dao.getAllArticleClass();
	}

	@Transactional
	@Override
	public List<Article> selectByArticleClass(String articleClass) {
		return dao.selectByArticleClass(articleClass);
	}

	@Transactional
	@Override
	public List<Article> selectPass() {
		return dao.selectPass();
	}

}
