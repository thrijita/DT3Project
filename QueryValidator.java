package com.niit.csvparse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.*;
//class to check the query and execute the query
public class QueryValidator 
{
	public DataSetter executeQuery(String queryString) throws Exception
	{
		if (isValidQueryString(queryString)) 
		{ 
			//QueryParamater should contains properties and setter/getter methods only
			//No other logic should be present in this class
			
			//Only one method need to call from JUnit
			QueryParameter queryParam=new QueryParameter(queryString);
			QueryProcessor queryProcessor=new QueryProcessor(queryParam);
			return queryProcessor.getDataSetSimpleQuery();
		} 
		
		return null;
		
	}

	private boolean isValidQueryString(String queryString) 
	{
		if(queryString.contains("select") && queryString.contains("from") || (queryString.contains("where") ||queryString.contains("order by")|| queryString.contains("group by")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
