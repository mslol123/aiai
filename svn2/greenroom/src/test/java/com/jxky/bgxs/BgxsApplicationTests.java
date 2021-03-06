package com.jxky.bgxs;

import com.jxky.bgxs.dao.BookDataDAO;
import com.jxky.bgxs.dao.ChapterDAO;
import com.jxky.bgxs.entity.BookData;
import com.jxky.bgxs.entity.Chapter;
import com.jxky.bgxs.util.MinMonthHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BgxsApplicationTests {
//	@Autowired
//	private BookMessageDAO bookMessageDAO;
//	@Autowired
//	private MessageDAO messageDAO;
//	@Autowired
//	private BookShelfDAO bookShelfDAO;
	@Autowired
	private SolrClient solrClient;
	@Autowired
	private BookDataDAO bookDataDAO;
	@Autowired
	private ChapterDAO chapterDAO;
	@Autowired
	private MinMonthHelper monthHelper;
	@Test
	public void bookDataTest(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<--------------->>>>>>>>>>>>>>>>>>>>>>>");
		List<BookData> list=bookDataDAO.findAll();
		System.out.println(list);
	}

	@Test
	public void test1(){
		List<Chapter> lat = chapterDAO.findLastByDate(1, monthHelper.getLastFrom(), monthHelper.getLastTo());
		System.out.println(lat);
	}

	@Test
	public void bookMessageTest() {
//		List<BookMessage> list = bookMessageDAO.findBookByUserId(1);
//		System.out.println(list);
//		BookMessage daoById = bookMessageDAO.findById(1);
//		System.out.println(daoById);
	}
	@Test
	public void messageTest(){
//		Message message = new Message();
//		message.setSendUser(1);
//		message.setAcceptUser(2);
//		message.setMesageTheme("你好");
//		message.setMessageContent("Hello Word");
//		messageDAO.insert(message);
//		List<Message> list = messageDAO.findBySendUserId(1);
//		System.out.println(list);
	}
	@Test
	public void bookShelfTest(){
//		bookShelfDAO.insert(2,4);
	}
	@Test
	public void solrTest(){
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("q","typeName:aa* bookName:aa*");
		try {
			QueryResponse query = solrClient.query(solrQuery);
			SolrDocumentList results = query.getResults();
			for (SolrDocument result : results) {
				System.out.println(result.get("bookName"));
				System.out.println(result.get("infoNickname"));
				System.out.println(result.get("bookContent"));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
