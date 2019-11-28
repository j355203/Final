package finalProject.eeit10911.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10911.dao.ArticleDao;
import finalProject.eeit10911.model.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Integer insert(Article AB) {
		int articleId = (Integer) this.factory.getCurrentSession().save(AB);
		System.out.println("articleId:" + articleId);
		return articleId;
	}

	@Override
	public Article update(Article AB) {
		Article result = (Article) factory.getCurrentSession().get(Article.class, AB.getArticleId());
		if (result != null) {
			result.setArticleContent(AB.getArticleContent());
			return result;
		}
		return null;
	}

	@Override
	public String delete(Integer articleID) {
		Article bean = (Article) factory.getCurrentSession().get(Article.class, articleID);
		if (bean != null) {
			factory.getCurrentSession().delete(bean);
			return "Success";
		}
		return "False";
	}

	@Override
	public Article findByArticleID(Integer articleID) {
		return factory.getCurrentSession().get(Article.class, articleID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> selectAll() {
		Query query = factory.getCurrentSession().createQuery("from Article order by createDate desc");
		return (List<Article>) query.getResultList();
	}

	@Override
	public Article report(Article AB) {
		Article result = (Article) factory.getCurrentSession().get(Article.class, AB.getArticleId());
		if (result != null) {
			result.setReportStatus(AB.getReportStatus());
			return result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> reportedArticle() {
		String sql = "from Article where reportStatus = 1 order by createDate desc";
		Query query = factory.getCurrentSession().createQuery(sql);
		return (List<Article>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> examinedArticle() {
		String sql = "from Article where reportStatus = 2 order by createDate desc";
		Query query = factory.getCurrentSession().createQuery(sql);
		return (List<Article>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> toBeDeletedArticle() {
		String sql = "from Article where reportStatus = 3 order by createDate desc";
		Query query = factory.getCurrentSession().createQuery(sql);
		return (List<Article>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllArticleClass() {
		String sql = "select distinct articleClass from Article";
		Session session = factory.getCurrentSession();
		List<String> list = new ArrayList<>();
		list = session.createQuery(sql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> selectByArticleClass(String articleClass) {
		String sql = "from Article where articleClass = :articleClass and reportStatus in (0,1,2) order by createDate desc";
		Query query = factory.getCurrentSession().createQuery(sql).setParameter("articleClass", articleClass);
		return (List<Article>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> selectPass() {
		String sql = "from Article where reportStatus in (0,1,2) order by createDate desc";
		Query query = factory.getCurrentSession().createQuery(sql);
		return (List<Article>) query.getResultList();
	}

}
