/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richtercloud.solr.bean.indexing;

import org.apache.solr.client.solrj.beans.Field;

/**
 *
 * @author richter
 */
public class MyBean {
    
    @Field
    private String property1;
    @Field
    private String property2;
    private int property3;

    public MyBean() {
    }

    public MyBean(String property1, String property2, int property3) {
        this.property1 = property1;
        this.property2 = property2;
        this.property3 = property3;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public int getProperty3() {
        return property3;
    }

    public void setProperty3(int property3) {
        this.property3 = property3;
    }
}
