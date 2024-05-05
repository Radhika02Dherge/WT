import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
public class BookServlet extends HttpServlet {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Connection con = null;
 Statement stmt = null;
 ResultSet rs = null;

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 try ( PrintWriter out = response.getWriter()) {

 Class.forName("com.mysql.jdbc.Driver");
 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
 stmt = con.createStatement();
 rs = stmt.executeQuery("select * from books;");

 out.println("<html>");
 out.println("<head><title>Books</title>");
 out.println("<style>");
 out.println("body {font-family: 'Inter';}");
 out.println("table { width: 100%; border-collapse: collapse; }");
 out.println("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
 out.println("th { background-color: #f2f2f2; }");
 out.println("tr:hover { background-color: #f5f5f5; }");
 out.println("</style>");
 out.println("</head>");
 out.println("<body>");
 out.println("<h1>Books</h1>");
 out.println("<table border='1'>");
 out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");
 while (rs.next())
 {
 String id = String.valueOf(rs.getInt("book_id"));
 String title = rs.getString("book_title");
 String author = rs.getString("book_author");
 String price = String.valueOf(rs.getInt("book_price"));
 String quantity = String.valueOf(rs.getInt("quantity"));

 out.println("<tr><td>" + id + "</td><td>" + title + "</td><td>" + author + "</td><td>" + price +
"</td><td>" + quantity + "</td></tr>");
 }
 out.println("</table>");
 out.println("</html></body>");
 con.close();
 }
 catch (Exception e) {
 e.printStackTrace();
 }
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 }
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 }
 @Override
 public String getServletInfo() {
 return "Short description";
 }
}