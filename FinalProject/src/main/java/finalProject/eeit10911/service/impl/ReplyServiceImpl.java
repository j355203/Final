package finalProject.eeit10911.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10911.dao.ReplyDao;
import finalProject.eeit10911.model.Reply;
import finalProject.eeit10911.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	ReplyDao dao;

	@Autowired
	public void setDao(ReplyDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public Integer insert(Reply RB) {
		return dao.insert(RB);
	}

	@Transactional
	@Override
	public String delete(Integer replyID) {
		return dao.delete(replyID);
	}

	@Transactional
	@Override
	public Reply findByReplyID(Integer replyID) {
		return dao.findByReplyID(replyID);
	}

	@Transactional
	@Override
	public List<Reply> selectReplyByArticleID(Integer articleID) {
		return dao.selectReplyByArticleID(articleID);
	}

	@Transactional
	@Override
	public Reply update(Reply RB) {
		return dao.update(RB);
	}

	@Transactional
	@Override
	public String deleteFromArticleId(Integer articleId) {
		return dao.deleteFromArticleId(articleId);
	}

}
