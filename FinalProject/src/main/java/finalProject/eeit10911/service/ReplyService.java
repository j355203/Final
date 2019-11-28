package finalProject.eeit10911.service;

import java.util.List;

import finalProject.eeit10911.model.Reply;

public interface ReplyService {
	Integer insert(Reply RB);

	String delete(Integer replyID);

	Reply findByReplyID(Integer replyID);

	List<Reply> selectReplyByArticleID(Integer articleID);
	
	Reply update(Reply RB);
	
	String deleteFromArticleId(Integer articleId);
}
