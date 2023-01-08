<%@ page import="java.util.List, com.project.Bookshop.entity.Book,com.project.Bookshop.entity.User"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Bookshop</title>
</head>
<body>
<%
	List<Book> books = (List<Book>)request.getAttribute("allBooks");
	User user=(User)request.getAttribute("user");
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="#">BookShop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					
					
				</ul>
				<div>
					<a class="nav-link text-white" href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</nav>
<br>
<br>

	<div class="container ">
	<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Title</th>
      <th scope="col">Book Id</th>
      <th scope="col">Author</th>
      <th scope="col">Publication</th> 
      <th scope="col">Add to Favorites</th>
      <th scope="col">Add to Read Later</th>
    </tr>
  </thead>
  <tbody>
      <% for(int i = 0; i < books.size(); i++) {%>
  
  <tr>
      <th scope="row"><%=i+1 %></th>
      <td><%=books.get(i).getTitle() %></td>
      <td><%=books.get(i).getBook_id() %></td>
      <td><%=books.get(i).getAuthor() %></td>
       <td><%=books.get(i).getPublication() %></td>
      <td><a href = "/fav/<%=books.get(i).getBook_id() %>/<%=user.getUsername()%>">Add to Favorites</a></td>
      <td><a href = "/readlater/<%=books.get(i).getBook_id() %>/<%=user.getUsername() %>">Add to Read Later</a></td>
    </tr>
  <%} %>
  </tbody>
</table>
		
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>

</body>
</html>