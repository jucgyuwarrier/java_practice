package sec03.ex01;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO 
{
private DataSource dataFactory;
Connection conn;
PreparedStatement pstmt;

public BoardDAO() 
{
try
{
	Context ctx = new InitialContext();
	Context envContext = (Context) ctx.lookup("java:/comp/env");
	dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
} catch(Exception e) 
{
e.printStackTrace();	
	}
}
public List selectAllArticles()
{
	List<ArticleVO> articlesList = new ArrayList();
	try 
	{
		conn = dataFactory.getConnection();
		String query = "SELECT function_hierarchical() AS articleNO, @LEVEL AS LEVEL, title, parentNO, imageFileName, content, id, writeDate FROM (SELECT @start_with:=0, @articleNO:=@start_with, @LEVEL:=0) tbl JOIN t_board ORDER BY articleNO";
				
				
				/* "SELECT articleNO, parentNO, title, content, id, writeDate"
				+ " from t_board"
				+ " ORDER BY articleNO DESC"; */
		
		System.out.println(query);
		pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
		 int LEVEL = rs.getInt("LEVEL");
		 int articleNO = rs.getInt("articleNO");
		 int parentNO = rs.getInt("parentNO");
		 String title = rs.getString("title");
		 String imageFileName = rs.getString("imageFileName");
		 String content = rs.getString("content");
		 String id = rs.getString("id");
		 Date writeDate = rs.getDate("writeDate");
		 
		 ArticleVO article = new ArticleVO();
		 article.setLEVEL(LEVEL);
		 article.setarticleNO(articleNO);
		 article.setparentNO(parentNO);
		 article.settitle(title);
		 article.setimageFileName(imageFileName);
		 article.setcontent(content);
		 article.setid(id);
		 article.setwriteDate(writeDate);
		 
		 articlesList.add(article);
		}
		rs.close();
		pstmt.close();
		conn.close();
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	return articlesList;
}

}
