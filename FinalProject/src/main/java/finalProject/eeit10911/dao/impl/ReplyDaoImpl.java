package finalProject.eeit10911.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10911.dao.ReplyDao;
import finalProject.eeit10911.model.Reply;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Integer insert(Reply RB) {
		int replyId = (Integer) this.factory.getCurrentSession().save(RB);
		return replyId;
	}

	@Override
	public String delete(Integer replyID) {
		Reply bean = (Reply) factory.getCurrentSession().get(Reply.class, replyID);
		if (bean != null) {
			factory.getCurrentSession().delete(bean);
			return "Success";
		}
		return "False";
	}

	@Override
	public Reply findByReplyID(Integer replyID) {
		return factory.getCurrentSession().get(Reply.class, replyID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> selectReplyByArticleID(Integer articleID) {
		String sql = "from Reply where articleID = :id";
		Query query = factory.getCurrentSession().createQuery(sql).setParameter("id", articleID);
		return (List<Reply>) query.getResultList();
	}

	@Override
	public Reply update(Reply RB) {
		Reply result = (Reply) factory.getCurrentSession().get(Reply.class, RB.getReplyId());
		if (result != null) {
			result.setReplyContent(RB.getReplyContent());
			return result;
		}
		return null;
	}

	@Override
	public String deleteFromArticleId(Integer articleId) {
		Reply bean = (Reply) factory.getCurrentSession().get(Reply.class, articleId);
		if (bean != null) {
			factory.getCurrentSession().delete(bean);
			return "Success";
		}
		return "False";
	}

}
