/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.solr.bean.indexing;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

/**
 *
 * @author richter
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SolrClient solrServer;
        solrServer = new HttpSolrClient.Builder("http://localhost:8983/solr/test1")
                .build();
        List<MyBean> myBeans = new LinkedList<>(Arrays.asList(new MyBean("a","1",1),new MyBean("b", "2", 2), new MyBean("c","3",3)));
        String searchTerm = "a";
        try {
            solrServer.addBeans(myBeans);
            solrServer.commit();
            SolrQuery solrQuery = new SolrQuery();
            solrQuery.set("q", searchTerm);
            QueryResponse queryResponse = solrServer.query(solrQuery);
            List<MyBean> foundDocuments = queryResponse.getBeans(MyBean.class);
            System.out.println(foundDocuments);
        } catch (SolrServerException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
