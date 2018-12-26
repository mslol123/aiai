package com.jxky.bgxs.service.wjt;

import com.jxky.bgxs.entity.BookSearch;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class SearchService {
    @Autowired
    private SolrClient solrClient;
    public List<BookSearch> findAllSearch(String keyword){
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q","bookName:"+keyword+"* typeName:"+keyword+"* infoNickname:"+keyword+"* bookContent:"+keyword);
        try {
            QueryResponse query = solrClient.query(solrQuery);
            SolrDocumentList results = query.getResults();
            List<BookSearch> bookMessageList = solrClient.getBinder().getBeans(BookSearch.class, results);
            return bookMessageList;
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
