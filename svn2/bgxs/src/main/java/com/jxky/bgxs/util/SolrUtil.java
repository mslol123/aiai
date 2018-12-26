package com.jxky.bgxs.util;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class SolrUtil {
    @Autowired
    private SolrClient solrClient;
    public void updateData(){
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setRequestHandler("/bookmessageimport");
        solrQuery.setParam("command","full-import")
                .setParam("clean", true)
                .setParam("commit", "true");
        try {
            solrClient.query(solrQuery);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
