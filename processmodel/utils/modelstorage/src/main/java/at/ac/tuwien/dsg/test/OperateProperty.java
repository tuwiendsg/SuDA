/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.test;




/**
 *
 * @author Anindita
 */
public class OperateProperty {
    
    public String getGraphStorageURI()
    {
    //return "jdbc:virtuoso://localhost:1111";
        return "jdbc:virtuoso://128.130.172.230:1111";
        //return "jdbc:virtuoso://10.99.0.9:1111";
    
    }
    
    public String getGraphStorageUserName()
    {
        return "dba";
    }
    
    public String getGraphStoragePassword()
    {
        return "dba";
    }
    
     /*public String getrdfURI()
    {
        return "http://DataAnalyticServiceUnit.com";
    }*/
    
    
}
