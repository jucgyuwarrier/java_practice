/*package sec03.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
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
		String query = "SELECT function_hierarchical() AS articleNO, @LEVEL AS LEVEL, parentNO, title, content, id, writeDate FROM (SELECT @start_with:=0, @articleNO:=@start_with, @LEVEL:=0) tbl JOIN t_board ORDER BY articleNO";
	
	System.out.println(query);
	pstmt = conn.prepareStatement(query);
	ResultSet rs = pstmt.executeQuery();
	while (rs.next()) 
	{
		//int LEVEL = rs.getInt("LEVEL");
		int articleNO = rs.getInt("articleNO");
		//int parentNO = rs.getInt("parentNO");
		String title = rs.getString("title");
		//String imageFileName = rs.getString("imageFileName");//
		//String content = rs.getString("content");
		String id = rs.getString("id");
		Date writeDate = rs.getDate("writeDate");
		
		ArticleVO article = new ArticleVO();
		//article.setLEVEL(LEVEL);
		article.setarticleNO(articleNO);
		//article.setparentNO(parentNO);
		article.settitle(title);
		//article.setimageFileName(imageFileName);//
		//article.setcontent(content);
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
private int getNewArticleNO()
{
	try
	{
	 conn =dataFactory.getConnection();
	 String query = "SELECT max(articleNO) from t_board ";
	 System.out.println(query);
	 pstmt = conn.prepareStatement(query);
	 ResultSet rs = pstmt.executeQuery(query);
	 if (rs.next())
		 return (rs.getInt(1) + 1);
	 rs.close();
	 pstmt.close();
	 conn.close();
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
	public void insertNewArticle(ArticleVO article)
	{
		try
	{
			conn = dataFactory.getConnection();
			int articleNO = getNewArticleNO();
			int parentNO = article.getparentNO();
			String title = article.gettitle();
			String content = article.getcontent();
			String id =article.getid();
			String imageFileName = article.getimageFileName();
			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	}
}


*/